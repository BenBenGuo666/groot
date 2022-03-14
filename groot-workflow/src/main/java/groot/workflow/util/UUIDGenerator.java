package groot.workflow.util;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/1
 */
public class UUIDGenerator {

    public UUIDGenerator() {
    }


    public static String getShortUuid() {
        StringBuffer stringBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int strInteger = Integer.parseInt(str, 16);
            stringBuffer.append(Character.toChars(strInteger));
        }
        return new String(stringBuffer.toString().getBytes(), StandardCharsets.UTF_8);

    }

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 去掉"-"符号
//        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        return str.substring(24);
    }

    public static String getUUID(String prefixType) {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 去掉"-"符号
//        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        return prefixType + str.substring(10, 13) + str.substring(24);
    }

    //获得指定数量的UUID
    public static String[] getUUID(int number) {
        if (number < 1) {
            return null;
        }
        String[] ss = new String[number];
        for (int i = 0; i < number; i++) {
            ss[i] = getUUID();
        }
        return ss;
    }

    //获得指定数量的UUID
    public static String[] getUUID(int number, String prefixType) {
        if (number < 1) {
            return null;
        }
        String[] ss = new String[number];
        for (int i = 0; i < number; i++) {
            ss[i] = getUUID(prefixType);
        }
        return ss;
    }

    public static void main(String[] args) {
        String[] ss = getUUID(10, "Z");
        for (int i = 0; i < ss.length; i++) {
            System.out.println(ss[i]);
            System.out.println(ss[i].substring(ss[i].length() - 4));
        }
        System.out.println(ss[0].length());
//        System.out.println(getUUID());
    }

}
