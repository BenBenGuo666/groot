package groot.workflow.code.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import groot.workflow.code.dao.base.WorkflowMapper;
import groot.workflow.code.dao.expansion.WorkflowMapperEx;
import groot.workflow.code.model.base.Workflow;
import groot.workflow.code.model.extension.WorkflowDto;
import groot.workflow.code.service.service.WorkflowService;
import groot.workflow.constants.Constants;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/1
 */
@Service
public class WorkflowServiceImpl extends ServiceImpl<WorkflowMapper, Workflow> implements WorkflowService {

    @Autowired
    private WorkflowMapperEx workflowMapperEx;

    @Override
    public boolean create(WorkflowDto source) {
        WorkflowDto target = new WorkflowDto();
        BeanUtils.copyProperties(source, target);
        WorkflowDto.buildInitial(target);
        boolean number = modifyWorkFlow(target);
        source.setWfCode(target.getWfCode());
        return number;
    }

    @Override
    public List<WorkflowDto> quey(Map<String, Object> queryMap) {
        queryMap.put("wf_flag", Constants.BeansConstans.ENABLED);
        queryMap.put("orderByClause", "wf_createtime desc");
        List<Workflow> dataList = workflowMapperEx.selectAll(queryMap);
        return WorkflowDto.doToDto(dataList);
    }

    @Override
    public boolean modifyWorkFlow(WorkflowDto workflowDto) {
        return super.save(workflowDto);
    }

    @Override
    public int deleteWorkFlow(String id) {
        return 0;
    }
}
