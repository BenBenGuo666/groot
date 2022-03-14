package groot.workflow.code.service.client;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import groot.workflow.code.dao.base.NodeMapper;
import groot.workflow.code.dao.base.WorkflowInstanceMapper;
import groot.workflow.code.model.base.Node;
import groot.workflow.code.model.base.WorkflowInstance;
import groot.workflow.code.model.extension.*;
import groot.workflow.code.service.business.WorkflowBusiness;
import groot.workflow.code.service.business.WorkflowInstanceBusiness;
import groot.workflow.code.service.service.WorkOrderService;
import groot.workflow.util.CollectionUtil;
import groot.workflow.util.LogicResult;
import groot.workflow.util.MapUtils;
import groot.workflow.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/24
 */
@Component
public class WorkflowClient {

    @Autowired
    private WorkflowBusiness workflowBusiness;

    @Autowired
    private WorkflowInstanceBusiness workflowInstanceBusiness;

    @Autowired
    private WorkOrderService workOrderService;

    @Autowired
    private NodeMapper nodeMapper;

    @Autowired
    private WorkflowInstanceMapper workflowInstanceMapper;


    /**
     * 查询所有流程信息
     * 查询条件：wfCode | null
     *
     * @param vo
     * @return
     */
    public List<WorkflowDto> queryWorkflow(WorkflowVo vo) {
        Map<String, Object> queryMap = new HashMap<>(10);
        MapUtils.setValue(queryMap, "wf_code", vo.getWfCode());
        MapUtils.setValue(queryMap, "wf_status", vo.getWfStatus());
        List<WorkflowDto> result = workflowBusiness.queyWorkFlow(queryMap);
        return result;
    }

    /**
     * 创建流程实例
     * 申请参数(*可选)：申请人->applicant,业务编码->businessCode,流程编号->wfCode,*备注->remark
     *
     * @param vo
     * @return businessCode：业务编号，wfInstanceCode 流程实例编号，woCode 工单编号
     */
    public LogicResult createInstance(WorkflowInstanceVo vo) {
        LogicResult result = LogicResult.builder().build();
        VerifyModel verify = Verify.verifyCreateWfInstance(vo);
        if (!verify.getVerify()) {
            return result.fail(verify.getMessage());
        }
        WorkflowInstanceDto dto = new WorkflowInstanceDto();
        dto.setWoApplicant(vo.getApplicant());
        dto.setBusinessCode(vo.getBusinessCode());
        dto.setWfCode(vo.getWfCode());
        dto.setWfInstanceRemark(vo.getRemark());
        WorkflowInstanceDto data = workflowInstanceBusiness.createWorkflowInstance(dto);
        result.setMessage("流程实例创建成功");
        Map<String, Object> resultData = new HashMap<>();
        resultData.put("businessCode", data.getBusinessCode());
        resultData.put("wfInstanceCode", data.getWfInstanceCode());
        resultData.put("woCode", (data.getWorkOrderDto() == null) ? null : data.getWorkOrderDto().getWoCode());
        return result.complete(resultData);
    }

    /**
     * 审核工单
     * 参数(*可选)：审核人->reviewers，流程实例编号 -> wfInstanceCode,工单编号->woCode,工单状态-> status(-1.终止,2.已审核,3.已回退)
     *
     * @return businessCode 业务编号，wfInstanceCode 流程实例编号,woCode 工单编号
     */
    public LogicResult review(WorkflowInstanceVo vo) {
        LogicResult result = LogicResult.builder().build();
        VerifyModel verify = Verify.verifyReview(vo);
        if (!verify.getVerify()) {
            return result.fail(verify.getMessage());
        }
        WorkflowInstanceDto dto = new WorkflowInstanceDto();
        dto.setWfInstanceCode(vo.getWfInstanceCode());
        dto.setWoCode(vo.getWoCode());
        dto.setWoStatus(Integer.valueOf(vo.getStatus()));
        dto.setReviewers(vo.getReviewers());
        dto.setWoApplicant(vo.getReviewers());
        dto.setWfInstanceRemark(vo.getRemark());
        dto = workflowInstanceBusiness.review(workflowInstanceBusiness.buildWorkflowInstance(dto));
        Map<String, Object> resultData = new HashMap<>();
        resultData.put("businessCode", dto.getBusinessCode());
        resultData.put("wfInstanceCode", dto.getWfInstanceCode());
        resultData.put("woCode", (dto.getWorkOrderDto() == null) ? null : dto.getWorkOrderDto().getWoCode());
        return result.complete(resultData);
    }

    private String setNodeVo(String nodeCode, Map<String, Node> nodeCache, List<NodeVo> data) {
        Node node = nodeCache.get(nodeCode);
        if (node == null || (StringUtil.isNotEmpty(node.getNodeClassify()) && "TAIL".equals(node.getNodeClassify()))) {
            return nodeCode;
        }
        data.add(NodeVo.buildNodeVo(node));
        return setNodeVo(node.getNodeCode(), nodeCache, data);
    }

    /**
     * 查询流程进度
     * 入参: 流程实例编号 -> wfInstanceCode
     *
     * @param vo
     * @return
     */
    public LogicResult progress(WorkflowInstanceVo vo) {
        LogicResult result = LogicResult.builder().build();
        List<NodeVo> data = new ArrayList<>();
        Map<String, Object> queryValue = new HashMap<>(10);
        queryValue.put("wf_instance_code", vo.getWfInstanceCode());
        queryValue.put("orderByClause", "a.wo_createtime, a.wo_updatetime, a.wo_code");
        List<WorkOrderDto> workOrderDtoList = workOrderService.queryAll(queryValue);

        WorkflowInstance workflowInstance = workflowInstanceMapper.selectById(vo.getWfInstanceCode());
        List<Node> nodeList = nodeMapper.selectList(new QueryWrapper<Node>().eq("workflow_code_and_node_code", workflowInstance.getWfCode()).eq("node_flag", 1));
        Map<String, Node> nodeCache = nodeList.stream().collect(Collectors.toMap(e -> e.getNodePrev(), e -> e));
        Map<String, Node> nodeCache2 = nodeList.stream().collect(Collectors.toMap(e -> e.getNodeCode(), e -> e));
        if (CollectionUtil.isNotEmpty(workOrderDtoList)) {
            workOrderDtoList.stream().forEach(e -> {
                        NodeVo nodeVo = NodeVo.buildNodeVo(e);
                        nodeVo.setNodeName(nodeCache2.get(e.getNodeCode()).getNodeName());
                        data.add(nodeVo);
                    }
            );
        }
        if (CollectionUtil.isNotEmpty(data)) {
            setNodeVo(workOrderDtoList.get(workOrderDtoList.size() - 1).getNodeCode(), nodeCache, data);
        } else {
            List<NodeDto> nodeDtoList = NodeDto.sortNodes(NodeDto.buildDtoList(nodeList));
            for (NodeDto e : nodeDtoList) {
                if ("HEAD".equals(e.getNodeClassify()) || "TAIL".equals(e.getNodeClassify())) {
                    continue;
                }
                data.add(NodeVo.buildNodeVo(e));
            }
        }
        return result.complete(data);
    }

    /**
     * 我的工单列表
     *
     * @param vo 入参：申请人 -> applicant
     * @return
     */
    public LogicResult myOrderList(WorkflowInstanceVo vo) {
        return null;
    }
}
