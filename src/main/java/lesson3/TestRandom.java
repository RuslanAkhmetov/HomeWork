package lesson3;

import java.util.Arrays;
import java.util.Random;

public class TestRandom {
    public static void main(String[] args) {
        testRandom();
    }

    private static void testRandom() {
        int[] data = new int[40];
        Random rand = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextInt(10);
            data[i] = rand.nextInt(7, 17);
            data[i] = rand.nextInt(10) + 7; // min 7 max 17
            data[i] = (int) ( Math.random() * 10);
    }

        System.out.println(Arrays.toString(data));
    }
}
