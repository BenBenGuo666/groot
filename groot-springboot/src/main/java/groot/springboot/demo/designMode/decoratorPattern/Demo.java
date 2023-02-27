package groot.springboot.demo.designMode.decoratorPattern;

/**
 * @author: guobenben
 * @date: 2022/7/27 13:55
 * @description:
 */
public class Demo {

    public static void main(String[] args) {
        //选择英雄
        Hero hero = new BlindMonk("李青");

        Skills skills = new Skills(hero);
        Skills r = new Skill_R(skills, "猛龙摆尾");
        Skills e = new Skill_E(r, "天雷破/摧筋断骨");
        Skills w = new Skill_W(e, "金钟罩/铁布衫");
        Skills q = new Skill_Q(w, "天音波/回音击");
        //一次学习所有技能的装饰方式
        //学习技能
//        q.learnSkills();

        //一次学习一个技能
        Skills r1 = new Skill_R(skills, "猛龙摆尾");
        Skills e2 = new Skill_E(skills, "天雷破/摧筋断骨");
        Skills w3 = new Skill_W(skills, "金钟罩/铁布衫");
        Skills q4 = new Skill_Q(skills, "天音波/回音击");
        q4.learnSkills();
        w3.learnSkills();
        e2.learnSkills();
        r1.learnSkills();

    }

}
