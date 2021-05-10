package groot.shiro.demo;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/5/7
 */
@FunctionalInterface
public interface LambdaInterface<T> {



    void iprint(T b, T s);

    default void iprint1111(){ };

    default void iprint(Book b){};

    /*void iprint(Book b, Student s);*/

}
