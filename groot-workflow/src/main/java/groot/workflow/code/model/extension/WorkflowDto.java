package groot.workflow.code.model.extension;

import groot.workflow.code.model.base.Workflow;
import groot.workflow.constants.Constants;
import groot.workflow.util.UUIDGenerator;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Desc 流程实体 DTO
 * @Author GuoBen~
 * @Date 2021/6/1
 */
@Data
public class WorkflowDto extends Workflow {

    private List<NodeDto> nodes;

    public static List<WorkflowDto> doToDto(List<? extends Workflow> dataList){
        List<WorkflowDto> result = new ArrayList<>();
        dataList.forEach(e -> {
            WorkflowDto target = new WorkflowDto();
            BeanUtils.copyProperties(e, target);
            result.add(target);
        });
        return result;
    }

    public static WorkflowDto buildInitial(WorkflowDto obj) {
        if (obj == null) {
            obj = new WorkflowDto();
        }
        obj.setWfCode(UUIDGenerator.getUUID(Constants.WorkflowConstans.WF_CODE_PREFIX));
        obj.setWfFlag(Constants.BeansConstans.ENABLED);
        obj.setWfCreatetime(new Date());
        obj.setWfStatus(1);
        return obj;
    }


}
