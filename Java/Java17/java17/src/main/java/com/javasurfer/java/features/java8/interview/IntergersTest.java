package com.javasurfer.java.features.java8.interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntergersTest {
    private static final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 1, 4, 3, 3, 5, 7, 8);
    private static final int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 1, 4, 3, 3, 5, 7, 8};


    public static void main(String[] args) {
        //findEvenNumbers();
        //findFrequencyOfIntegers();
        //mergeArrays();
        //findSmallestValues();
        // findLargestValues();
        //findFistNonRepeatedValue();
        //printReverseOfArray();
        //removeDuplicatesFromListOfList();
        findMinAndMaxNumInList();
    }

    public static void findMinAndMaxNumInList(){
        System.out.println("List of numbers: " + numbers);
        numbers.stream().min(Integer::compareTo).ifPresent(min -> System.out.println("Method1 :: using min() Minimum number in the list: " + min));
        numbers.stream().max(Integer::compareTo).ifPresent(max -> System.out.println("Method1 :: using max() Maximum number in the list: " + max));

        Integer min =  numbers.stream().min(Integer::compareTo).orElse(null);
        Integer max =  numbers.stream().max(Integer::compareTo).orElse(null);
        System.out.println("Method2 :: using min() and max() Minimum number in the list: " + min+ " And Maximum number in the list: " + max);

        Integer min1 = numbers.stream().reduce(Integer::min).orElse(null);
        Integer max1 = numbers.stream().reduce(Integer::max).orElse(null);
        System.out.println("Method3 :: using reduce() Minimum number in the list: " + min1 + " And Maximum number in the list: " + max1);

        Integer minNum2 = numbers.stream().collect(Collectors.minBy(Integer::compareTo)).orElse(null);
        Integer maxNum2 = numbers.stream().collect(Collectors.maxBy(Integer::compareTo)).orElse(null);
        System.out.println("Method4 :: using collect() Minimum number in the list: " + minNum2 + " And Maximum number in the list: " + maxNum2);

        Integer minNum = numbers.stream().sorted(Comparator.reverseOrder()).findFirst().orElse(-1);
        Integer maxNum = numbers.stream().sorted().findFirst().orElse(-1);
        System.out.println("Method5 :: using sorted() Minimum number in the list: " + minNum + " And Maximum number in the list: " + maxNum);

        Integer minN1 = numbers.stream().min(Comparator.naturalOrder()).orElse(null);
        Integer maxN1 = numbers.stream().max(Comparator.naturalOrder()).orElse(null);
        System.out.println("Method6 :: using min() and max() Minimum number in the list: " + minN1 + " And Maximum number in the list: " + maxN1);


        Integer minNu1 = numbers.stream().reduce(Integer.MIN_VALUE, Integer::min);
        Integer maxNu1 = numbers.stream().reduce(Integer.MAX_VALUE, Integer::max);
        System.out.println("Method7 :: using reduce() Minimum number in the list: " + minNu1 + " And Maximum number in the list: " + maxNu1);

        Integer minNum1 = numbers.stream().reduce((a, b) -> a < b ? a : b).orElse(null);
        Integer maxNum1 = numbers.stream().reduce((a, b) -> a > b ? a : b).orElse(null);
        System.out.println("Method8 :: using reduce() Minimum number in the list: " + minNum1 + "And Maximum number in the list: " + maxNum1);
    }

    /**
     * Find the even numbers from the list of integers
     * <p>
     * Using Stream api filter method and partitioningBy method
     */
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

    /**
     * Find the frequency of integers in a List and an Array
     * <p>
     * Using Collectors.groupingBy and sorted methods
     */
    public static void findFrequencyOfIntegers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 1, 4, 3, 3, 5, 7, 8);
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 1, 4, 3, 3, 5, 7, 8};
        /** Frequency Of numbers in a List
         * Using Collectors.groupingBy
         */
        Map<Integer, Long> frequencies = numbers.stream().collect(Collectors.groupingBy((Function.identity()), Collectors.counting()));
        System.out.println("Frequency of numbers using List: " + frequencies);
        /** Frequency Of numbers in a int[]
         * Using Collectors.groupingBy
         */
        Map<Integer, Long> frequency = Arrays.stream(nums).mapToObj(i -> (Integer) i).collect(Collectors.groupingBy((Function.identity()), Collectors.counting()));
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
     * <p>
     * Using IntStream::concat, distinct and sorted methods
     */
    public static void mergeArrays() {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 5, 6, 7, 8, 9, 10};

        int[] mergedArray = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).distinct().sorted().toArray();
        System.out.println(" Using IntStream:: Merged and Sorted Array: " + Arrays.toString(mergedArray));

        List<Integer> mergedArrayToList = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).distinct().sorted().boxed().toList();
        System.out.println(" Using IntStream:: Merged and Sorted Array to List: " + mergedArrayToList);
    }

    /**
     * Find the smallest values in an array
     * <p>
     * Using IntStream::sorted and limit methods
     */
    public static void findSmallestValues() {
        int[] arr = {9, 10, 50, 60, 70, 80, 90, 1001, 2, 2, 3, 4, 5, 6, 7, 8,};

        // Find the smallest 4 values in the array
        int[] smallest4Values = IntStream.of(arr).distinct().sorted().limit(4).toArray();
        System.out.println("Smallest 4 values in the array: " + Arrays.toString(smallest4Values));

        // Find the smallest 4 values in the array and convert to List
        List<Integer> smallest4ValuesList = IntStream.of(arr).distinct().sorted().limit(4).boxed().toList();
        System.out.println("Smallest 4 values in the array as List: " + smallest4ValuesList);

        List<String> smallest4ValuesListAsString = IntStream.of(arr).distinct().sorted().limit(4).mapToObj(String::valueOf).toList();
        System.out.println("Smallest 4 values in the array as List of Strings: " + smallest4ValuesListAsString);

    }

    /**
     * Find the largest values in an array and a List
     * <p>
     * Using IntStream::sorted, skip and limit methods
     */
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

    /**
     * Find the first non-repeated value in a List and an Array
     * <p>
     * Using Collectors.groupingBy, LinkedHashMap and Stream API
     */
    public static void findFistNonRepeatedValue() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 1, 4, 3, 3, 5, 7, 8);
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 1, 4, 3, 3, 5, 7, 8};

        // Find the first non-repeated value in the List
        Integer firstNonRepeatedValue = numbers.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() == 1L).map(Map.Entry::getKey).findFirst().orElse(-1);
        System.out.println("First Non-Repeated Value in List: " + firstNonRepeatedValue);

        // Find the first non-repeated value in the Array method 1
        Integer firstNonRepeatedArrayValue = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() == 1L).map(Map.Entry::getKey).findFirst().orElse(-1);
        System.out.println("First Non-Repeated Value in Array using boxed method 1: " + firstNonRepeatedArrayValue);

        Integer firstNonRepeatedArrayValue1 = IntStream.of(nums).boxed().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() == 1L).map(Map.Entry::getKey).findFirst().orElse(-1);
        System.out.println("First Non-Repeated Value in Array using boxed method 2:" + firstNonRepeatedArrayValue1);
    }

    /**
     * Print the reverse of an array
     * <p>
     * Using IntStream::rangeClosed and map methods
     */
    public static void printReverseOfArray() {
        int[] reverseArray = IntStream.rangeClosed(1, nums.length).map(i -> nums[nums.length - i]).toArray();
        System.out.println("Original Array: " + Arrays.toString(nums));
        System.out.println("Reverse of Array: " + Arrays.toString(reverseArray));
    }

    /**
     * Remove duplicates from a List of Lists
     * <p>
     * Using flatMap and distinct methods
     */
    public static void removeDuplicatesFromListOfList() {
        List<List<Integer>> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(Arrays.asList(1, 2, 3));
        listOfIntegers.add(Arrays.asList(3, 2, 5));
        listOfIntegers.add(Arrays.asList(4, 5, 6, 7));

        // Remove duplicates from the array using distinct
        List<Integer> uniqueValues = listOfIntegers.stream().flatMap(List::stream)
                .distinct().toList();
        //.collect(Collectors.toList());
        System.out.println("Array after removing duplicates: " + uniqueValues);

        List<Integer> uniqueValues1 = listOfIntegers.stream().flatMap(l -> l.stream()).distinct().toList();//collect(Collectors.toList());
        System.out.println("Array after removing duplicates: " + uniqueValues1);
    }
}
