package groot.springboot.demo.designMode.factoryPattern;

/**
 * @author: guobenben
 * @date: 2022/7/27 14:24
 * @description:
 */
public enum ShapeTypeEnum {

    CIRCLE("groot.springboot.demo.designMode.factoryPattern.Circle"),
    SQUARE("groot.springboot.demo.designMode.factoryPattern.Square"),
    RECTANGLE("groot.springboot.demo.designMode.factoryPattern.Rectangle");
    
    private String className;

    ShapeTypeEnum(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

}
