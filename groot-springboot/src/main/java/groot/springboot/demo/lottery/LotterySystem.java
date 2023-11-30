package groot.springboot.demo.lottery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: GuoBen~
 * @date: 2023/11/13 15:49
 * @description:
 */
public class LotterySystem {

    private List<Prize> prizes;
    private List<Participant> participants;
    private Random random;

    public LotterySystem(List<Prize> prizes, List<Participant> participants) {
        this.prizes = prizes;
        this.participants = participants;
        this.random = new Random();
    }

    public Prize draw(Participant participant) {
        for (Prize prize : prizes) {
            if (canParticipantWin(prize, participant)) {
                double rand = random.nextDouble();
                double currentProbability = prize.getCurrentProbability();

                if (rand <= currentProbability) {
                    prize.decreaseQuantity();
                    participant.incrementWins();
                    return prize;
                }
            }
        }
        return null; // 没有中奖
    }

    private boolean canParticipantWin(Prize prize, Participant participant) {
        return participant.getTotalWins() < prize.getUserWinLimit() &&
                isCurrentTimeInReleaseSegment(prize.getReleaseTimeSegments());
    }

    private boolean isCurrentTimeInReleaseSegment(List<TimeSegment> releaseTimeSegments) {
        // 省略了实际的时间判断逻辑，假设当前时间符合其中一个时间段即可
        // 实际应用中，可能需要根据具体的时间和时区进行准确的判断
        return true;
    }

    public static void main(String[] args) {
        // 初始化奖品和参与者
        List<Prize> prizes = new ArrayList<>();
        prizes.add(new Prize("A奖品", 3, 0.002, 1, createReleaseTimeSegments()));
        prizes.add(new Prize("B奖品", 10, 0.003, 2, createReleaseTimeSegments()));
        prizes.add(new Prize("C奖品", 30, 0.005, 3, createReleaseTimeSegments()));
        // 添加其他奖品...

        List<Participant> participants = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            participants.add(new Participant("User" + (i + 1)));
        }
        // 添加其他参与者...

        // 初始化抽奖系统
        LotterySystem lotterySystem = new LotterySystem(prizes, participants);

        List<String> woner = new ArrayList<>();
        List<String> usersA = new ArrayList<>();
        List<String> usersB = new ArrayList<>();
        List<String> usersC = new ArrayList<>();
        // 模拟抽奖
        for (Participant participant : participants) {
            Prize luckyPrize = lotterySystem.draw(participant);

            if (luckyPrize != null) {
                String message = participant.getName() + "中奖了：" + luckyPrize.getName();
                if (luckyPrize.getName().contains("A")) {
                    usersA.add(message);
                }
                if (luckyPrize.getName().contains("B")) {
                    usersB.add(message);
                }
                if (luckyPrize.getName().contains("C")) {
                    usersC.add(message);
                }
                woner.add(message);
                System.out.println(message);
            } else {
                System.out.println(participant.getName() + "没有中奖。");
            }
        }
        woner.forEach(System.out::println);
        System.out.println(woner.size());
        System.out.println("统计");
        usersA.forEach(user -> System.out.print(user + "  "));
        System.out.println();
        System.out.println(usersA.size());
        usersB.forEach(user -> System.out.print(user + "  "));
        System.out.println();
        System.out.println(usersB.size());
        usersC.forEach(user -> System.out.print(user + "  "));
        System.out.println();
        System.out.println(usersC.size());
    }

    private static List<TimeSegment> createReleaseTimeSegments() {
        List<TimeSegment> releaseTimeSegments = new ArrayList<>();
        releaseTimeSegments.add(new TimeSegment(9, 12));
        releaseTimeSegments.add(new TimeSegment(14, 18));
        // 添加其他时间段...
        return releaseTimeSegments;
    }

}
