package lesson8.Homework;

public class Person implements JumpAndRun{//Jumping, Runnable{
    private String name;
    private final float maxHeight;
    private final long maxDistance;
    public Person(String name, float maxheight, long maxDistance) {
        this.name = name;
        this.maxHeight = maxheight;
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
            System.out.println("Участник " + getName() + " прыгнул!");
        else
            System.out.println("Участник " + getName() + " не прыгнул!");
        return (getMaxHeight() >= height);
    }

    @Override
    public boolean doRun(long distance) {
        if (getMaxDistance() >= distance)
            System.out.println("Участник " + getName() + " пробежал");
        else
            System.out.println("Участник " + getName() + " не пробежал");
        return (getMaxDistance() >= distance);
    }
}
