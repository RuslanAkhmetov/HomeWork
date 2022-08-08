package lesson8.Homework;

public class Wall implements Barrier{
    private String name;
    private final float height;

    public Wall(String name, float height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public float getHeight() {
        return height;
    }

    public boolean stepOver (JumpAndRun p){
        return p.doJump(height);
    }

    public void printInfo () {
        System.out.print(getName() + " высота " + getHeight() + ": ");
    }
}
