package groot.workflow.code.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import groot.workflow.code.dao.base.NodeMapper;
import groot.workflow.code.dao.expansion.NodeMapperEx;
import groot.workflow.code.model.base.Node;
import groot.workflow.code.model.extension.NodeDto;
import groot.workflow.code.service.service.NodeService;
import groot.workflow.constants.Constants;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/1
 */
@Service
public class NodeServiceImpl extends ServiceImpl<NodeMapper, Node> implements NodeService {

    @Autowired
    private NodeMapper nodeMapper;

    @Autowired
    private NodeMapperEx nodeMapperEx;


    @Override
    public boolean create(NodeDto source) {
        NodeDto target = new NodeDto();
        BeanUtils.copyProperties(source, target);
        NodeDto.buildInitial(target);
        return super.save(target);
    }

    @Override
    public List<NodeDto> query(Map<String, Object> queryValue) {
        queryValue.put("node_flag", 1);
        List<Node> dataList = nodeMapper.selectByMap(queryValue);
        List<NodeDto> result = new ArrayList<>();
        dataList.forEach(e -> {
            NodeDto target = new NodeDto();
            BeanUtils.copyProperties(e, target);
            result.add(target);
        });
        return result;
    }

    @Override
    public boolean modify(NodeDto nodeDto) {
        return super.save(nodeDto);
    }

    @Override
    public int upsert(NodeDto source) {
        NodeDto target = new NodeDto();
        BeanUtils.copyProperties(source, target);
        NodeDto.buildInitial(target);
        return nodeMapperEx.upsert(target);
    }

    @Override
    public int delete(NodeDto nodeDto) {
        return 0;
    }

    @Override
    public NodeDto queryByNodeKey(String nodeCode) {
        return (NodeDto) super.getById(nodeCode);
    }

    @Override
    public NodeDto queryByNodeCode(String nodeCode) {
        return NodeDto.doToDto(queryByNodeKey(nodeCode));
    }

    @Override
    public NodeDto queryPrev(String nodeCode) {
        return queryByNodeCode(queryByNodeCode(nodeCode).getNodePrev());
    }

    @Override
    public NodeDto queryNext(String nodeCode) {
        return queryByNodeCode(queryByNodeCode(nodeCode).getNodeNext());
    }

    @Override
    public NodeDto queryHead(String wfCode) {
        Map<String, Object> queryValue = new HashMap<>(10);
        queryValue.put("node_flag", 1);
        queryValue.put("workflow_code_and_node_code", wfCode);
        queryValue.put("node_classify", Constants.WorkflowConstans.HEAD_NODE);
        return query(queryValue).get(0);
    }
}
