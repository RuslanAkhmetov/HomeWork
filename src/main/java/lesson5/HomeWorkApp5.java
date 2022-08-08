package lesson5;

import java.math.BigDecimal;

class Person{
    private String fio;
    private String role;
    private String email;
    private String phone;
    private long salary;
    private int age;

    public Person(String fio, String role, String email, String phone, long salary, int age) {
        this.fio = fio;
        this.role = role;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printPerson(){
        System.out.println("Person: " + fio + " role: " + role + " email: "+ email + " phone: " + phone + " salary: " + salary + " age: " + + age );
    }

    public int getAge() {
        return age;
    }
}

public class HomeWorkApp5 {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];   // Вначале объявляем массив объектов
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312",  50000, 30); // потом для каждой ячейки массива задаем объект
        persArray[1] = new Person("Petrov Petr", "Director", "petrov@mailbox.com", "891122222", 100000, 50);
        persArray[2] = new Person("Skvortcova Irina", "Designer", "Skvortcova@mailbox.com", "891122234",  30000, 25);
        persArray[3] = new Person("Fedorova Maria", "Accountant", "Fedorova@mailbox.com", "8911212234",  40000, 45);
        persArray[4] = new Person("Sidorov Grigoriy", "Engineer", "Sidorov@mailbox.com", "891178235",  40000, 35);

        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge() > 40)
                    persArray[i].printPerson();
        }

    }
}
