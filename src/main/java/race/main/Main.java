package race.main;

import race.cars.Car;
import race.road.Jury;
import race.road.Race;

/**
 * Created by Dmitry on 15.08.2016.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Race race = new Race(10000, new Car("Magical pony", 50), new Car("Participant N2", 100),
                new Car("Participant No3", 100), new Car("Participant No4", 100), new Car("Participant No5", 100), new Car("Participant No6", 100), new Car("Participant No7", 100));

        race.startRace();
        Jury jury = new Jury(race);
        jury.countDown();
        Thread.sleep(5000);
        jury.disqualifyCarByIndex(0);
        race.endTheRace();
    }
}
