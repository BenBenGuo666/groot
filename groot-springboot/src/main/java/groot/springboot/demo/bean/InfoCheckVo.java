package groot.springboot.demo.bean;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class InfoCheckVo implements Serializable {
    private static final long serialVersionUID = 573338859887779867L;

    @NotNull(message = "订单类型不能为空")
    private Integer order_type;

    private String ext_id;

    private String rcv_name;

    private String rcv_phone;

    private String rcv_address;

    private String dealer_channel_code;

    @NotBlank(message = "供货商编码不能为空")
    private String merchant_code;

    @NotEmpty(message = "商品列表不能为空")
    private List<Goods> item_list;



}
