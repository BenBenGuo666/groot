package groot.workflow.code.dao.expansion;

import groot.workflow.code.dao.base.WorkflowMapper;
import groot.workflow.code.model.base.Workflow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/1
 */
@Mapper
public interface WorkflowMapperEx extends WorkflowMapper {


    List<Workflow> selectAll(Map<String, Object> columnMap);

}
