package groot.springboot.demo.lottery;

import lombok.Data;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: GuoBen~
 * @date: 2023/11/13 15:48
 * @description:
 */
@Data
public class Participant {

    private String name;
    private int totalWins; // 用户总共中奖次数
    private Lock lock; // 添加锁

    public Participant(String name) {
        this.name = name;
        this.totalWins = 0;
        this.lock = new ReentrantLock();
    }

    public int getTotalWins() {
        lock.lock();
        try {
            return totalWins;
        } finally {
            lock.unlock();
        }
    }

    public void incrementWins() {
        lock.lock();
        try {
            totalWins++;
        } finally {
            lock.unlock();
        }
    }

}
