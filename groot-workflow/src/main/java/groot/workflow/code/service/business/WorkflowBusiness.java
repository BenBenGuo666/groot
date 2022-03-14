package groot.workflow.code.service.business;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import groot.workflow.code.model.base.Workflow;
import groot.workflow.code.model.extension.WorkflowDto;

import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/1
 */
public interface WorkflowBusiness extends IService<Workflow> {

    /**
     * 1.创建流程
     * 2.查询流程
     * 3.修改流程
     * 4.删除流程
     */

    boolean createWorkFlow(WorkflowDto workflowDto);

    List<WorkflowDto> queyWorkFlow(Map<String, Object> queryMap);

    PageInfo<WorkflowDto> queyWorkFlowPage(Map<String, Object> queryMap);

    boolean modifyWorkFlow(WorkflowDto workflowDto);

    boolean deleteWorkFlow(String id);

}
