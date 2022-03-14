package groot.workflow.code.model.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Table: workflow
 */
@Data
public class Workflow implements Serializable {
    /**
     * 流程唯一标识
     *
     * Table:     workflow
     * Column:    wf_code
     * Nullable:  false
     */
    private String wfCode;

    /**
     * 流程名称
     *
     * Table:     workflow
     * Column:    wf_name
     * Nullable:  true
     */
    private String wfName;

    /**
     * 流程创建时间
     *
     * Table:     workflow
     * Column:    wf_createtime
     * Nullable:  true
     */
    private Date wfCreatetime;

    /**
     * 创建者
     *
     * Table:     workflow
     * Column:    wf_creator
     * Nullable:  true
     */
    private String wfCreator;

    /**
     * 流程更新时间
     *
     * Table:     workflow
     * Column:    wf_modifytime
     * Nullable:  true
     */
    private Date wfModifytime;

    /**
     * 修改人
     *
     * Table:     workflow
     * Column:    wf_modifier
     * Nullable:  true
     */
    private String wfModifier;

    /**
     * 备注
     *
     * Table:     workflow
     * Column:    wf_remark
     * Nullable:  true
     */
    private String wfRemark;

    /**
     * 流程权限，逗号分割，用来发起流程：U开头对人，G开头对组织，R开头对角色
     *
     * Table:     workflow
     * Column:    wf_permission
     * Nullable:  true
     */
    private String wfPermission;

    /**
     * 0.删除的 1.正常的
     *
     * Table:     workflow
     * Column:    wf_flag
     * Nullable:  true
     */
    private Integer wfFlag;

    /**
     * -1.失效的 0.待发布 1.已发布
     *
     * Table:     workflow
     * Column:    wf_status
     * Nullable:  true
     */
    private Integer wfStatus;

    private static final long serialVersionUID = 1L;
}