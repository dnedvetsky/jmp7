package race.road;

import race.cars.Car;
import race.cars.CarsInTheRace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is a race class that implements all cars and puts them on a road
 */
public class Race {
    private final ArrayList<Car> carsList;
    private final CarsInTheRace carsReady;
    private List<Thread> carsOnRace;
    private static long roadLength;

    public static long getRoadLength() {
        return roadLength;
    }

    /**
     * Race constructor - list of cars and length of a road
     *
     * @param roadLength
     * @param cars
     */
    public Race(long roadLength, Car... cars) {
        System.out.println();
        System.out.println("Road is set");
        System.out.println();
        carsList = new ArrayList<Car>(Arrays.asList(cars));
        this.roadLength = roadLength;
        carsReady = new CarsInTheRace(carsList);
    }

    /**
     * Starts the race - initiates all threads
     *
     * @throws InterruptedException
     */
    public void startRace() throws InterruptedException {
        carsOnRace = carsReady.getCarsReady();
        int carsSize = carsOnRace.size();
        for (int i = 0; i < carsSize; i++) {
            carsOnRace.get(i).setName(carsList.get(i).getName());
            carsOnRace.get(i).start();
        }
    }

    /**
     * This method waits for race end - to determine a winner
     */
    public void endTheRace() {
        while (true) {
            for (Thread car : carsOnRace) {
                if (carsList.get(carsOnRace.indexOf(car)).getIsWinner()) {
                    System.out.println();
                    System.out.println("We have a winner: " + car.getName());
                    finishTheRace();
                    return;
                }
            }
        }
    }

    /**
     * Terminates all other participants as they are loosers
     */
    private void finishTheRace() {
        System.out.println("-============================================-");
        System.out.println("-============================================-");
        System.out.println("-============================================-");
        System.out.println("-============================================-");
        System.out.println("-============================================-");
        System.out.println("Stopping other participants");
        System.out.println("-============================================-");
        System.out.println("-============================================-");
        System.out.println("-============================================-");
        System.out.println("-============================================-");
        System.out.println("-============================================-");
        for (Thread car : carsReady.getCarsReady()) {
            if (car.isAlive()) {
                car.interrupt();
            }
        }
    }

    public CarsInTheRace getCarsOnTheRace() {
        return carsReady;
    }
}
