package lesson13.HomeWork;

import lesson13.HomeWork.Car;

public abstract class Stage {
    protected int length;
    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract void go(Car car);
}
