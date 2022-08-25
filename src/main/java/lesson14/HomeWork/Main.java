package lesson14.HomeWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 4, 2, 3, 4, 3, 7};
        System.out.println(Arrays.toString( takeAfter4(ints)));
        ints = new int[]{1, 4, 4, 1, 4, 3, 1};
        System.out.println( check1And4(ints));

    }

    public static int[] takeAfter4(int[] source) throws RuntimeException {
        List<Integer> tempList = new ArrayList<>();
        for (int i = source.length-1 ; i >= 0 ; i--) {
            if (source[i] != 4)
                tempList.add(0,source[i]);
            else {
                return   tempList.stream().mapToInt(j->j).toArray();
            }
        }
        throw new RuntimeException("Массив не имеет ни одной четверки");
    }

    public static boolean check1And4(int [] source){
        boolean has1 = false;
        boolean has4 = false;
        if (source == null) throw new RuntimeException("Массив нулевой");
        for (int e: source) {
                switch (e) {
                    case 1:
                        has1 = true;
                        break;
                    case 4:
                        has4 = true;
                        break;
                    default:
                        return false;
                }
        }
        return has1 && has4;
    }
}
