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
