package groot.shiro.demo;

import lombok.Data;

import java.util.Objects;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/5/8
 */
@Data
public class NewBook extends Book{

    private double price;

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NewBook newBook = (NewBook) o;
        return Objects.equals(name, newBook.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
