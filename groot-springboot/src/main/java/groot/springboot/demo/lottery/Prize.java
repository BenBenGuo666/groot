package groot.springboot.demo.lottery;

import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: GuoBen~
 * @date: 2023/11/13 15:10
 * @description:
 */
@Data
public class Prize {

    private String name;
    private int totalQuantity; // 初始奖品总数量
    private int remainingQuantity; // 当前奖品剩余数量
    private double baseProbability; // 初始中奖几率
    private int userWinLimit; // 每个用户可获奖次数限制
    @Getter
    private List<TimeSegment> releaseTimeSegments; // 奖品释放的时间段
    private Lock lock; // 添加锁

    public Prize(String name, int totalQuantity, double baseProbability, int userWinLimit, List<TimeSegment> releaseTimeSegments) {
        this.name = name;
        this.totalQuantity = totalQuantity;
        this.remainingQuantity = totalQuantity;
        this.baseProbability = baseProbability;
        this.userWinLimit = userWinLimit;
        this.releaseTimeSegments = releaseTimeSegments;
        this.lock = new ReentrantLock();
    }

    double getCurrentProbability() {
        lock.lock();
        try {
            if (remainingQuantity <= 0) {
                return 0.0;
            }
            return baseProbability;
        } finally {
            lock.unlock();
        }
    }


    public void decreaseQuantity() {
        lock.lock();
        try {
            if (remainingQuantity > 0) {
                remainingQuantity--;
            }
        } finally {
            lock.unlock();
        }
    }

    public void increaseQuantity() {
        lock.lock();
        try {
            remainingQuantity++;
        } finally {
            lock.unlock();
        }
    }

}
