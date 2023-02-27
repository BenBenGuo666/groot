package groot.springboot.demo.mapStruct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: guobenben
 * @date: 2022/10/13 16:16
 * @description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {
    private String make;
    private int numberOfSeats;
    private CarType type;
    //constructor, getters, setters etc.

    static enum CarType {
        SEDAN
    }
}
