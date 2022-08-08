package lesson3;

import javax.lang.model.element.Element;
import java.util.Arrays;

public class HomeWorkApp3 {


    public static void main(String[] args) {
//        Первое задаание
        System.out.println("************Первое задание*****************");
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arr1));
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr1[i] ^ 1;
        }
        System.out.println(Arrays.toString(arr1));

//        Второе задаание
        System.out.println("************Второе задание*****************");
        int[] arr2 = new int[100];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i+1;
        }
        System.out.println(Arrays.toString(arr2));


//            Третье задание
        System.out.println("************Третье задание*****************");
        int[] arr4 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println(Arrays.toString(arr4));
        for (int i = 0; i < arr4.length; i++) {
            if (arr4[i] < 6) {
                arr4[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr4));

//        Четвертое задание
        System.out.println("************Четвертое задание*****************");
        int[][] diagArr = makeDiagonal(10,  1);
        for (int i = 0; i < diagArr.length; i++) {
            System.out.println(Arrays.toString(diagArr[i]));
        }

        //    Пятое задание
        System.out.println("************Пятое задание*****************");
        int len = 10 , initialValue = 47;
        System.out.println(Arrays.toString( makeArray (len,  initialValue)));

        //    Шестое задание
        System.out.println("************Шестое задание*****************");
        int[] arr6 = new int[] {31, 24, 6, 8, 9, 11, 56, 3};
        System.out.println(Arrays.toString(arr6));
        System.out.println("Минимум и максимум:");
        arrMinMax(arr6);

        //    Седьмое задание.
        System.out.println("************Седьмое задание*****************");
        int[] balanceArr = new int[] {2, 2, 2, 1, 2, 2, 1, 1 , 1, 1, 10, 1};
        int[] balanceArr1 = new int[] {1, 2, -1, 1, 3, 2, 3, 1};
        System.out.println(Arrays.toString(balanceArr1));
        System.out.println("Баланс: " + checkBalance(balanceArr1));

        //    Восьмое задание
        System.out.println("************Восьмое задание*****************");
        int n = -3;
        int[] arr8 = new int[] {31, 24, 6, 8, 9, 11, 56, 3, 14, 3, 47};
        System.out.println(Arrays.toString(arr8));
        System.out.println("После сдвига на " + Math.abs(n) + " элемемтов " + ((n < 0) ? "влево.":"вправо") );
        System.out.println(Arrays.toString(shiftArray(arr8, n)));
    }


    //        Четвертое задание
    private static int[][] makeDiagonal(int size,  int fill) {
        int[][] diagArr = new int[size][size];
        for (int i = 0; i < diagArr.length ; i++) {
            diagArr[i][i] = fill;
            diagArr[i][diagArr[i].length - 1 - i ] = fill;
        }
        return diagArr;
    }
//    Пятое задание

    private static int[] makeArray(int len, int initialValue) {
        int[] makeArr = new int[len];
        for (int i = 0; i < makeArr.length; i++) {
            makeArr[i] = initialValue;
        }
        return makeArr;
    }

    //    Шестое задание
    private static void arrMinMax(int[] arr) {
        int max = arr[0] , min = arr[0];
        if ( arr.length != 1 ) {
            for (int i = 1; i < arr.length; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                    continue;
                }
                if (max < arr[i])
                    max = arr[i];
            }
        }
        System.out.println(" Min : " + min);
        System.out.println(" Max : " + max);
    }


    //    Седьмое задание.

    private static boolean checkBalance(int[] arr) {
        if (arr.length == 1)
            return arr[0] == 0;
        long sumLeft = 0 , sumTotal = 0;
        for (int i = 0; i < arr.length; i++) {
            sumTotal += arr[i];
        }
        if ((sumTotal & 1) != 0 )           // если общая сумма нечетная то баланс из целых чисел невозможен
             return false;
        sumLeft = 0;
        for (int j = 0; j <= arr.length ; j++) {
            sumLeft += arr[j];
            if (sumLeft == sumTotal / 2) {
                return true;
            }
        }
        return false;
    }


//    Восьмое задание

    private static int[] shiftArray(int[] arr, int n) {
        if (Math.abs(n) >= arr.length)
            n = n % arr.length;                                 // удаляем лишние круги
        if (n == 0)                                             // если сдвиг равен кругу ничего не делаем
            return arr;
        n = n < 0 ? arr.length + n : n;                          //сдвиг влево = круг - сдвиг вправо
        int[] temp =  Arrays.copyOfRange(arr, arr.length - n, arr.length);  //копируем хвост
        for (int i = arr.length - n - 1 ; i >= 0  ; i--) {          //сдвиг вправо
            arr[i + n] = arr[ i ];
        }
        for (int i = 0; i < n ; i++) {                             //хвост к голове
            arr[i] = temp[i];
        }
        return arr;
    }
}

