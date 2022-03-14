package groot.workflow.code.service.business.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import groot.workflow.code.dao.base.WorkflowMapper;
import groot.workflow.code.model.base.Workflow;
import groot.workflow.code.model.extension.NodeDto;
import groot.workflow.code.model.extension.WorkflowDto;
import groot.workflow.code.service.business.WorkflowBusiness;
import groot.workflow.code.service.service.NodeService;
import groot.workflow.code.service.service.WorkflowService;
import groot.workflow.constants.Constants;
import groot.workflow.util.CollectionUtil;
import groot.workflow.util.PageUtils;
import groot.workflow.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/1
 */
@Service
@Slf4j
public class WorkflowBusinessImpl extends ServiceImpl<WorkflowMapper, Workflow> implements WorkflowBusiness {


    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private NodeService nodeService;

    /**
     * 创建流程
     *
     * @param workflowDto
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public boolean createWorkFlow(WorkflowDto workflowDto) {
        boolean number = workflowService.create(workflowDto);
        /**
         * 这段代码在未来会抽出用递归
         */
        if (CollectionUtil.isEmpty(workflowDto.getNodes())) {
            // 默认带有开始结束节点
            NodeDto startNode = NodeDto.buildStartNode();
            startNode.setWorkflowCodeAndNodeCode(workflowDto.getWfCode());
            NodeDto endNode = NodeDto.buildFinishedNode();
            endNode.setWorkflowCodeAndNodeCode(workflowDto.getWfCode());
            startNode.setNodeNext(endNode.getNodeCode());
            endNode.setNodePrev(startNode.getNodeCode());
            nodeService.create(startNode);

            nodeService.create(endNode);
            return number;
        }
        List<NodeDto> nodeDtoList = NodeDto.sortNodes(workflowDto.getNodes());
        nodeDtoList.forEach(e -> {
            e.setWorkflowCodeAndNodeCode(workflowDto.getWfCode());
            nodeService.create(e);
        });
        /**
         * 这段代码在未来会抽出用递归
         */
        return number;
    }


    @Override
    public List<WorkflowDto> queyWorkFlow(Map<String, Object> queryMap) {

        List<WorkflowDto> result = workflowService.quey(queryMap);
        result.forEach(e -> {
            queryMap.clear();
            queryMap.put("workflow_code_and_node_code", e.getWfCode());
            List<NodeDto> nodeList = nodeService.query(queryMap);
            if (CollectionUtil.isNotEmpty(nodeList)) {
                nodeList.forEach(n -> {
                    if (StringUtil.isNotEmpty(n.getNodePrev())) {
                        n.setPrev(nodeService.queryByNodeCode(n.getNodePrev()));
                    }
                    if (StringUtil.isNotEmpty(n.getNodeNext())) {
                        n.setNext(nodeService.queryByNodeCode(n.getNodeNext()));
                    }
                    if (StringUtil.isNotEmpty(n.getNodeBacked())) {
                        n.setBacked(nodeService.queryByNodeCode(n.getNodeBacked()));
                    }
                });
            }
            e.setNodes(NodeDto.sortNodes(nodeList));
        });
        return result;
    }

    @Override
    public PageInfo<WorkflowDto> queyWorkFlowPage(Map<String, Object> queryMap) {
        PageInfo<WorkflowDto> info = PageUtils.page(0, Constants.PAGE_SIZE, () -> workflowService.quey(queryMap));
        List<WorkflowDto> result = WorkflowDto.doToDto(info.getList());
        result.forEach(e -> {
            queryMap.clear();
            queryMap.put("workflow_code_and_node_code", e.getWfCode());
            List<NodeDto> nodeList = nodeService.query(queryMap);
            e.setNodes(NodeDto.sortNodes(nodeList));
        });
        info.setList(result);
        return info;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public boolean modifyWorkFlow(WorkflowDto workflowDto) {
        boolean number = workflowService.modifyWorkFlow(workflowDto);
        List<NodeDto> nodeDtoList = workflowDto.getNodes();
        if (CollectionUtil.isEmpty(nodeDtoList)) {
            return number;
        }
        nodeDtoList.forEach(e -> {
            e.setNodeModifytime(new Date());
            e.setWorkflowCodeAndNodeCode(workflowDto.getWfCode());
            nodeService.upsert(e);
        });
        return number;
    }

    @Override
    public boolean deleteWorkFlow(String id) {
        WorkflowDto workflowDto = new WorkflowDto();
        workflowDto.setWfCode(id);
        workflowDto.setWfFlag(Constants.BeansConstans.DELETED);
        return workflowService.modifyWorkFlow(workflowDto);
    }
}
