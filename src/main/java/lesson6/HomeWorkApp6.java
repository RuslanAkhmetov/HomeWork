package lesson6;

public class HomeWorkApp6 {
    public static void main(String[] args) {
        Animal dog1 = new Dog("Бобик");
        dog1.run(1000);
        dog1.swim(5);
        Animal cat = new Cat("Китти");
        cat.run(150);
        cat.swim(10);
        System.out.println("DOGS objects created: " + Dog.getDogAmount());
        System.out.println("CATS objects created: " + Cat.getCatAmount());
        System.out.println("ANIMALS objects created: " + Animal.getAmount());

    }
}
class Cat extends Animal{
    private final long MAX_RUN_DISTANCE = 200;
    private final long MAX_SWIM_DISTANCE = 0;
    private static long catAmount;

    public Cat() {
        super();
        catAmount++;
    }

    public Cat( String name) {
        super( name);
        catAmount++;
    }

    public static long getCatAmount() {
        return catAmount;
    }

    @Override
    public void run(long dist) {
        if (dist <= MAX_RUN_DISTANCE)
            System.out.printf("%s пробежал %d м %n", getName(), dist);
        else
            System.out.printf("%s не может бегать %d м %n", getName(), dist );
    }

    @Override
    public void swim(long dist) {
        System.out.println("Коты не умеют плавать!");
    }


}
class Dog extends Animal{
    private final long MAX_RUN_DISTANCE = 500 ;
    private final long MAX_SWIM_DISTANCE = 10;
    private static long dogAmount;

    public Dog() {
        super();
        dogAmount++;
    }

    public Dog(String name) {
        super( name);
        dogAmount++;
    }

      public static long getDogAmount() {
        return dogAmount;
    }

    @Override
    public void run(long dist) {
       if (dist <= MAX_RUN_DISTANCE)
           System.out.printf("%s пробежал %d м %n", getName(), dist);
        else
            System.out.printf("%s не может бегать %d м %n", getName(), dist );
    }

    @Override
    public void swim(long dist) {
        if (dist <= MAX_SWIM_DISTANCE)
            System.out.printf("%s проплыл %d м %n", getName(), dist);
        else
            System.out.printf("%s не может плыть %d м %n", getName(), dist );
    }
}

abstract class Animal{

    private static long amount;
    private String name;
    public Animal(){
        amount++;
    }
    public Animal( String name) {
        this.name = name;
        amount++;
    }

    public static long getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void run(long dist);

    public abstract void swim(long dist);
}

