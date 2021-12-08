package groot.pri.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @author guoga
 * @version 11:45 2020/5/12
 */
@SpringBootApplication
public class GatewayStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayStartApplication.class, args);
        System.out.println(Configuration.class.getName());
    }

}
