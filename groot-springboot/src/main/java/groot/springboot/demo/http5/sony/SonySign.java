package groot.springboot.demo.http5.sony;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;

/**
 * @author: GuoBen~
 * @date: 2023/7/10 17:52
 * @description:
 */
@Getter
@Builder
@JsonPropertyOrder(alphabetic = true)
public class SonySign {

    private SonySignBody body;

    private SonySignHeader header;

}
