package lesson3;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class WordsApp {

    public static List<String> words = new ArrayList<>();

    public static void printUniqueWords(){
        Set<String> uniqueWords = new HashSet<>();
        String uniqueWord = "";
        for (String word : words) {
            uniqueWord = word;
            uniqueWords.add(uniqueWord);
        }
        System.out.println(uniqueWords);
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



        printUniqueWords();
    }
}
