package lesson3;

import java.util.*;


public class Phonebook {

    private static Map<Integer, String> phonebook = new HashMap<>();

    private static void add(Integer phoneNumber, String surname) {
        phonebook.put(phoneNumber, surname);
    }

    private static void findPhoneNumber(String surname){
        List<Integer> numbers = new ArrayList<>();
        Integer phoneNumber = 0;
        for (Integer n : phonebook.keySet()) {
            if (phonebook.get(n).equals(surname) )  {
                phoneNumber = n;
                numbers.add(phoneNumber);
            }
        }
        System.out.print("Surname: " + phonebook.get(phoneNumber));
        System.out.print(" Phone number: ");
        for (int i = 0; i < numbers.size(); i++){
            System.out.print(" " + numbers.get(i) + "/");
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
