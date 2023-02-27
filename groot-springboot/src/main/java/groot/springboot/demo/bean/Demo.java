package groot.springboot.demo.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Demo {
    private Integer id;

    private String name;

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("0.22");
        System.out.println(bigDecimal);
    }

}