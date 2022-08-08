package lesson8.Homework;

public class RaceTrack implements Barrier {
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

    public boolean stepOver(JumpAndRun r){

        return r.doRun(distance);
    }

    public void printInfo(){
        System.out.print(getName() + " дистанция " + getDistance() + ": ");
    }
}
