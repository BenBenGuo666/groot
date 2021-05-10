package groot.shiro.demo.configurtion;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;

/**
 * @Desc 编程式配置 SecurityManager's object graph.
 * @Author GuoBen~
 * @Date 2021/4/1
 */
public class ProgrammaticConfiguration {

    /**
     * 缺点：1. 需要熟悉 SecurityManager's object graph 的每一个实例。
     * 2. 较多的 get* methods  的实例获取方式
     * 3. SecurityUtils.setSecurityManager(securityManager); 实例化的是一个虚拟静态单例-VM static singleton，同一 JVM 下
     * 运行多个 shiro 程序会出现问题。
     * 4. 更新配置后需要重启应用程序
     *
     * However, even with these caveats,
     * the direct programmatic manipulation approach could still be valuable in memory-constrained environments,
     * like smart-phone applications.
     * If your application does not run in a memory-constrained environment,
     * you’ll find text-based configuration to be easier to use and read.
     *
     * @param args
     */
    public static void main(String[] args) {

        Realm realm = null;
        //instantiate or acquire a Realm instance.  We'll discuss Realms later.
        SecurityManager securityManager = new DefaultSecurityManager(realm);

        //Make the SecurityManager instance available to the entire application via static memory:
        SecurityUtils.setSecurityManager(securityManager);

    }

}
