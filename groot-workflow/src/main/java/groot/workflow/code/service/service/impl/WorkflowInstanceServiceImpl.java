package groot.workflow.code.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import groot.workflow.code.dao.base.WorkflowInstanceMapper;
import groot.workflow.code.model.base.WorkflowInstance;
import groot.workflow.code.model.extension.WorkflowInstanceDto;
import groot.workflow.code.service.service.WorkflowInstanceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/1
 */
@Service
public class WorkflowInstanceServiceImpl
        extends ServiceImpl<WorkflowInstanceMapper, WorkflowInstance>
        implements WorkflowInstanceService {

    @Autowired
    private WorkflowInstanceMapper workflowInstanceMapper;

    @Override
    public boolean create(WorkflowInstanceDto source) {
        WorkflowInstanceDto target = new WorkflowInstanceDto();
        BeanUtils.copyProperties(source, target);
        WorkflowInstanceDto.buildInitial(target);
        source.setWfInstanceCode(target.getWfInstanceCode());
        return super.save(target);
    }

    @Override
    public List<WorkflowInstanceDto> query(Map<String, Object> queryValue) {
        List<WorkflowInstance> dataList = workflowInstanceMapper.selectByMap(queryValue);
        List<WorkflowInstanceDto> result = new ArrayList<>();
        dataList.forEach(e -> {
            WorkflowInstanceDto target = new WorkflowInstanceDto();
            BeanUtils.copyProperties(e, target);
            result.add(target);
        });
        return result;
    }

    @Override
    public boolean modify(WorkflowInstanceDto workflowInstanceDto) {
        return super.save(workflowInstanceDto);
    }

}
