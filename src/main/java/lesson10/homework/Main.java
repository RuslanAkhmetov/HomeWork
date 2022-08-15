package lesson10.homework;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        1. Написать метод, который меняет два элемента массива местами (массив может быть любого
//                ссылочного типа);
        Number[] massiv = new Number[]{1.2, 2.4, 3.14, 4};
        System.out.println(Arrays.toString(massiv));
        replaceElement(massiv, 1, 3);
        System.out.println(Arrays.toString(massiv));

        Apple[] apples = new Apple[]{new Apple(), new Apple(), new Apple(), new Apple()};
        Box<Apple> appleBox = new Box<>(apples);
        System.out.println( "appleBox: " + appleBox.getWeight());
        Orange[] oranges = new Orange[]{new Orange(),new Orange(),new Orange(),new Orange(),new Orange(),new Orange(),};
        Box<Orange> orangeBox = new Box<>(oranges);
        System.out.println(  "orangeBox: " + orangeBox.getWeight());
        Apple[] apples2 = new Apple[]{new Apple(), new Apple(), new Apple(), new Apple(), new Apple()};
        Box<Apple> appleBox1 = new Box<>(apples2);
        System.out.println(  "appleBox1: " + appleBox1.getWeight());
        GoldenApple[] goldenApples = new GoldenApple[]{new GoldenApple(), new GoldenApple(), new GoldenApple(),};
        Box<GoldenApple> goldenAppleBox = new Box<>(goldenApples);
        System.out.println("goldenAppleBox: " + goldenAppleBox.getWeight());

//        appleBox.compare(orangeBox);        //НЕЛЬЗЯ
//        appleBox.reload(orangeBox);         //НЕЛЬЗЯ
//        appleBox.compare(goldenAppleBox);   //НЕЛЬЗЯ базовый не может принимать производный
        goldenAppleBox.reload(appleBox);      //производный класс позволяет перегрузиться в базовый

        System.out.println("goldenAppleBox after reload : " + goldenAppleBox.getWeight());
        System.out.println("appleBox after reload : " + appleBox.getWeight());

//        box.reload(box3);
        System.out.println("appleBox == appleBox1:" + appleBox.compare(appleBox1));
        appleBox1.reload(appleBox);
        System.out.println("appleBox1 after reload : " + appleBox1.getWeight());
        System.out.println("appleBox after reload : " + appleBox.getWeight());

    }


    public static <T> void replaceElement ( T[] array, int firstElement, int secondElement){
        T temp = array[firstElement];
        array[firstElement] = array[secondElement];
        array[secondElement] = temp;
    }
}
