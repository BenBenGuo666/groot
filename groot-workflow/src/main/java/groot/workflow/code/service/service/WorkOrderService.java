package groot.workflow.code.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import groot.workflow.code.model.base.WorkOrder;
import groot.workflow.code.model.extension.WorkOrderDto;

import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/1
 */
public interface WorkOrderService extends IService<WorkOrder> {

    boolean create(WorkOrderDto workOrderDto);

    List<WorkOrderDto> query(Map<String, Object> queryValue);

    WorkOrderDto get(String woCode);


    List<WorkOrderDto> queryAll(Map<String, Object> queryValue);

    boolean modify(WorkOrderDto workOrderDto);

    boolean delete(String id);

    List<WorkOrderDto> queryAllDbsx(Map<String, Object> queryMap);
}
