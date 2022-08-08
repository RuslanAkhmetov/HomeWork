package lesson2;

import lesson5.Player;

public class Incrementing {
    public static void main(String[] args) {
        System.out.println(rewardEmployee("Анатолий", 600));
        System.out.println(rewardEmployee("Вадим", 600));
        System.out.println(rewardEmployee("Татьяна", 600));
        System.out.println(rewardEmployee("Timofei", 6000));

 /*       test1();
        test2();
        test3();*/
/*        int c =0;
        c++;
        c += 1;
        System.out.println(++c);*/
    }

    private static boolean rewardEmployee(String name, int premium) {
        // String name = "John";
        // int premium = 1000;
        if (premium < 0 || premium > 3000)
            return false;
        System.out.println("Готовим бумаги для премирования " + name);
        System.out.println("Выделяем бюджет для  " + name + " на сумму " +premium);
        System.out.println("Зачисляем на карточку  " + name + " на сумму " + getPremiumWithoutTax(premium));
        System.out.println("Процесс завершен");
        return true;
    }

    static int getPremiumWithoutTax(int premium){

        return (int) (premium * (100-13) / 100.0);
    }

    private static void test1() {
        int c =0;
        System.out.println(c++);
        System.out.println(++c);
        System.out.println(c--);
        System.out.println(--c);
        System.out.println(c);
    }

    private static void test2() {
        int a = 5;
        int b = 5;

        int resultOne = 2 * ++a;
        int resultTwo = 2 * b++;

        System.out.println(resultOne);
        System.out.println(resultTwo);
    }

    private static void test3() {
        int c = 1;
        System.out.println(c++ +c);
        System.out.println(++c +c);
        System.out.println(c + c++);
        c += ++c + c;
        System.out.println(c);

    }
}
