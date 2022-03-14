package groot.workflow.code.dao.expansion;

import groot.workflow.code.dao.base.WorkOrderMapper;
import groot.workflow.code.model.extension.WorkOrderDto;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/15
 */
public interface WorkOrderMapperEx extends WorkOrderMapper {

    List<WorkOrderDto> selectAll(Map<String, Object> queryMap);

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    String selectSeq();

    List<WorkOrderDto> queryAllDbsx(Map<String, Object> queryMap);
}
