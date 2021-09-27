package groot.springboot.demo.bean;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class Goods implements Serializable {
    private static final long serialVersionUID = 573338859887779888L;

    @NotBlank(message = "商品编码不能为空")
    private String ext_item_id;

    @NotNull(message = "商品购买数量不能为空")
    @Min(value = 1, message = "商品数量最小值为1")
    private Long product_num;
}
