package groot.workflow.code.model.extension;

import groot.workflow.code.model.base.Node;
import lombok.Data;

import java.util.Date;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/24
 */
@Data
public class NodeVo {

    /**
     * 节点名称
     */
    private String nodeName;

    /**
     * 审核结果
     */
    private String status;

    /**
     * 申请人
     */
    private String applicant;

    /**
     * 申请时间
     */
    private Date applicationTime;

    /**
     * 审核人或组织、角色
     */
    private String reviewer;

    /**
     * 审核时间
     */
    private Date reviewTime;

    /**
     * (是否自动审核）0.否 1.是
     * <p>
     * Table:     node
     * Column:    node_auto_check
     * Nullable:  true
     */
    private Integer nodeAutoCheck;
    /**
     * 审核意见
     */
    private String remark;

    public static NodeVo buildNodeVo(Node node){
        NodeVo nodeVo = new NodeVo();
        nodeVo.setNodeName(node.getNodeName());
        return nodeVo;
    }

    public static NodeVo buildNodeVo(WorkOrderDto workOrderDto) {
        NodeVo nodeVo = new NodeVo();
        String status = "";
        if (workOrderDto != null) {
            if (workOrderDto.getWoStatus() == 1) {
                status = "审核中";
            }
            if (workOrderDto.getWoStatus() == 2) {
                status = "已审核";
            }
            if (workOrderDto.getWoStatus() == 3) {
                status = "已回退";
            }
            nodeVo.setApplicant(workOrderDto.getWoApplicant());
            nodeVo.setReviewer(workOrderDto.getWoReviewers());
            nodeVo.setApplicationTime(workOrderDto.getWoCreatetime());
            nodeVo.setReviewTime(workOrderDto.getWoUpdatetime());
            nodeVo.setRemark(workOrderDto.getWoRemark());
        } else {
            status = "未开始";
        }
        nodeVo.setStatus(status);
        return nodeVo;
    }

}
