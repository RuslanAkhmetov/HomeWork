package lesson3;

import java.util.Scanner;

public class TestConsoleInput {
    static Scanner in = new Scanner(System.in );

    public static void main(String[] args) {

//        testConsoleInput();
        int m = getIntNumFromScanner();
    }

    private static int getIntNumFromScanner() {
        while(true){
            System.out.println("Введите целое число");
            if (in.hasNextInt()) {
                return in.nextInt();
            }
            in.nextInt();
        }
    }

    private static void testConsoleInput() {
        int a = in.nextInt();
        int b = in.nextInt();

    }
}
