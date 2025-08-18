package com.javasurfer.java.features.java8.interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringsAndCharsTest {

    private static final List<String>  words= List.of("Apple", "Banana", "Apple", "Mango", "Banana", "Orange", "Kiwi", "Plum", "DragonFruit", "Kiwi");
    private static final Set<String>  set= Set.of( "Apple", "Mango", "Banana", "Orange", "Plum", "DragonFruit", "Kiwi");

    private static final String value = "Hello JavaSurfer how are you doing today";

    public static void main(String[] args) {
        //removeDuplicates();
        //findFrequencyOfChars();
        //findFrequencyOfElementsOrWords();
        //findFirstNonRepeatingCharacter();
        //highestRepeatedWords();
        reverseStringUsingStreams();
        //sortTheWordsBasedOnLength();
        //printOccurenceOfCharsUsingSet();
        firstRepeatedChar();
    }

    /**
     * Print the occurrence of characters in a string using Set
     * This method collects characters into a Map with their counts.
     */
    public static void printOccurenceOfCharsUsingSet(){
       Map<String,Long> occurenceOfChars = set.stream()
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()));
        System.out.println("Occurrence of Characters using Set: " + occurenceOfChars);
    }


    /**
     * Sort the words based on their length in ascending and descending order
     * This method demonstrates sorting using Streams with different criteria.
     */
    public static void sortTheWordsBasedOnLength() {
        List<String> sortedWordsInAsc = words.stream().sorted(Comparator.comparing(String::length)).toList();
        System.out.println("Sorted  Words in ASC Based on Length: " + sortedWordsInAsc);

        List<String> sortedWordsInDesc = words.stream().sorted(Comparator.comparing(String::length).reversed()).toList();
        System.out.println("Sorted  Words in DESC Based on Length: " + sortedWordsInDesc);

        List<String> sortedWordsInAscByLengthAndAlphabetically = words.stream()
                .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
                .toList();
        System.out.println("Sorted  Words in ASC Based on Length and Alphabetically: " + sortedWordsInAscByLengthAndAlphabetically);

        List<String> sortedWordsInDescByLengthAndAlphabetically = words.stream().sorted(Comparator.comparing(String::length).reversed().thenComparing(Comparator.naturalOrder())).toList();
        System.out.println("Sorted  Words in DESC Based on Length and Alphabetically: " + sortedWordsInDescByLengthAndAlphabetically);
    }
    /**
     * Remove duplicates from a list of words
     * This method demonstrates two ways to remove duplicates using Streams.
     */
    public static void removeDuplicates() {
       // List<String> words = List.of("Apple", "Banana", "Apple", "Mango", "Banana", "Orange", "Kiwi", "Plum", "DragonFruit", "Kiwi");

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

        Set<String> uniques1 = new HashSet<>(words);
        System.out.println("Unique Words Using HashSet: " + uniques1);

        Set<String> uniques2 = new LinkedHashSet<>(words);
        System.out.println("Unique Words Using LinkedHashSet: " + uniques2);
    }

    /**
     * Find the frequency of characters in a string
     * This method uses Collectors.groupingBy to count occurrences of each character.
     */
    public static void findFrequencyOfChars() {
        String value = "Hello JavaSurfer how are you doing today";

        /** Frequency Of characters in a String
         *
         * Using Collectors.groupingBy
         */
        Map<Character, Long> frequency = value.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency of Characters: " + frequency);

        /** Frequency Of characters in a String by converting to lower case and removing spaces
         *
         * Using Collectors.groupingBy with replaceAll and toLowerCase
         */
        Map<Character,Long> frequency2 = value.replaceAll(" ", "").toLowerCase().chars().mapToObj(c -> (char)c ).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("Frequency of Characters after removing spaces and converting to lower case: " + frequency2);
    }

    /**
     * Find the frequency of elements or words in a list
     * This method uses Collectors.groupingBy to count occurrences of each word.
     */
    public static void findFrequencyOfElementsOrWords() {

        //List<String> words = List.of("Apple", "Banana", "Apple", "Mango", "Banana", "Orange", "Kiwi", "Plum", "DragonFruit", "Kiwi");

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

    /**
     * Find the first non-repeating character in a string
     * Using Collectors.groupingBy and Stream API
     */
    public static void findFirstNonRepeatingCharacter() {
        String str = "Hello JavaSurfer how are you doing today";

        Map<Character, Long> frequency = value.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        //System.out.println("frequency: " + frequency);
        Character firstNonRepeating = frequency.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println("First Non-Repeating Character: " + firstNonRepeating);

        //First Non-Repeating Character using alternative method

        Character nonRepetedChar = value.chars().mapToObj(c-> (char)c).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter(entry ->entry.getValue() ==1).map(Map.Entry::getKey).findFirst().orElse(null);
        System.out.println("First Non-Repeating Character using alternative method: " + nonRepetedChar);
    }

    /**
     * First repeated Character
     */
    public static void firstRepeatedChar(){
        Character repeatedCharacter =  value.chars().mapToObj(c-> (char) c).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter(entry ->entry.getValue()>1L).map(Map.Entry::getKey).findFirst().orElse('0');
        System.out.println("First Repeated Character:: "+repeatedCharacter);
    }

    /**
     * Find the highest repeated word in a string
     * This method uses two different approaches to find the most repeated word.
     */
    public static void highestRepeatedWords(){
        String value = "Hello JavaSurfer how how are you doing today are you good today good good good good how how how how how how how";

        //Method 1 to get the highest repeated word
        Arrays.stream(value.split(" ")).collect(Collectors.groupingBy((Function.identity()),Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue())
                .ifPresent(entry -> System.out.println("Method 1 :: Highest Repeated Word: " + entry.getKey() + " with frequency: " + entry.getValue()));

        //Method 2 to get the most repeated word
        String mostRepeatedWord = Arrays.stream(value.split(" ")).collect(Collectors.groupingBy((Function.identity()),Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse("No words found");
        System.out.println("Method 2 :: Most Repeated Word: " + mostRepeatedWord);
        //.max(Comparator.naturalOrder()).
    }

    /**
     * Reverse the words in a string using Streams
     * This method reverses the entire string, not just the order of words.
     */
    public static void reverseStringUsingStreams() {
        String str = "Hello How are you doing today";
        String reversed = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    Collections.reverse(list);
                    return list.stream().map(String::valueOf).collect(Collectors.joining());
                }));
        System.out.println("Reversed Words in String: " + reversed);

        String reversedWords = Arrays.stream(str.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println("Reveserd Words in Str method1: "+reversedWords);

    }

}
