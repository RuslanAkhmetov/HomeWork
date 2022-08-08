package lesson3;

public class TestMethods {
    public static void main(String[] args) {
        multtiplayAndPrint( 3, 4);
        multtiplayAndPrint( 3.76f, 4.56f);
        multtiplayAndPrint(11);

    }

    private static void multtiplayAndPrint(int a, int b) {
        int multiply = a * b;
        System.out.printf("Произведение двух чисел %d и %d равно %d %n", a, b, multiply);
    }

    private static void multtiplayAndPrint(float a, float b) {
        float multiply = a * b;
        System.out.printf("Произведение двух чисел %f и %f равно %.2f %n", a, b, multiply);
    }

    private static void multtiplayAndPrint(int a) {

        multtiplayAndPrint( a, a);
    }
}
