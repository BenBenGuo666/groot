package groot.shiro.demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.mgt.SecurityManager;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/3/26
 */
public class Demo {

    public static void main(String[] args) {
        Realm realm = null;
        SecurityManager securityManager = new DefaultSecurityManager(realm);
        //Make the SecurityManager instance available to the entire application via static memory:
        SecurityUtils.setSecurityManager(securityManager);
    }

}
