package lesson14.HomeWork;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lesson14.HomeWork.Main.*;

class MainTest {
    private static int counter = 1;
    @BeforeAll
    static void begins(){
        System.out.println("Testing begins");
    }

    @BeforeEach
    void setUp(){
        System.out.println("Test " + counter + " begins");
    }

    @AfterEach
    void setUpEnd(){
        System.out.println("Test " + (counter++) + " ended");
    }


    @DisplayName("First method TakeAfter4 testing")
    @ParameterizedTest
    @MethodSource("DataForTestTakeAfter4")
    public void testTakeAfter4(int[] source, int[] outPut){
         Assertions.assertArrayEquals(outPut, takeAfter4( source));
    }

    @DisplayName("First method TakeAfter4 Exception testing")
    @ParameterizedTest
    @MethodSource("DataForTestException")
    public void testException(int[] source) {
            RuntimeException thrown;
            thrown = Assertions.assertThrows(RuntimeException.class, () -> takeAfter4(source), "Исключения нет");
            System.out.println("При тестировани было вызвано ожидаемое исключение: " + thrown.getMessage());
    }

    @DisplayName("First method TakeAfter4 NO Exception testing")
    @ParameterizedTest
    @MethodSource("DataForTestNoException")
    public void testNoException(int[] source) {
        Assertions.assertDoesNotThrow(() -> takeAfter4(source));
        System.out.println("Тест пройден исключения не было");
    }

    @DisplayName("Second method check1And4 testing")
    @ParameterizedTest
    @MethodSource("DataForTestCheck1And4")
    public void testcheck1And4(int[] source, boolean result){
        Assertions.assertTrue(check1And4(source) == result);
    }

    public static Stream<Arguments> DataForTestTakeAfter4() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7},
                        new int[]{1, 7}),
                Arguments.arguments(new int[]{1, 22, 54, 4, 32, 3, 14, 15, 76},
                        new int[]{32, 3, 14, 15, 76}),
                Arguments.arguments(new int[]{3332, 56, 67, 44, 432, 43, 14, 15, 76},
                        new int[]{32, 3, 14, 15, 76}),
                Arguments.arguments(null,
                        null)
        );
    }

    public static Stream<Arguments> DataForTestException() {
        return Stream.of(
                Arguments.arguments(new int[]{3332, 56, 67, 44, 432, 43, 14, 15, 76} ),
                Arguments.arguments(new int[]{3332, 367, 744, 432, 43, 45, 815, 676} ),
                Arguments.arguments(new int[]{332, 6, 167, 444, 432, 430}),
                Arguments.arguments(new int[]{1332, 64, 1467, -200, -500, 430}),
                Arguments.arguments(new int[]{332, 6, 167, 4, 432, 430})
                );
    }

    public static Stream<Arguments> DataForTestNoException() {
        return Stream.of(
                Arguments.arguments(new int[]{3332, 4, 67, 44, 432, 43, 14, 15, 76} ),
                Arguments.arguments(new int[]{332, 6, 167, 4, 432, 430}),
                Arguments.arguments(new int[]{1332, 64, 1467, 4, -500, 430}),
                Arguments.arguments(new int[]{3332, 56, 67, 44, 432, 43, 14, 15, 76} )
                );
    }

        public static Stream<Arguments> DataForTestCheck1And4(){
            return Stream.of(
                    Arguments.arguments(new int[]{1, 1, 1, 4, 4, 1, 4, 4},
                            true),
                    Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1, 1},
                            false),
                    Arguments.arguments(new int[]{4, 4, 4, 4, 4},
                            false),
                    Arguments.arguments(new int[]{1, 4, 4, 1, 4, 3},
                            false),
                    Arguments.arguments(null,
                            false)
            );
    }
}