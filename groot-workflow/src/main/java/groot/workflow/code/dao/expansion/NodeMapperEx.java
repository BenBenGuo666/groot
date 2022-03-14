package groot.workflow.code.dao.expansion;

import groot.workflow.code.dao.base.NodeMapper;
import groot.workflow.code.model.base.Node;

public interface NodeMapperEx extends NodeMapper {

    int upsert(Node record);

}