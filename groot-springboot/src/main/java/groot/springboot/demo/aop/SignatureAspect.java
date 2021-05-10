package groot.springboot.demo.aop;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/4/6
 */

/*import com.xwtec.ecommerce.framework.constants.CacheKey;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.atomic.AtomicInteger;*/

/*@Aspect
@Component*/
public class SignatureAspect {

    /*private String cookieName = "JSESSIONID";
    private String key = CacheKey.PROJECT_MARK + "_" + CacheKey.COOKIE_NAME;

    @Autowired
    private RedisTemplate redisTemplate;

    @Around("execution(public org.springframework.web.servlet.ModelAndView com.xwtec.ecommerce.manage.controller.SignatureController.authLoginNew(String))")
    public Object authLoginNew(ProceedingJoinPoint pjp) throws Throwable {//切点映射
        System.out.println("before beforeAuthLoginNew-------------------");
        AtomicInteger value = (AtomicInteger) redisTemplate.opsForValue().get(key);
        if (value != null || value.intValue() > 0) {
            return new ModelAndView("error/404");
        }
        Object obj = pjp.proceed();
        System.out.println("after beforeAuthLoginNew--------------------");
        redisTemplate.opsForValue().set(key, new AtomicInteger(1));
        return obj;
    }*/

    /*@Before("authLoginNew()")
    public Object beforeAuthLoginNew(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("before beforeAuthLoginNew-------------------");
        AtomicInteger value = (AtomicInteger) redisTemplate.opsForValue().get(key);
        if (value == null || value.intValue() == 0) {
            return pjp.proceed();
        }
        return new ModelAndView("error/404");
    }

    @After("authLoginNew()")
    public Object afterAuthLoginNew(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("after beforeAuthLoginNew--------------------");
        redisTemplate.opsForValue().set(key, new AtomicInteger(1));
        return pjp.proceed();
    }*/

}
