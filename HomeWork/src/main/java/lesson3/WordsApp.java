package lesson3;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class WordsApp {

    public static List<String> words = new ArrayList<>();

    /**
     * Печатает в консоль список всех слов (без дубликатов)
     */
    public static void printWordList(){
        Set<String> uniqueWords = new HashSet<>();
        String uniqueWord = "";
        for (String word : words) {
            uniqueWord = word;
            uniqueWords.add(uniqueWord);
        }
        System.out.println(uniqueWords);
    }

    /**
     * Печатает в консоль список только уникальных слов (не имеющих дубликатов)
     */
    public static void printUniqueWords() {
        int count;
        int i;
        for (i = 0; i < words.size(); i++) {
            count = 0;
            for (int j = 0; j < words.size(); j++)
                if (words.get(i).equals(words.get(j))) {
                    count++;
                }
            if (count == 1) {
                System.out.println(words.get(i));
            }
        }
    }

    /**
     * Считает сколько раз содержится в списке каждое слово (с дубликатами)
     */
    public static void countTheWords() {
        int count;
        int i;
        for (i = 0; i < words.size(); i++) {
            count = 0;
            for (int j = 0; j < words.size(); j++) {
                if (words.get(i).equals(words.get(j))) {
                    count++;
                }
            }
            System.out.println(words.get(i) + ": " + count);
        }
    }

    /**
     * Считает сколько раз содержится в списке каждое слово (без дубликатов)
     */
    public static void countTheWords2() {
        Map<String, Integer> countWords = new HashMap<>();
        Integer count;
        int i;
        for (i = 0; i < words.size(); i++) {
            count = 0;
            for(int j = 0; j < words.size(); j++) {
                if (words.get(i).equals(words.get(j))) {
                    count++;
                }
            }
            countWords.put(words.get(i), count);
        }
        System.out.println(countWords);
    }

    public static void main(String[] args) {
        words.add("Apple");
        words.add("Orange");
        words.add("Apple");
        words.add("Tomato");
        words.add("Pineapple");
        words.add("Pear");
        words.add("Cucumber");
        words.add("Apple");
        words.add("Pumpkin");
        words.add("Mandarin");
        words.add("Apple");
        words.add("Apple");
        words.add("Apple");
        words.add("Apple");
        words.add("Apple");
        words.add("Cucumber");

        printWordList();
        countTheWords();
        printUniqueWords();
        countTheWords2();
    }
}
