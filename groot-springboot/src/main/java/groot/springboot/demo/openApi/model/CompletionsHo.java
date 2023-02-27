package groot.springboot.demo.openApi.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author: e-Benben.Guo
 * @date: 2023/2/10 11:18
 * @description:
 */
@Data
@Builder
public class CompletionsHo {

    private String model;

    private String prompt;

    private double temperature;

    private int max_tokens;

    private int top_p;

    private int frequency_penalty;

    private int presence_penalty;

}
