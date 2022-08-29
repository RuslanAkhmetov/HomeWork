package lesson11.HomeWork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 2 Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
         * телефонных номеров. В этот телефонный справочник с помощью метода add() можно
         * добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
         * учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
         * тогда при запросе такой фамилии должны выводиться все телефоны.*/

public class PhoneBookOld {
   /* private Map<String, String> recordMap;*/
    private Map<String , List<String>> map = new HashMap<>();

    public PhoneBookOld(Map<String, List<String>> map) {
        this.map = map;
    }

    public PhoneBookOld() {
        this.map = new HashMap<>();
    }



    /*public void add(String number, String surname){
          String newNumber = "";
          if (!recordMap.isEmpty() && recordMap.containsKey(surname))
               newNumber = recordMap.get(surname) + ", ";
          recordMap.put(surname, newNumber + number);
    }*/

    public void add(String number, String surname){
        List<String> phones = map.getOrDefault(surname, new ArrayList<>());
        phones.add(number);
        map.put(surname, phones);
    }

    public List<String> get(String surname){
        return map.getOrDefault(surname, new ArrayList<>());
    }

    public int size() {
        return map.size();
    }

    public String toString(){
        return map.toString();
    }
}
