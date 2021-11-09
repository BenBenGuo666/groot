package com.xwtech.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/8/24
 */
public class CollectionUtils {

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static void main(String[] args) {
        List<Map<String, Object>> list = null;
        if(CollectionUtils.isEmpty(list)){
            System.out.println("true");
        }
    }

}
