package groot.shiro.demo;

import java.util.Collection;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/7
 */
public class Collections<T> {

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.size() <= 0;
    }

    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

}
