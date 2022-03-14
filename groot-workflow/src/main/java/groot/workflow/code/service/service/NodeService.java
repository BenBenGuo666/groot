package groot.workflow.code.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import groot.workflow.code.model.base.Node;
import groot.workflow.code.model.extension.NodeDto;

import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/1
 */
public interface NodeService extends IService<Node> {

    boolean create(NodeDto nodeDto);

    List<NodeDto> query(Map<String, Object> queryValue);

    boolean modify(NodeDto nodeDto);

    int upsert(NodeDto nodeDto);

    int delete(NodeDto nodeDto);

    NodeDto queryByNodeKey(String nodeCode);

    NodeDto queryByNodeCode(String nodeCode);

    NodeDto queryPrev(String nodeCode);

    NodeDto queryNext(String nodeCode);

    NodeDto queryHead(String wfCode);

}
