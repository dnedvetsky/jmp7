package race.cars;

import race.road.Race;

/**
 * Created by Dmitry on 20.08.2016.
 */
public class Car implements Runnable {

    private static final long MAX_DISTANCE = 10000000;
    private boolean isWinner = false;
    private long friction;
    private long distance;

    private String name;

    public Car(String name, long friction) {
        this.name = name;
        this.friction = friction;
    }

    public boolean getIsWinner()
    {
        return isWinner;
    }
    /**
     * This is used to start thread
     */
    @Override
    public void run() {
        try {
            if (!Thread.interrupted())
                while (distance < MAX_DISTANCE || isWinner == false) {
                    Thread.sleep(friction);
                    distance += 100;
                    System.out.println(name + " " + distance);
                    isWinner = distance >= Race.getRoadLength();
                }
            else
                return;
        } catch (InterruptedException e) {
            System.out.println(getName() + " : " + String.valueOf(e));
        }
    }

    /**
     * Returns the distance value
     *
     * @return
     */
    public long getDistance() {
        return distance;
    }

    /**
     * Returns the name value
     *
     * @return name
     */
    public String getName() {
        return name;
    }
}