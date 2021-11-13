package groot.springshell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/10/18
 */
@ShellComponent
public class MyCommands {

    @ShellMethod("Add two integers together.")
    public int add(int a, int b) {
        return a + b;
    }

}
