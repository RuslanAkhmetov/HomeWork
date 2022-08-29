package lesson11.HomeWork;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        testStrringArray();
        testPhoneBook();

    }

    private static void testStrringArray() {
        /*String[] stringArray = {...};
         * 1 Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и
         * вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
         * Посчитать, сколько раз встречается каждое слово. <string, count>
         * Использовать коллекции и Map!*/
        String[] stringArray="Москва́ (произношение (инф.)) — столица России, город федерального значения, административный центр Центрального федерального округа и центр Московской области, в состав которой не входит[6]. Крупнейший по численности населения город России и её субъект — 12 635 466[3] человек (2022), самый населённый из городов, полностью расположенных в Европе, занимает 22-е место среди городов мира по численности населения[7], крупнейший русскоязычный город в мире. Центр Московской городской агломерации.".split(" ");
        Set<String> stringSet = new HashSet<>();
        Collections.addAll(stringSet, stringArray);
        System.out.println("Уникальные слова: " + stringSet);
        HashMap<String, Long> stringIntegerHashMap = new HashMap<>();
//        stringSet.forEach(s -> stringIntegerHashMap.put(s,countWord(s,stringArray)));
        stringSet.forEach(s -> stringIntegerHashMap.put(s, Arrays.stream(stringArray).filter(it -> it.equals(s)).count()));
        System.out.println("Уникальные слова встречаются: " + stringIntegerHashMap);
    }

    private static void testPhoneBook() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("+7911111111", "Smith");
        phoneBook.add("+7911111112", "Smith");
        phoneBook.add("+7911111113", "Smith");
        phoneBook.add("+7911111114", "Pit");
        phoneBook.add("+7911111115", "Pit");
        phoneBook.add("+7911111116", "Abbot");
        System.out.println(phoneBook);
        System.out.println("Smith's phone: " + phoneBook.get("Smith"));
        System.out.println("Abbot's phone: " + phoneBook.get("Abbot"));
        System.out.println("Anybody's phone: " + phoneBook.get("Anybody"));

        PhoneBookOld phoneBookOld = new PhoneBookOld();
        phoneBookOld.add("+7911111111", "Smith");
        phoneBookOld.add("+7911111112", "Smith");
        phoneBookOld.add("+7911111113", "Smith");
        phoneBookOld.add("+7911111114", "Pit");
        phoneBookOld.add("+7911111115", "Pit");
        phoneBookOld.add("+7911111116", "Abbot");
        System.out.println(phoneBookOld);
        System.out.println("Smith's phone: " + phoneBookOld.get("Smith"));
        System.out.println("Abbot's phone: " + phoneBookOld.get("Abbot"));
        System.out.println("Anybody's phone: " + phoneBookOld.get("Anybody"));
    }

    public static Long countWord(String word, String[] array){
        Long sum = 0L;
        for (String s : array) {
            if (word.equals(s))
                sum++;
        }
        return sum;
    }
}
