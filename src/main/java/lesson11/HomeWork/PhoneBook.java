package lesson11.HomeWork;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> recordMap;

    public PhoneBook() {
        this.recordMap = new HashMap<>();
    }

    public PhoneBook(Map<String, String> recordMap) {
        this.recordMap = recordMap;
    }

    public void add(String number, String surname){
        recordMap.put(number, surname);
    }

    public String get(String surname){
        String str = "";
        if (recordMap.containsValue(surname)){
        for (Map.Entry<String,String> entry: recordMap.entrySet()) {
            if (entry.getValue().equals(surname))
                str= str.length()==0 ? entry.getKey(): str + ", " + entry.getKey();
        }}
        //recordMap.forEach((k,v) -> System.out.println(k));//if (v == surname) str+= k); //.gegetOrDefault(surname, "");
        return str;
    }

    public int size() {
        return recordMap.size();
    }

    public String toString(){
        return recordMap.toString();
    }
}
