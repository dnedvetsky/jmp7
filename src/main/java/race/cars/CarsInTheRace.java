package race.cars;

import java.util.ArrayList;
import java.util.List;

/**
 * Class prepares cars - technically it creates threads for all cars participating in the race
 */
public class CarsInTheRace {
    private List<Thread> carsReady = new ArrayList<Thread>();

    public CarsInTheRace(List<Car> cars) {
        System.out.println();
        System.out.println("Cars are preparing for the race");
        System.out.println();
        for (Car car : cars) {
            System.out.println(String.format("%s is ready for a race", car.getName()));
            carsReady.add(new Thread(car));
        }
    }

    public List<Thread> getCarsReady() {
        return carsReady;
    }

}
