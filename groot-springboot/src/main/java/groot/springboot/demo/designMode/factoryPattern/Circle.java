package groot.springboot.demo.designMode.factoryPattern;

/**
 * @author: guobenben
 * @date: 2022/7/27 14:22
 * @description:
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("圆形");
    }
}

