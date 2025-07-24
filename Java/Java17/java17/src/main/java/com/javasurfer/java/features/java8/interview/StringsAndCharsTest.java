package com.javasurfer.java.features.java8.interview;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringsAndCharsTest {

    public static void removeDuplicates() {
        List<String> words = List.of("Apple", "Banana", "Apple", "Mango", "Banana", "Orange", "Kiwi", "Plum", "DragonFruit", "Kiwi");

        /** Remove duplicates from the list of words
         *
         * Using distinct method
         */
        List<String> unique = words.stream().distinct().collect((Collectors.toList()));
        System.out.println("Unique Words Using distinct method: " + unique);

        /** Remove duplicates from the list of words
         *
         * Using Collectors.toSet()
         */
        Set<String> uniques = words.stream().collect(Collectors.toSet());
        System.out.println("Unique Words Using Collectors.toSet() method: " + uniques);

    }

    public static void findFrequencyOfChars() {
        String value = "Hello JavaSurfer how are you doing today";

        /** Frequency Of characters in a String
         *
         * Using Collectors.groupingBy
         */
        Map<Character, Long> frequency = value.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency of Characters: " + frequency);
    }

    public static void findFrequencyOfElementsOrWords() {

        List<String> words = List.of("Apple", "Banana", "Apple", "Mango", "Banana", "Orange", "Kiwi", "Plum", "DragonFruit", "Kiwi");

        /** Frequency Of words in a List
         *
         * Using Collectors.groupingBy
         */
        Map<String,Long> frequencies = words.stream().collect(Collectors.groupingBy((Function.identity()),Collectors.counting()));
        System.out.println("Frequency of Words: " + frequencies);


        /** Sorting the words in reverse order
         *
         * Using sorted method
         */
        List<String> sortedList =words.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Sorted List in reverse order: " + sortedList);

    }


    public static void main(String[] args) {
        //removeDuplicates();
        // findFrequencyOfChars();
        //findFrequencyOfElementsOrWords();
    }


}
