package com.javasurfer.java.features.java8.interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Coforge_Interview {

        public static void main(String[] args) {
             // swapTwoStringsWithoutTempVariableAndLoops();
            //countFrequencyOfCharsInStringUsingJava8();
            int[] a = {10, 15, 20, 25};
            int[] b = {};
            printGroup(a, 1, 2); // prints 10,15
            printGroup(a, 2, 2); // prints 20,25
        }



        public static void swapTwoStringsWithoutTempVariableAndLoops() {
            String str1 = "Java";
            String str2 = "Software";

            System.out.println("Before Swap: str1 = " + str1 + ", str2 = " + str2);

            // Swapping without a temporary variable
            str1 = str1 + str2; // Concatenate both strings // "javasoftware"
            str2 = str1.substring(0, str1.length() - str2.length()); // Extract original str1 // original s1 -> "java"
            str1 = str1.substring(str2.length()); // Extract original str2 // original s2 -> "software"

            System.out.println("After Swap: str1 = " + str1 + ", str2 = " + str2);
        }


        public static void countFrequencyOfCharsInStringUsingJava8(){
            String s= "Java";
           Map<Character,Long> frequency= s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()));
            System.out.println("Frequency of chars in string: "+frequency);

        }


       public  static void printGroup(int[] a, int n, int groupSize) {
            if (n < 1) {
                System.out.println("n must be >= 1");
                return;
            }
            int start = (n - 1) * groupSize;
            if (start >= a.length) {
                System.out.println("No elements for n=" + n);
                return;
            }
            int end = Math.min(start + groupSize, a.length);
            for (int i = start; i < end; i++) {
                System.out.print(a[i]);
                if (i < end - 1) System.out.print(",");
            }
            System.out.println();
        }


}
