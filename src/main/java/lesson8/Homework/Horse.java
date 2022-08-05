package lesson8.Homework;

public class Horse implements JumpAndRun{  //Jumping, Runnable{

    private String name;

    private final float maxHeight;

    private final long maxDistance;

    public Horse(String name, float maxHeight, long maxDistance) {
        this.name = name;
        this.maxHeight = maxHeight;
        this.maxDistance = maxDistance;
    }

    public String getName() {
        return name;
    }

    public float getMaxHeight() {
        return maxHeight;
    }

    public long getMaxDistance() {
        return maxDistance;
    }
    @Override
    public boolean doJump(float height) {
        if (getMaxHeight() >= height)
            System.out.println("Конь " + getName() + " прыгнул!");
        else
            System.out.println("Конь " + getName() + " не прыгнул!");
        return (getMaxHeight() >= height);
    }

    @Override
    public boolean doRun(long distance) {
        if (getMaxDistance() >= distance)
            System.out.println("Лошадь " + getName() + " пробежал");
        else
            System.out.println("Лошадь " + getName() + " не пробежал");
        return (getMaxDistance() >= distance);
    }
}
