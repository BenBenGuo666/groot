package groot.workflow.code.model.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Table: work_order
 */
@Data
public class WorkOrder implements Serializable {
    /**
     * 工单唯一标识
     *
     * Table:     work_order
     * Column:    wo_code
     * Nullable:  false
     */
    private String woCode;

    /**
     * 流程节点唯一标识
     *
     * Table:     work_order
     * Column:    node_code
     * Nullable:  false
     */
    private String nodeCode;

    /**
     * -1.失效的 0.待开始 1.审核中 2.已审核 3.已回退 4.已挂起 5.已阻塞 6.等待中
     *
     * Table:     work_order
     * Column:    wo_status
     * Nullable:  true
     */
    private Integer woStatus;

    /**
     * 审核人
     *
     * Table:     work_order
     * Column:    wo_reviewers
     * Nullable:  true
     */
    private String woReviewers;

    /**
     * 工单现状
     *
     * Table:     work_order
     * Column:    wo_situation
     * Nullable:  true
     */
    private String woSituation;

    /**
     * 工单创建时间
     *
     * Table:     work_order
     * Column:    wo_createtime
     * Nullable:  true
     */
    private Date woCreatetime;

    /**
     * 工单更新时间
     *
     * Table:     work_order
     * Column:    wo_updatetime
     * Nullable:  true
     */
    private Date woUpdatetime;

    /**
     * 0.删除的 1.正常的
     *
     * Table:     work_order
     * Column:    wo_flag
     * Nullable:  true
     */
    private Integer woFlag;

    /**
     * 工单备注
     *
     * Table:     work_order
     * Column:    wo_remark
     * Nullable:  true
     */
    private String woRemark;

    /**
     * 流程实例唯一标识
     *
     * Table:     work_order
     * Column:    wf_instance_code
     * Nullable:  false
     */
    private String wfInstanceCode;

    /**
     * 业务表单编码
     *
     * Table:     work_order
     * Column:    business_code
     * Nullable:  true
     */
    private String businessCode;

    /**
     * 表单申请人，发起人
     *
     * Table:     work_order
     * Column:    wo_applicant
     * Nullable:  true
     */
    private String woApplicant;

    private static final long serialVersionUID = 1L;


    private String orgName;
}