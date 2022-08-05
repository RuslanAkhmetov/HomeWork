package lesson8.Homework;

public class Wall {
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

    public boolean jumpOver (Jumping p){
        return p.doJump(height);
    }

}
