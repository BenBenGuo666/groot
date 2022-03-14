package groot.workflow.code.model.extension;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/21
 */
@Data
public class WorkflowVo {


    /**
     * workflow
     */
    private String wfCode;
    private Integer wfStatus;

    /**
     * workorder
     */
    private String woCode;
    private Integer woStatus;
    private String businessCode;

    private String searchDepart;

    /**
     * wfInstance
     */
    private String wfInstanceCode;

    /**
     * common
     */
    @JsonAlias(value = {"ps"})
    private Integer pageSize = 10;
    @JsonProperty(value = "pn")
    private Integer pageNum = 1;

    private List<NodeVo> nodeList;

}
