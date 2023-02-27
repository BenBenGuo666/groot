package groot.springboot.demo.designMode.factoryPattern;

/**
 * @author: guobenben
 * @date: 2022/7/27 14:26
 * @description:
 */
public class Demo {

    public static void main(String[] args) {

        ShapeFactory.createShape(ShapeTypeEnum.CIRCLE).draw();
        ShapeFactory.createShape(ShapeTypeEnum.SQUARE).draw();
        ShapeFactory.createShape(ShapeTypeEnum.RECTANGLE).draw();

    }

}
