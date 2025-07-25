package com.javasurfer.java.features.java8.interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntergersTest {
    private static  final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,1,1,1,1,4,3,3,5,7,8);
    private static final int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,1,1,1,1,4,3,3,5,7,8};

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


    /**
     * Merge two arrays and sort them
     *
     * Using IntStream::concat, distinct and sorted methods
     */
    public static void mergeArrays(){
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4,5, 6,7, 8, 9, 10};

        int[] mergedArray = IntStream.concat(Arrays.stream(arr1),Arrays.stream(arr2)).distinct().sorted().toArray();
        System.out.println(" Using IntStream:: Merged and Sorted Array: " + Arrays.toString(mergedArray));

        List<Integer> mergedArrayToList = IntStream.concat(Arrays.stream(arr1),Arrays.stream(arr2)).distinct().sorted().boxed().toList();

        System.out.println(" Using IntStream:: Merged and Sorted Array to List: " + mergedArrayToList);
    }

    /**
     * Find the smallest values in an array
     *
     * Using IntStream::sorted and limit methods
     */
    public static void findSmallestValues(){
        int[] arr = { 9, 10,50, 60, 70, 80, 90, 1001, 2,2, 3, 4, 5, 6, 7, 8,};

        // Find the smallest 4 values in the array
        int[] smallest4Values = IntStream.of(arr).distinct().sorted().limit(4).toArray();
        System.out.println("Smallest 4 values in the array: " + Arrays.toString(smallest4Values));

        // Find the smallest 4 values in the array and convert to List
        List<Integer> smallest4ValuesList = IntStream.of(arr).distinct().sorted().limit(4).boxed().toList();
        System.out.println("Smallest 4 values in the array as List: " + smallest4ValuesList);

        List<String> smallest4ValuesListAsString = IntStream.of(arr).distinct().sorted().limit(4).mapToObj(String::valueOf).toList();
        System.out.println("Smallest 4 values in the array as List of Strings: " + smallest4ValuesListAsString);

    }


    public static void findLargestValues() {
        int[] arr = {9, 10, 50, 60, 70, 80, 90, 1001, 2, 2, 3, 4, 5, 6, 7, 8,};

        List<Integer> numbers = List.of(9, 10, 50, 60, 70, 80, 90, 1001, 2, 2, 3, 4, 5, 6, 7, 8);

        // Find the largest 4 values in the array using skip
        int[] largest4Values = IntStream.of(arr).distinct().sorted().skip(arr.length - 4).toArray();
        System.out.println("Largest 4 values in the array: " + Arrays.toString(largest4Values));

        // Find the largest 4 values in the array and convert to List using skip
        List<Integer> largest4ValuesList = IntStream.of(arr).distinct().sorted().skip(arr.length - 5).boxed().toList();
        System.out.println("Largest 4 values in the array as List: " + largest4ValuesList);

        //convert the largest 4 values to List of integers to int[]
        int[] largest4ValuesArray = numbers.stream().distinct().sorted(Comparator.reverseOrder()).limit(4).mapToInt(Integer::intValue).toArray();
        System.out.println("Largest 4 values in the List as Array: " + Arrays.toString(largest4ValuesArray));
    }

    public static void findFistNonRepeatedValue(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,1,1,1,1,4,3,3,5,7,8);
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,1,1,1,1,4,3,3,5,7,8};

        // Find the first non-repeated value in the List
        Integer firstNonRepeatedValue = numbers.stream().collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() == 1L).map(Map.Entry::getKey).findFirst().orElse(-1);
        System.out.println("First Non-Repeated Value in List: " + firstNonRepeatedValue);

        // Find the first non-repeated value in the Array method 1
        Integer firstNonRepeatedArrayValue = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() == 1L).map(Map.Entry::getKey).findFirst().orElse(-1);
        System.out.println("First Non-Repeated Value in Array using boxed method 1: " + firstNonRepeatedArrayValue);

        Integer firstNonRepeatedArrayValue1 = IntStream.of(nums).boxed().collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter(entry->entry.getValue()==1L).map(Map.Entry::getKey).findFirst().orElse(-1);
        System.out.println("First Non-Repeated Value in Array using boxed method 2:"+firstNonRepeatedArrayValue1);
    }


    public static void printReverseOfArray(){
        int[] reverseArray = IntStream.rangeClosed(1,nums.length).map(i ->nums[nums.length-i]).toArray();
        System.out.println("Original Array: " + Arrays.toString(nums));
        System.out.println("Reverse of Array: " + Arrays.toString(reverseArray));
    }

    public static void main(String[] args) {
        //findEvenNumbers();
        //findFrequencyOfIntegers();
        //mergeArrays();
        //findSmallestValues();
       // findLargestValues();
        //findFistNonRepeatedValue();
        printReverseOfArray();
    }


}
