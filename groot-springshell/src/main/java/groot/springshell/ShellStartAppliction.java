package groot.springshell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author guoga
 * @version 11:45 2020/5/12
 */
@SpringBootApplication
public class ShellStartAppliction {

    public static void main(String[] args) {
        SpringApplication.run(ShellStartAppliction.class, args);
        System.out.println(Configuration.class.getName());
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer initProperties() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
