package groot.workflow.code.service.business;

import com.baomidou.mybatisplus.extension.service.IService;
import groot.workflow.code.model.extension.WorkflowInstanceDto;

import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/2
 */
public interface WorkflowInstanceBusiness {

    /**
     * 1.创建实例
     * 2.查询实例
     * 3.修改实例
     * 4。删除实例
     */
    WorkflowInstanceDto finishInstance(WorkflowInstanceDto workflowInstanceDto);

    WorkflowInstanceDto createWorkflowInstance(WorkflowInstanceDto workflowInstanceDto);

    List<WorkflowInstanceDto> queryWorkflowInstance(Map<String, Object> queryMap);

    boolean modifyWorkflowInstance(WorkflowInstanceDto workflowInstanceDto);

    boolean deleteWorkflowInstance(String id);

    WorkflowInstanceDto consume(WorkflowInstanceDto workflowInstanceDto);

    WorkflowInstanceDto review(WorkflowInstanceDto workflowInstanceDto);

    WorkflowInstanceDto buildWorkflowInstance(WorkflowInstanceDto workflowInstanceDto);

}
