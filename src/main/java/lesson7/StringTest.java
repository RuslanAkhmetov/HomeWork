package lesson7;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

import static java.lang.System.*;

public class StringTest {
    public static void main(String[] args) {
        String str1 = "Some text!"; //new String("abc"); // "abc";
        String str2 = null; // "abc";

//        System.out.println(str1 == str2);
        //System.out.println(str2.equals(str1));
//        System.out.println(Objects.equals(str1, str2));
        /*for (int i = 0; i < str1.length() ; i++) {
            System.out.print(str1.charAt(i)+", ");
        }*/
        char[] chars = str1.toCharArray();
        Arrays.sort(chars);

       /* for (int i = 0; i < chars.length; i++) {
            System.out.print((int)chars[i]);
        }*/

        String string = null; // "   ";
        String blankString = "";
       // System.out.println("Is string empty: " + (blankString.length() == 0));
       // System.out.println("Is string blank: " + string.isBlank());
        // System.out.println("Is string blank: " + CheckStringIsBlank(string));
        String first = "first";
        String second = "string";
        String concatString;
        concatString = first + " " + second;

        /*System.out.println(concatString);
        System.out.println(first.concat(second));
        first = "first first";
        System.out.println(first);*/

        /*String str23 = "  строка  ";
        out.println(str23.trim());
        String str45 = "ABC";
        String str46 = "abc";
        out.println(str45.equalsIgnoreCase(str46));
        out.println(" ".repeat(5 ).concat(str45).concat(" ".repeat(5)));*/
        //" ".translateEscapes();
     /*   String text = "Вопрос по весам: в инвойсе указаны веса нетто отдельно для каждой позиции, а брутто только общий.";
        String[] splited = text.split(" ");
        out.println(splited[14]);
        out.println(text.indexOf(" "));
        out.println(text.substring(24));
        out.println(String.valueOf(true));*/
        /*String str456 = "asdfghjkl";
        stringBuilder(str456);*/
        stringHash();


    }

    public static void stringBuilder(String str){
        StringBuilder builder = new StringBuilder(str);
        builder.append("abc");
        builder.append("def");
        out.println(builder.substring(2,3));

        builder.append("xxx");
        out.println(builder.reverse());
        out.println(builder.insert(2,22));
    }

    public static void  stringBuffer(){
        //то же самое что StringBuilder но он потокобезопасен
    }

    public static boolean CheckStringIsBlank(String string){
        return string == null || string.isBlank();
    }

    public static  void stringHash(){
        String string = "string";
        int hashCode = string.hashCode();

        //Если объекты равны через equals то у них одинаковые hashcode
        //Обратное неверно

        String user = "username";
        String password = "password";
        String passwordFromForm = "password1";

        out.println("Пароль верный:" + password.equals(passwordFromForm));  //неправильно так как пароли не хранят
        out.println("Пароль верный:" + (password.hashCode() == passwordFromForm.hashCode()));  //правильно так как пароли не хранят, а хранят hashCode



    }
}
