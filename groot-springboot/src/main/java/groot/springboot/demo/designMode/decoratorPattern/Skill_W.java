package groot.springboot.demo.designMode.decoratorPattern;

/**
 * @author: guobenben
 * @date: 2022/7/27 13:54
 * @description:
 */
public class Skill_W extends Skills {

    private String skillName;

    public Skill_W(Hero hero, String skillName) {
        super(hero);
        this.skillName = skillName;
    }

    @Override
    public void learnSkills() {
        System.out.println("学习了技能W:" + skillName);
        super.learnSkills();
    }
}