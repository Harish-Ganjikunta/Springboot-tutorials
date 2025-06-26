package com.javasurfer.java.features.java8.interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class IntergersTest {


    public static void findEvenNumbers() {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        /** Find the even numbers from the list of integers
         *
         *  Using Stream api filter method
         */
        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).toList();
        System.out.println("Even Numbers Using filter method: " + evenNumbers);


        /** Find the even numbers from the list of integers
         *
         *  Using partitioningBy method
         */
        Map<Boolean, List<Integer>> evenNums = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Even Numbers Using partitioningBy method: " + evenNums.get(true));
    }


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

    public static void findFrequencyOfIntegers() {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,1,1,1,1,4,3,3,5,7,8);

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,1,1,1,1,4,3,3,5,7,8};

        /** Frequency Of numbers in a List
         * Using Collectors.groupingBy
         */
        Map<Integer,Long> frequencies = numbers.stream().collect(Collectors.groupingBy((Function.identity()),Collectors.counting()));
        System.out.println("Frequency of numbers using List: " + frequencies);


        /** Frequency Of numbers in a int[]
         * Using Collectors.groupingBy
         */
        Map<Integer,Long> frequency = Arrays.stream(nums).mapToObj(i -> (Integer) i).collect(Collectors.groupingBy((Function.identity()),Collectors.counting()));
        System.out.println("Frequency of numbers using Array: " + frequencies);

        /** Sorting the List of numbers in reverse order
         *
         * Using sorted method
         */
        List<Integer> sortedNumbers = numbers.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Sorted List of numbers in reverse order: " + sortedNumbers);

        /** Sorting the Array of numbers in reverse order
         *
         * Using boxed & sorted method
         */
        List<Integer> sortedNums = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Sorted Array of numbers in reverse order: " + sortedNums);

        /**
         * Sorting the Array of numbers in reverse order
         *
         * Using maptoObj & sorted method
         */
        List<Integer> sortedNums1 = Arrays.stream(nums).mapToObj(i -> (Integer) i).sorted(Comparator.reverseOrder()).toList();
        System.out.println("Sorted Array of numbers in reverse order: " + sortedNums1);
    }



    public static void main(String[] args) {
        //findEvenNumbers();
        //removeDuplicates();
        // findFrequencyOfChars();
        findFrequencyOfElementsOrWords();
        findFrequencyOfIntegers();
    }


}
