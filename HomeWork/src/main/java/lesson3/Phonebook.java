package lesson3;

import java.util.*;


public class Phonebook {

    private static Map<Integer, String> phonebook = new HashMap<>();

    private static void add(Integer phoneNumber, String surname) {
        phonebook.put(phoneNumber, surname);
    }

    /**
     * Поиск всех имеющихся телефонных номеров для заданной фамилии
     * @param surname
     */
    private static void findPhoneNumber(String surname){
        System.out.print("Surname: " + surname);
        System.out.print(" Phone number:");
        for (Map.Entry<Integer, String> o : phonebook.entrySet()) {
            if (o.getValue().equals(surname) )  {
                System.out.print(" " + o.getKey() + "/");
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {

        add(12378965, "Ivanov");
        add(12345678, "Petrov");
        add(12378976, "Ivanov");
        add(64782467, "Sidorov");
        add(16351735, "Rogov");
        add(41236187, "Ivanov");



        findPhoneNumber("Ivanov");
        findPhoneNumber("Petrov");


    }
}
