package lesson3;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TestArrays {
    static final int ARRAY_SIZE = 5;

    public static void main(String[] args) {
        testOneArray();
        testTwoArray();
    }

    private static void testOneArray() {
        int[] data = new int[ARRAY_SIZE];
        data[0] = 3;
        data[2] = 5;
        data[data.length-1] = 6;
        System.out.println(Arrays.toString(data));
        System.out.println(convertArrayToString(data));
       
    }

    private static String convertArrayToString(int[] array) {
        String str = "[";
        for (int i=0; i < array.length; i++) {
            str += array[i];
            if (i != array.length - 1)
                str += ", ";
        }
        str += "]";
        return str;
    }

    private static void testTwoArray() {
        int[][] deepData = new int[4][3];
        for (int i = 0; i < deepData.length ; i++) {
            for (int j = 0; j < deepData [i].length; j++) {
                deepData[i][j]= i * 3 + j;
            }
        }
//        System.out.println(Arrays.deepToString(deepData));
/*        for (int i = 0; i < deepData.length; i++) {
            for (int j = 0; j < deepData [i].length; j++) {
                System.out.printf( "%2d", deepData[i][j]);
            }
            System.out.println();
        }*/
        for (int[] el : deepData) {
            for (int deepDatum : el) {
                System.out.printf("%2d ", deepDatum);
            }
            System.out.println();
        }
    }

}


