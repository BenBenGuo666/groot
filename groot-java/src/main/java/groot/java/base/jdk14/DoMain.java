package groot.java.base.jdk14;

import java.util.Date;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/4/9
 */
public class DoMain {

    private void setS(String s){
        System.out.println(s);
        s = "222";
        System.out.println(s);
    }

    private String splitTimeByIndex(String time, int index) {
        String result = "";
        if (time != null && !"".equals(time)) {
            String[] tim = time.split(" - ");
            switch (index) {
                case 0:
                    result = tim[0].replaceAll("-", "") + "000000";
                    break;
                case 1:
                    result = tim[1].replaceAll("-", "") + "235959";
                    break;
                default:
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        /*DoMain doMain = new DoMain();
        String s = "2021-04-12 - 2021-04-13";
        System.out.println(doMain.splitTimeByIndex(s,0));
        System.out.println(doMain.splitTimeByIndex(s,1));*/
   /*     String todayStr = "20211206";
        System.out.println(Md5Util.toMD5("123456" + "B2B-001" + todayStr + "b2bMd5Key"));*/

        
    }

}
