package groot.springboot.demo.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class SkuSearchVO implements Serializable {
    private static final long serialVersionUID = 570218859888039865L;
    private int pageSize;
    private int currentPage;
    private String beginTime;
    private String endTime;
    private String param1;
    private String param2;
    private String param3;

}
