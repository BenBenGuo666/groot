package groot.workflow.code.model.extension;

import groot.workflow.code.model.base.WorkflowInstance;
import groot.workflow.constants.Constants;
import groot.workflow.util.UUIDGenerator;
import lombok.Data;

import java.util.Date;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/2
 */
@Data
public class WorkflowInstanceDto extends WorkflowInstance {


    /**
     * 表单发起人，申请人
     */
    private String woApplicant;
    /**
     * 业务编码
     */
    private String businessCode;

    /**
     * 工单编号
     */
    private String woCode;

    /**
     * 首节点、尾节点、null:默认节点
     */
    private String classify;

    /**
     * 当前节点
     *
     * @param
     * @return
     */
    private NodeDto current;

    /**
     * 当前表单
     */
    private WorkOrderDto workOrderDto;

    private Integer woStatus;

    private String reviewers;

    public void clear() {
        this.setWfInstanceContext(null);
        this.setWorkOrderDto(null);
        this.setCurrent(null);
    }

    public void clearNode() {
        this.setCurrent(null);
    }

    public void clearWorkOrder() {
        this.setWorkOrderDto(null);
    }

    public static WorkflowInstanceDto buildFinish(WorkflowInstanceDto source) {
        WorkflowInstanceDto target = new WorkflowInstanceDto();
        target.setWfInstanceCode(source.getWfInstanceCode());
        target.setWfInstanceStatus(Constants.BeansConstans.WF_INSTANCE_STATUS_FINISH);
        target.setWfInstanceUpdatetime(new Date());
        target.clear();
        return target;
    }

    public static WorkflowInstanceDto buildInitial(WorkflowInstanceDto obj) {
        if (obj == null) {
            obj = new WorkflowInstanceDto();
        }
        obj.setWfInstanceCode(UUIDGenerator.getUUID(Constants.WorkflowConstans.WF_INSTANCE_CODE_PREFIX));
        obj.setWfInstanceCreatetime(new Date());
        obj.setWfInstanceFlag(Constants.BeansConstans.ENABLED);
        obj.setWfInstanceStatus(Constants.BeansConstans.WF_INSTANCE_STATUS_DOING);
        return obj;
    }
}
