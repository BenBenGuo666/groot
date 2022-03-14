package groot.workflow.code.model.extension;


import groot.workflow.code.model.base.Node;
import groot.workflow.constants.Constants;
import groot.workflow.util.CollectionUtil;
import groot.workflow.util.StringUtil;
import groot.workflow.util.UUIDGenerator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/1
 */
@Data
@Slf4j
public class NodeDto extends Node {

    /**
     * 上个节点
     */
    private NodeDto prev;

    /**
     * 下一节点
     */
    private NodeDto next;
    /**
     * 回退节点
     */
    private NodeDto backed;

    /**
     * 二级节点集合
     */
    private List<NodeDto> childs;

    /**
     * 节点唯一标识
     * <p>
     * Table:     node
     * Column:    node_code
     * Nullable:  false
     */
    private String nodeCode;
    /**
     * 跳转链接
     */
    private String nodeUrl;

    public static NodeDto doToDto(Node source) {
        NodeDto target = new NodeDto();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    public static NodeDto buildStartNode() {
        NodeDto dto = buildInitial(null);
        dto.setNodeName("开始");
        dto.setNodeClassify(Constants.WorkflowConstans.HEAD_NODE);
        dto.setNodeCode(UUIDGenerator.getUUID(Constants.WorkflowConstans.NODE_CODE_PREFIX));
        return dto;
    }

    public static NodeDto buildFinishedNode() {
        NodeDto dto = buildInitial(null);
        dto.setNodeName("结束");
        dto.setNodeClassify(Constants.WorkflowConstans.TAIL_NODE);
        dto.setNodeCode(UUIDGenerator.getUUID(Constants.WorkflowConstans.NODE_CODE_PREFIX));
        return dto;
    }

    public static NodeDto buildInitial(NodeDto obj) {
        if (obj == null) {
            obj = new NodeDto();
        }
        obj.setNodeCreatetime(new Date());
        if (obj.getNodeStatus() == null) {
            obj.setNodeStatus(0);
        }
        if (obj.getNodeType() == null) {
            obj.setNodeType(0);
        }
        if (obj.getNodeFlag() == null) {
            obj.setNodeFlag(Constants.BeansConstans.ENABLED);
        }
        return obj;
    }

    private static boolean verifyLink() {
        return false;
    }

    public static List<NodeDto> modifyNodeLink(NodeDto newNode, List<NodeDto> link) {
        if (StringUtil.isEmpty(newNode.getNodeCode()) || CollectionUtil.isEmpty(link)) {
            return new ArrayList<>();
        }
        NodeDto oldNode = null;
        NodeDto oldNodePrevNode = null;
        NodeDto oldNodeNextNode = null;
        Map<String, NodeDto> nodesCahce = link.stream().collect(
                Collectors.toMap(e -> {
                    if (e.getNodeNext().equals(newNode.getNodeCode())) {
                        BeanUtils.copyProperties(e, oldNodePrevNode);
                    }
                    if (e.getNodePrev().equals(newNode.getNodeCode())) {
                        BeanUtils.copyProperties(e, oldNodeNextNode);
                    }
                    if (e.getNodeCode().equals(newNode.getNodeCode())) {
                        BeanUtils.copyProperties(e, oldNode);
                    }
                    return e.getNodeCode();
                }, e -> e));

        if (oldNode != null) {
            nodesCahce.put(newNode.getNodeCode(), newNode);
            oldNodePrevNode.setNodeNext(oldNodeNextNode.getNodeCode());
            oldNodeNextNode.setNodeCode(oldNodePrevNode.getNodeCode());
            nodesCahce.put(oldNodePrevNode.getNodeCode(), oldNodePrevNode);
            nodesCahce.put(oldNodeNextNode.getNodeCode(), oldNodeNextNode);
        }

        String nextNodeCode = nodesCahce.get(newNode.getNodePrev()).getNodeNext();
        newNode.setNodeNext(nextNodeCode);
        nodesCahce.get(newNode.getNodePrev()).setNodeNext(newNode.getNodeCode());
        nodesCahce.get(newNode.getNodeNext()).setNodePrev(newNode.getNodeCode());

        link = nodesCahce.values().stream()
                .collect(Collectors.toList());
        if (oldNode != null) {
            link.add(newNode);
        }
        return link;
    }

    /**
     * 未来加入递归排序，提供多级节点排序支撑。
     *
     * @param nodeDtoList
     * @return
     */
    public static List<NodeDto> sortNodes(List<NodeDto> nodeDtoList) {
        List<NodeDto> reuslt = new ArrayList<>();
        List<NodeDto> disorder = new ArrayList<>();
        Map<String, NodeDto> nodesCahce = nodeDtoList.stream().collect(Collectors.toMap(e -> {
                    boolean isTail = StringUtil.isNotEmpty(e.getNodeClassify()) && Constants.WorkflowConstans.TAIL_NODE.equals(e.getNodeClassify());
                    boolean isHead = StringUtil.isNotEmpty(e.getNodeClassify()) && Constants.WorkflowConstans.HEAD_NODE.equals(e.getNodeClassify());
                    if (isTail) {
                        return Constants.WorkflowConstans.TAIL_NODE;
                    } else if (StringUtil.isEmpty(e.getNodeParent()) && !isHead && !isTail) {
                        disorder.add(e);
                        return e.getNodeCode();
                    } else {
                        return e.getNodeCode();
                    }
                }, e -> e
        ));
        NodeDto value = nodesCahce.get(Constants.WorkflowConstans.TAIL_NODE);
        if (value == null) {
            log.info("未发现需要排序的节点！");
            return nodeDtoList;
        }
        reuslt.add(value);
        while (value != null && StringUtil.isNotEmpty(value.getNodePrev())) {
            value = nodesCahce.get(value.getNodePrev());
            reuslt.add(value);
        }
        Collections.reverse(reuslt);
        reuslt.addAll(disorder);
        Set set = new LinkedHashSet(reuslt);
        reuslt.clear();
        reuslt.addAll(set);
        return reuslt;
    }

    public static NodeDto buildDto(Node source) {
        NodeDto target = new NodeDto();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    public static List<NodeDto> buildDtoList(List<Node> sourceList) {
        List<NodeDto> targetList = new ArrayList<>();
        if (CollectionUtil.isNotEmpty(sourceList)) {
            sourceList.stream().forEach(e -> {
                targetList.add(buildDto(e));
            });
        }
        return targetList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        NodeDto nodeDto = (NodeDto) o;
        return Objects.equals(nodeCode, nodeDto.nodeCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nodeCode);
    }
}
