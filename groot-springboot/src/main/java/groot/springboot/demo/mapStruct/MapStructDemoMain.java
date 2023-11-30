package groot.springboot.demo.mapStruct;


import org.junit.jupiter.api.Test;

/**
 * @author: guobenben
 * @date: 2022/10/13 16:22
 * @description:
 */
public class MapStructDemoMain {

    public static void main(String[] args) {
        //given
        Car car = new Car( "Morris", 5, Car.CarType.SEDAN );

        //when
        CarDto carDto = CarMapper.INSTANCE.carToCarDto( car );

        System.out.println(car);
    }

    @Test
    public void shouldMapCarToDto() {
        //given
        Car car = new Car( "Morris", 5, Car.CarType.SEDAN );

        //when
        CarDto carDto = CarMapper.INSTANCE.carToCarDto( car );

        System.out.println(car);
    }


}
