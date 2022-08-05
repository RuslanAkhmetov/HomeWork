package lesson7;

import org.jetbrains.annotations.NotNull;

public class Cat {
    private String name;
    final int appetite;
    private boolean fullness = false;

    public Cat(String name, int appetite) {
        this.appetite = appetite;
        this.name = name;
    }

    public boolean isFullness() {
        return fullness;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void eat(@NotNull Plate plate){
        //int appetite = 5 + ThreadLocalRandom.current().nextInt(25);
        //System.out.println("Аппетит кота: " + appetite);
        if (plate.getFood() < getAppetite())        //смотрим в тарелку
            fullness = false;                       //если еды меньше аппетита то не трогаем и остаемся голодным
        else {                                       //иначе едим
            plate.decreaseFood(appetite);
            fullness = true;
        }
    }
}
