package race.road;

import java.util.List;

/**
 * Jury only has one job - to disqualify participant No0 (because he does not like participant No0)
 */
public class Jury {

    private Race race;

    public Jury(Race race) {
        this.race = race;
    }

    /**
     * Counts down before race begins
     */
    public void countDown() {
        System.out.println("3");
        System.out.println("2");
        System.out.println("1");
        System.out.println("GO!");
        System.out.println();
        System.out.println();
    }

    public void disqualifyCarByIndex(int i) {
        System.out.println();
        System.out.println("Disqualify car No " + i);
        System.out.println();
        List<Thread> allCars = race.getCarsOnTheRace().getCarsReady();
        System.out.println("Disqualified " + allCars.get(i).getName());
        System.out.println();
        allCars.get(i).interrupt();
    }
}
