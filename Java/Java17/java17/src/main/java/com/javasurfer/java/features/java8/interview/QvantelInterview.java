package com.javasurfer.java.features.java8.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QvantelInterview {


    public static void main(String[] args) {
        A a = new QvantelInterview().new B();
        a.m1();
        a.m2();
        System.out.println(a.i);
        System.out.println(a.j);

        printPairsOfTwoIntegerLists();
    }

    /**
     * Remove duplicates from a list of lists
     * This method demonstrates how to remove duplicates from a list of lists using Streams.
     */
    public static void removeDuplicatesFromListOfList() {
        List<List<Integer>> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(Arrays.asList(1, 2, 3));
        listOfIntegers.add(Arrays.asList(3, 2, 5));
        listOfIntegers.add(Arrays.asList(4, 5, 6, 7));

        // Remove duplicates from the array using distinct
        List<Integer> uniqueValues = listOfIntegers.stream().flatMap(List::stream)
                .distinct().toList();
        System.out.println("Array after removing duplicates: " + uniqueValues);

    }

    /**
     * Print pairs of two integer lists
     * <p>
     * Using flatMap and map methods
     * O/P [[1, 4], [1, 5], [2, 4], [2, 5], [3, 4], [3, 5]]
     */
    public static void printPairsOfTwoIntegerLists() {
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(4, 5);

        List<List<Integer>> pairs = list1.stream()
                .flatMap(i -> list2.stream().map(j -> List.of(i, j)))
                .toList();

        System.out.println(pairs); // Output: [[1, 4], [1, 5], [2, 4], [2, 5], [3, 4], [3, 5]]
    }

    class A {
        int i = 10;
        int j = 20;

        void m1() {
            System.out.println(i);
        }
        void m2() {
            System.out.println(j);
        }
    }

    class B extends A {
        int i = 30;
        int j = 40;

        void m1() {
            System.out.println(i);
        }
        void m2() {
            System.out.println(j);
        }
    }
}
