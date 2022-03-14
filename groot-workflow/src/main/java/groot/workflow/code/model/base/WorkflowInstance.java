package groot.workflow.code.model.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Table: workflow_instance
 */
@Data
public class WorkflowInstance implements Serializable {
    /**
     * 流程实例唯一标识
     *
     * Table:     workflow_instance
     * Column:    wf_instance_code
     * Nullable:  false
     */
    private String wfInstanceCode;

    /**
     * 流程实例创建时间
     *
     * Table:     workflow_instance
     * Column:    wf_instance_createtime
     * Nullable:  true
     */
    private Date wfInstanceCreatetime;

    /**
     * 流程实例更新时间
     *
     * Table:     workflow_instance
     * Column:    wf_instance_updatetime
     * Nullable:  true
     */
    private Date wfInstanceUpdatetime;

    /**
     * 流程实例发起人
     *
     * Table:     workflow_instance
     * Column:    wf_instance_creator
     * Nullable:  true
     */
    private String wfInstanceCreator;

    /**
     * 流程实例状态:-1.失效的 0.进行中 1.已结束 2.挂起 3.中断 4.流程失败
     *
     * Table:     workflow_instance
     * Column:    wf_instance_status
     * Nullable:  true
     */
    private Integer wfInstanceStatus;

    /**
     * 流程实例备注
     *
     * Table:     workflow_instance
     * Column:    wf_instance_remark
     * Nullable:  true
     */
    private String wfInstanceRemark;

    /**
     * 流程实例现状
     *
     * Table:     workflow_instance
     * Column:    wf_instance_situation
     * Nullable:  true
     */
    private String wfInstanceSituation;

    /**
     * 流程实例上下文
     *
     * Table:     workflow_instance
     * Column:    wf_instance_context
     * Nullable:  true
     */
    private String wfInstanceContext;

    /**
     * 0.删除的 1.正常的
     *
     * Table:     workflow_instance
     * Column:    wf_instance_flag
     * Nullable:  true
     */
    private Integer wfInstanceFlag;

    /**
     * 流程唯一标识
     *
     * Table:     workflow_instance
     * Column:    wf_code
     * Nullable:  false
     */
    private String wfCode;

    private static final long serialVersionUID = 1L;
}