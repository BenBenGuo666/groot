package groot.springboot.demo.lottery;

/**
 * @author: GuoBen~
 * @date: 2023/11/13 15:48
 * @description:
 */
public class TimeSegment {

    private int startHour;
    private int endHour;

    public TimeSegment(int startHour, int endHour) {
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() {
        return endHour;
    }

}
