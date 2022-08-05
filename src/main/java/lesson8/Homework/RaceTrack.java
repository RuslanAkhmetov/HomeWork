package lesson8.Homework;

public class RaceTrack {
    private String name;
    private final long distance;

    public RaceTrack(String name, long distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public long getDistance() {
        return distance;
    }

    public boolean runDistance (Runnable r){

        return r.doRun(distance);
    }
}
