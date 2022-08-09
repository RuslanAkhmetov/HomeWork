package lesson9;

import java.io.File;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

//        int  number = stringToInteger("2a2");
        System.out.println(tryWithFinally());
//        System.out.println(readTextFromFile1());

    }
    private  static double divide1 (int a, int b){
        return divide (a,  b);
    }
    private  static double divide (int a, int b){
        if (b==0){
            throw new IllegalArgumentException("делитель не может быть равен 0");
        }
        return a/b;
    }

    public static String readTextFromFile1()  {
        String s = readTextFromFile();
        return s;
    }
    public static String readTextFromFile() {

        Path filePath = Path.of("README1.md");
        try {
            return Files.readString(filePath);

        } catch (AccessDeniedException  | NoSuchFileException e){
            System.out.println( "ОШИБКА: нет доступа к файлу: " + e.getMessage());
        } catch ( IOException e ){
            e.printStackTrace();
            System.out.println( "ОШИБКА: не удалось прочитать: " + e.getMessage());
        }
        return "";
    }

    public static int getStringLength (String s) throws NoSuchFileException {
        if (s == null){
                throw new IllegalArgumentException();
            }
            return s.length();
        }

    public static int getStringLengthIfLengthIsNotSix (String s) throws MySizeExeption {
        if (s == null){
            throw new IllegalArgumentException();
        } else if (s.length() == 6) {
            throw new MySizeExeption("Длина равна 6");
        }
        return s.length();

    }

    public static int stringToInteger(String text){
//        try {
            return Integer.parseInt(text);
//        } /*catch (NumberFormatException e){
//            return 0;
//        }*/
    }
    public static int tryWithFinally(){
        int result = 0;
        try {
            result += stringToInteger("2");
            result += stringToInteger("5");
            result += stringToInteger("10");
            System.out.println("No exeption");
            return 1;

        } catch (NumberFormatException e){
            System.out.println("Exeption");
            e.printStackTrace();
        }finally {
            System.out.println("Finally!");
            return result;
        }
    }


}
