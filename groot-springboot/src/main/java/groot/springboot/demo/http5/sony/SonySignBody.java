package groot.springboot.demo.http5.sony;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;

/**
 * @author: GuoBen~
 * @date: 2023/7/10 17:53
 * @description:
 */
@Getter
@Builder
@JsonPropertyOrder(alphabetic = true)
public class SonySignBody {


    private int pageNo;

    private int pageSize;

    private String type;

}
