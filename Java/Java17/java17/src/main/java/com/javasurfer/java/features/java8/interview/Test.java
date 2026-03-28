package com.javasurfer.java.features.java8.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<List<Integer>> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(Arrays.asList(1, 2, 3));
        listOfIntegers.add(Arrays.asList(3, 2, 5));
        listOfIntegers.add(Arrays.asList(4, 5, 6, 7));

        listOfIntegers.stream().flatMap(List::stream).sorted().distinct().forEach(System.out::println);
    }
}
