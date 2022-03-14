package groot.workflow.code.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import groot.workflow.code.model.base.WorkflowInstance;
import groot.workflow.code.model.extension.WorkflowInstanceDto;

import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/1
 */
public interface WorkflowInstanceService extends IService<WorkflowInstance> {

    boolean create(WorkflowInstanceDto workflowInstanceDto);

    List<WorkflowInstanceDto> query(Map<String, Object> queryValue);

    boolean modify(WorkflowInstanceDto workflowInstanceDto);


}
