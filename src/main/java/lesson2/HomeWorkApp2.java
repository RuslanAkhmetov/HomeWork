package lesson2;

import static java.time.Year.isLeap;

public class HomeWorkApp2 {
    public static void main(String[] args) {
        int i = 10, j = 2;
        System.out.println("Утверждение, что Сумма " + i + " и " + j + " в пределах от 10 до 20 " + (checkSum(i, j) ? "верно" : "не верно"));
        isPositive(i);
        System.out.println("Число " + i + " отрицательно? : " + isNegative(i));
        String str = "Some string";
        multiString ( str, i);
        int year = 1900;
        System.out.println("Год " + year + " это " + ( isMyLeap(year) ? "" : "не") +" високосный год.");
    }


    //    Первое задвние

    private static boolean checkSum(int i, int j) {
        return i + j >= 10 && i + j <= 20;
    }
//    Второе задание

    private static void isPositive(int i) {
        if (i >= 0)
            System.out.println("Число " +  i + " положительное.");
        else
            System.out.println("Число " +  i + " отрицательое.");
    }

//    Третье задание
    private static boolean isNegative(int i) {
        return i < 0;
    }


//    Четвертое задание

    private static void multiString(String some_string, int m) {
        for (int j = 0; j < m ; j++) {
            System.out.println(some_string);
        }
    }

//    Пятое задание

    private static boolean isMyLeap(int year) {
        return ((year & 3) == 0) && ((year % 100) != 0 || (year % 400) == 0);
    }
}

