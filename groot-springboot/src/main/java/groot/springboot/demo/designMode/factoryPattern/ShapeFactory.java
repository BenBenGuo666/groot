package groot.springboot.demo.designMode.factoryPattern;

/**
 * @author: guobenben
 * @date: 2022/7/27 14:25
 * @description:
 */
public class ShapeFactory {

    private ShapeFactory() {
    }

    /**
     * 创建不同的图形实例
     *
     * @param shapeTypeEnum
     * @return
     */
    public static Shape createShape(ShapeTypeEnum shapeTypeEnum) {
        Shape shape = null;
        String className = shapeTypeEnum.getClassName();
        try {
            Class clazz = Class.forName(className);
            shape = (Shape) clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return shape;
    }

}
