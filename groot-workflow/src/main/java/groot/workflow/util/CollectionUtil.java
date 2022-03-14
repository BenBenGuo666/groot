package groot.workflow.util;

import java.util.Collection;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/7
 */
public class CollectionUtil<T> {

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.size() <= 0;
    }

    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

}
