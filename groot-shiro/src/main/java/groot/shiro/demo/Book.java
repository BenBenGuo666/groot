package groot.shiro.demo;

import lombok.Data;

import java.util.Objects;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/4/20
 */
@Data
public class Book {

    private String name;

    private String prices;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", prices='" + prices + '\'' +
                '}';
    }
}
