package lesson7;

public class OOP {
    public static void main(String[] args) {
       /* Cat cat = new Cat("Мурзик",22 );
        Cat cat2 = new Cat("Гав", 5 );*/
        Plate plate = new Plate(200, 100);
        plate.printInfo();
        Cat[] cats = new Cat[10];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("Кот"+i, 10 + i*2);
            cats[i].eat(plate);
            System.out.println("Кот " + cats[i].getName()  + (cats[i].isFullness() ? " сытый!" : " голодный!"));
        }
    }
}


