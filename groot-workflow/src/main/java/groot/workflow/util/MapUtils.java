package groot.workflow.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/17
 */
public class MapUtils {

    public static Map<String, Object> genMap() {
        return new HashMap<String, Object>(50);
    }

    public static void setValue(Map<String, Object> map, String key, String value) {
        if (StringUtil.isNotEmpty(value)) {
            map.put(key, value);
        }
    }
    public static void setValue(Map<String, Object> map, String key, Collection value) {
        if (CollectionUtil.isNotEmpty(value)) {
            map.put(key, value);
        }
    }

    public static void setValue(Map<String, Object> map, String key, Integer value) {
        if (value != null) {
            map.put(key, value);
        }
    }

}
