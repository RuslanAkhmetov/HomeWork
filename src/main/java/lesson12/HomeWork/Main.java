package lesson12.HomeWork;

import java.util.Arrays;

import static java.lang.System.currentTimeMillis;

public class Main {
    static final int SIZE = 10; //00000;
    static final int HALF = SIZE / 2;


    public static void main(String[] args) {
//        Необходимо написать два метода, которые делают следующее:
//          1) Создают одномерный длинный массив, например:
        float[] arr = new float[SIZE];
//      2) Заполняют этот массив единицами.
        Arrays.fill(arr, 1.0f);
//      3) Засекают время выполнения:
        long a = currentTimeMillis();
        calculateArray(arr, 0);
//      5) Проверяется время окончания метода System.currentTimeMillis().
//      6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a).
        System.out.println(currentTimeMillis() - a);
        //для размера 10 вывести результаты
        for (int i = 0; i < arr.length && i < 10; i++) {
            System.out.println("Element " + i + " : " + arr[i]);
        }

/*      Отличие первого метода от второго:
            ● Первый просто бежит по массиву и вычисляет значения.
            ● Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.*/
//      2) Заполняют этот массив единицами.
        Arrays.fill(arr, 1.0f);
//      3) Засекают время выполнения:
        a = currentTimeMillis();
        secondMethod(arr);
//    Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
        System.out.println(currentTimeMillis() - a);
//      для размера 10 вывести результаты
        for (int i = 0; i < arr.length && i < 10; i++) {
            System.out.println("Element " + i + " : " + arr[i]);
        }
    }

    private static void secondMethod(float[] sourceArray) {
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];
        System.arraycopy(sourceArray, 0, a1, 0, HALF);
        System.arraycopy(sourceArray, HALF, a2, 0, HALF);
        Thread t1 = new Thread(() -> calculateArray(a1, 0));
        t1.start();
        Thread t2 = new Thread(() -> calculateArray(a2, HALF));
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        Обратная склейка
        System.arraycopy(a1, 0, sourceArray, 0, HALF);
        System.arraycopy(a2, 0, sourceArray, HALF, HALF);
    }

    private static void calculateArray(float[] arrayFloat, int startPos) {
        int j = startPos;
        for (int i = 0; i < arrayFloat.length; j++, i++) {
            arrayFloat[i] = (float)(arrayFloat[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }
    }

    private static void firstMethod(float[] arr) {
        //  4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
        calculateArray(arr, 0);
    }
}
