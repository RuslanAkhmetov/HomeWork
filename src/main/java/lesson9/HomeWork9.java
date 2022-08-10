package lesson9;

import java.util.Arrays;

public class HomeWork9 {
    public static void main(String[] args) {
        String[][] str = new String[][] {{"2", "3", "10", "22"},
                                        {"22", "43", "9", "42"},
                                        {"32", "33", "13", "32"},
                                        {"48", "67", "105", "222"},
//                                        {"48", "67", "105", "222"}
        };
        long sumArray = 0;
        try {
            sumArray = convertToInt(str);
            System.out.println(sumArray);

        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

    }

    public static long convertToInt(String[][] str) throws MyArraySizeException, MyArrayDataException {
        if (!arrayIsCorrect(str, 4))
            throw new MyArraySizeException("Не допустимый размер массива (должен быть 4 на 4)!");
        long sumArr = 0;
        for (int i = 0; i < str.length; i++){
            for (int j = 0; j < str[0].length; j++) {
                try{
                    sumArr += Integer.parseInt(str[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException("В ячейке " + i + ", " + j + " неверные данные.");
                }
            }
        }
        return sumArr;
    }

    private static boolean arrayIsCorrect(String[][] str, int correctSize) {
        if (str.length != correctSize)
            return false;
        for (String[] e: str) {
            if (e.length != correctSize)
                return false;
        }
        return true;
    }
}
