package groot.springboot.demo.designMode.decoratorPattern;

/**
 * @author: guobenben
 * @date: 2022/7/27 13:53
 * @description:
 */
public class BlindMonk implements Hero{

    private String name;

    public BlindMonk(String name) {
        this.name = name;
    }

    @Override
    public void learnSkills() {
        System.out.println(name + "学习了以上技能！");
    }
}
