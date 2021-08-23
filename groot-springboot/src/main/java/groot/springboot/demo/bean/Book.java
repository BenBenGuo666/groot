package groot.springboot.demo.bean;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/4/20
 */
@Data
public class Book {

    @NotNull(message = "名称不能为空!")
    @Size(max = 4)
    private String name;

    @NotNull
    @Size(max = 4)
    private String id;



}
