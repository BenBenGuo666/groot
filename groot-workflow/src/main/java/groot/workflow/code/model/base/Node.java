package groot.workflow.code.model.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Table: node
 */
@Data
public class Node implements Serializable {
    /**
     * 节点唯一标识
     *
     * Table:     node
     * Column:    node_code
     * Nullable:  false
     */
    private String nodeCode;

    /**
     * 节点名称
     *
     * Table:     node
     * Column:    node_name
     * Nullable:  true
     */
    private String nodeName;

    /**
     * 节点类型：0.默认节点 1.集合节点 2.子流程节点
     *
     * Table:     node
     * Column:    node_type
     * Nullable:  true
     */
    private Integer nodeType;

    /**
     * 上一个节点
     *
     * Table:     node
     * Column:    node_prev
     * Nullable:  true
     */
    private String nodePrev;

    /**
     * 下一个节点
     *
     * Table:     node
     * Column:    node_next
     * Nullable:  true
     */
    private String nodeNext;

    /**
     * 回退节点
     *
     * Table:     node
     * Column:    node_backed
     * Nullable:  true
     */
    private String nodeBacked;

    /**
     * 父节点
     *
     * Table:     node
     * Column:    node_parent
     * Nullable:  true
     */
    private String nodeParent;

    /**
     * 进入节点表达式
     *
     * Table:     node
     * Column:    node_expression
     * Nullable:  true
     */
    private String nodeExpression;

    /**
     * 流程唯一标识
     *
     * Table:     node
     * Column:    workflow_code_and_node_code
     * Nullable:  false
     */
    private String workflowCodeAndNodeCode;

    /**
     * 节点创建时间
     *
     * Table:     node
     * Column:    node_createtime
     * Nullable:  true
     */
    private Date nodeCreatetime;

    /**
     * 节点创建人
     *
     * Table:     node
     * Column:    node_creator
     * Nullable:  true
     */
    private String nodeCreator;

    /**
     * 节点修改时间
     *
     * Table:     node
     * Column:    node_modifytime
     * Nullable:  true
     */
    private Date nodeModifytime;

    /**
     * 节点修改人
     *
     * Table:     node
     * Column:    node_modifier
     * Nullable:  true
     */
    private String nodeModifier;

    /**
     * 节点权限，逗号分割：U开头对人，G开头对组织，R开头对角色
     *
     * Table:     node
     * Column:    node_permission
     * Nullable:  true
     */
    private String nodePermission;

    /**
     * -1.失效的 0.等待开始 1.开始中 2.已结束 3.已回退 4.挂起 5.阻塞 
     *
     * Table:     node
     * Column:    node_status
     * Nullable:  true
     */
    private Integer nodeStatus;

    /**
     * 节点备注
     *
     * Table:     node
     * Column:    node_remarke
     * Nullable:  true
     */
    private String nodeRemarke;

    /**
     * 节点对应功能页面 url
     *
     * Table:     node
     * Column:    node_url
     * Nullable:  true
     */
    private String nodeUrl;

    /**
     * 0.删除的 1.正常的
     *
     * Table:     node
     * Column:    node_flag
     * Nullable:  true
     */
    private Integer nodeFlag;

    /**
     * 序号
     *
     * Table:     node
     * Column:    serial_number
     * Nullable:  true
     */
    private Integer serialNumber;

    /**
     * HEAD;TAIL;
     *
     * Table:     node
     * Column:    node_classify
     * Nullable:  true
     */
    private String nodeClassify;

    /**
     * (是否生成工单）0.默认 1.不生成
     *
     * Table:     node
     * Column:    node_gen_wo_status
     * Nullable:  true
     */
    private Integer nodeGenWoStatus;

    /**
     * 0.有上下级限制 1.无上下级限制
     *
     * Table:     node
     * Column:    node_limit_permission
     * Nullable:  true
     */
    private Integer nodeLimitPermission;

    /**
     * (是否自动审核）0.否 1.是
     *
     * Table:     node
     * Column:    node_auto_check
     * Nullable:  true
     */
    private Integer nodeAutoCheck;

    private static final long serialVersionUID = 1L;
}