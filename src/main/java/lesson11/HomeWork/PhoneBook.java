package lesson11.HomeWork;

import java.util.HashMap;
import java.util.Map;

/** 2 Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
         * телефонных номеров. В этот телефонный справочник с помощью метода add() можно
         * добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
         * учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
         * тогда при запросе такой фамилии должны выводиться все телефоны.*/

public class PhoneBook {
    private Map<String, String> recordMap;

    public PhoneBook() {
        this.recordMap = new HashMap<>();
    }

    public PhoneBook(Map<String, String> recordMap) {
        this.recordMap = recordMap;
    }

    public void add(String number, String surname){
          String newNumber = "";
          if (!recordMap.isEmpty() && recordMap.containsKey(surname))
               newNumber = recordMap.get(surname) + ", ";
          recordMap.put(surname, newNumber + number);
    }

    public String get(String surname){
        return recordMap.getOrDefault(surname, "");
    }

    public int size() {
        return recordMap.size();
    }

    public String toString(){
        return recordMap.toString();
    }
}
