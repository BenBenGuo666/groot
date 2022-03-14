package groot.workflow.code.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import groot.workflow.code.dao.base.WorkOrderMapper;
import groot.workflow.code.dao.expansion.WorkOrderMapperEx;
import groot.workflow.code.model.base.WorkOrder;
import groot.workflow.code.model.extension.WorkOrderDto;
import groot.workflow.code.service.service.WorkOrderService;
import groot.workflow.constants.Constants;
import groot.workflow.util.UUIDGenerator;
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
public class WorkOrderServiceImpl extends ServiceImpl<WorkOrderMapper, WorkOrder> implements WorkOrderService {

    @Autowired
    private WorkOrderMapperEx workOrderMapperEx;


    @Override
    public boolean create(WorkOrderDto workOrderDto) {
        String uid = UUIDGenerator.getUUID(Constants.WorkflowConstans.WF_ORDER_CODE_PREFIX);
        String woCode = workOrderMapperEx.selectSeq() + uid.substring(uid.length() - 4);
        workOrderDto.setWoCode(woCode);
        return super.save(workOrderDto);
    }

    @Override
    public List<WorkOrderDto> query(Map<String, Object> queryValue) {
        List<WorkOrder> datalist = workOrderMapperEx.selectByMap(queryValue);
        return WorkOrderDto.doToDto(datalist);
    }

    @Override
    public WorkOrderDto get(String woCode) {
        WorkOrderDto result = new WorkOrderDto();
        BeanUtils.copyProperties(super.getById(woCode), result);
        return result;
    }

    @Override
    public List<WorkOrderDto> queryAll(Map<String, Object> queryValue) {
        return workOrderMapperEx.selectAll(queryValue);
    }

    @Override
    public boolean modify(WorkOrderDto workOrderDto) {
        return super.save(workOrderDto);
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<WorkOrderDto> queryAllDbsx(Map<String, Object> queryMap) {
        return workOrderMapperEx.queryAllDbsx(queryMap);
    }
}
