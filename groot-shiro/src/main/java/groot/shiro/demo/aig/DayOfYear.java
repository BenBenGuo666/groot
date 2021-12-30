package groot.shiro.demo.aig;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/12/21
 */
public class DayOfYear {

    public static void main(String[] args) {

        String s = "2001";

        String m = "01";


        String d = "01";
        System.out.println(Integer.valueOf(s));
    }

    /**
     * 5 ms
     * @param date
     * @return
     */
    /*public static int dayOfYear(String date){
        int num = 0;
        int year = (date.charAt(0) - '0')*1000 + (date.charAt(1) - '0')*100 + (date.charAt(2) - '0')*10 + (date.charAt(3) - '0');
        int month = (date.charAt(5) - '0')*10 + (date.charAt(6) - '0');
        int day = (date.charAt(8) - '0')*10 + (date.charAt(9) - '0');
        int[] pYear = {0,31,28,31,30,31,30,31,31,30,31,30};
        int[] rYear = {0,31,29,31,30,31,30,31,31,30,31,30};
        if(year % 400 == 0  || (year % 4== 0 && year / 100 != 0)){
            for(int i = 0; i < month; i++)
                num += rYear[i];
        }else{
            for(int i = 0; i < month;i++)
                num += pYear[i];
        }
        return num + day;
    }*/

    public static int dayOfYear(String date) {
        String[] dates = date.split("-");
        int year = Integer.parseInt(dates[0]);
        int month = Integer.valueOf(dates[1]);
        int day = Integer.valueOf(dates[2]);
        boolean isLeapYear = false;
        if (year % 100 == 0) {
            if (year % 400 == 0) isLeapYear = true;
        } else if (year % 4 == 0) isLeapYear = true;
        int days = 0;
        for (int i = 1; i < month; i++) {
            if (i <= 7) {
                if (i % 2 == 1) days += 31;
                else if (i == 2) {
                    if (isLeapYear) days += 29;
                    else days += 28;
                } else days += 30;
            } else {
                if (i % 2 == 1) days += 30;
                else days += 31;
            }
        }
        return day + days;
    }

}
