package groot.springboot.demo.designMode.factoryPattern;

/**
 * @author: guobenben
 * @date: 2022/7/27 14:23
 * @description:
 */

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("正方形");
    }

}