package lesson10.homework;

public class Box <T extends Fruit>{
    protected T[] fruits;

    public Box(T[] fruits) {
        this.fruits = fruits;
    }

    public void setFruits(T[] fruits) {
        this.fruits = fruits;
    }

    public double getWeight(){
        if (fruits == null)    return 0.0;
        return fruits.length * T.getWeight();}

    public boolean compare(Box <T> anotherBox){return anotherBox != null && getWeight() == anotherBox.getWeight();}
    public void reload(Box<? super T> newBox){
        newBox.setFruits( fruits);
        fruits = null;
    }



}
