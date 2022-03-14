package groot.workflow.code.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import groot.workflow.code.model.base.Workflow;
import groot.workflow.code.model.extension.WorkflowDto;

import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/1
 */
public interface WorkflowService extends IService<Workflow> {

    /**
     * 1.创建流程
     * 2.查询流程
     * 3.修改流程
     * 4.删除流程
     */
    boolean create(WorkflowDto workflowDto);

    List<WorkflowDto> quey(Map<String, Object> queryMap);

    boolean modifyWorkFlow(WorkflowDto workflowDto);

    int deleteWorkFlow(String id);


}
