package groot.workflow.code.dao.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import groot.workflow.code.model.base.Workflow;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkflowMapper extends BaseMapper<Workflow> {


}