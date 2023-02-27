package groot.springboot.demo.designMode.decoratorPattern;

/**
 * @author: guobenben
 * @date: 2022/7/27 13:55
 * @description:
 */
public class Skill_E extends Skills{

    private String skillName;

    public Skill_E(Hero hero,String skillName) {
        super(hero);
        this.skillName = skillName;
    }

    @Override
    public void learnSkills() {
        System.out.println("学习了技能E:"+skillName);
        super.learnSkills();
    }
}
