package groot.workflow.code.model.extension;

import lombok.Data;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/2
 */
@Data
public class WorkflowInstanceVo {


    /**
     * 表单发起人，申请人
     */
    private String applicant;
    /**
     * 业务编码
     */
    private String businessCode;

    /**
     * 流程编号
     */
    private String wfCode;

    /**
     * 备注
     */
    private String remark;

    /**
     * 审核人
     */
    private String reviewers;

    /**
     * 流程实例 id
     */
    private String wfInstanceCode;

    /**
     * -1.失效的 0.待开始 1.审核中 2.已审核 3.已回退
     */
    private String status;

    /**
     * 工单编号
     */
    private String woCode;

}
