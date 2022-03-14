package groot.workflow.code.model.extension;

import groot.workflow.code.model.base.WorkOrder;
import groot.workflow.constants.Constants;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/2
 */
@Data
public class WorkOrderDto extends WorkOrder {

    private WorkflowInstanceDto workflowInstanceDto;
    private WorkflowDto workflowDto;
    private NodeDto nodeDto;

    public static List<WorkOrderDto> doToDto(List<? extends WorkOrder> dataList) {
        List<WorkOrderDto> result = new ArrayList<>();
        dataList.forEach(e -> {
            WorkOrderDto target = new WorkOrderDto();
            BeanUtils.copyProperties(e, target);
            result.add(target);
        });
        return result;
    }


    public static WorkOrderDto buildFinish(WorkOrderDto source) {
        WorkOrderDto target = new WorkOrderDto();
        target.setWoCode(source.getWoCode());
        target.setWoReviewers(source.getWoReviewers());
        target.setWoUpdatetime(new Date());
        target.setWoStatus(Constants.BeansConstans.WO_STATUS_FINISHED);
        return target;
    }

    /**
     * 从流程生命周期新建对应节点的流程工单
     *
     * @param workflowInstanceDto
     * @return
     */
    public static WorkOrderDto buildInitial(WorkflowInstanceDto workflowInstanceDto) {
        WorkOrderDto obj = workflowInstanceDto.getWorkOrderDto();
        if (obj == null) {
            obj = new WorkOrderDto();
        }
        obj.setWfInstanceCode(workflowInstanceDto.getWfInstanceCode());
        obj.setWoApplicant(workflowInstanceDto.getWoApplicant());
        obj.setBusinessCode(workflowInstanceDto.getBusinessCode());
        return buildInitial(obj);
    }

    public static WorkOrderDto buildInitial(WorkOrderDto obj) {
        if (obj == null) {
            obj = new WorkOrderDto();
        }
        obj.setWoStatus(1);
//        obj.setWoCode(UUIDGenerator.getUUID(Constants.WorkflowConstans.WF_ORDER_CODE_PREFIX));
        obj.setWoFlag(Constants.BeansConstans.ENABLED);
        obj.setWoCreatetime(new Date());
        return obj;
    }
}
