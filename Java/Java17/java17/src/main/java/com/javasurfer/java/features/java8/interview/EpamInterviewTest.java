package com.javasurfer.java.features.java8.interview;

import java.util.List;
import java.util.stream.IntStream;

public class EpamInterviewTest {

    public static void main(String[] args) {
        int[] array = {10, 30, 50, 70, 80};
        int key = 80;
        // printPairsLessThanKey(array,key);
        //printPairsLessThanKeyJava8(array, key);
        List<int[]> list = IntStream.range(0, array.length).boxed().
                flatMap(i -> IntStream.range(i + 1, array.length).filter(j -> array[i] + array[j] > key).mapToObj(j -> new int[]{array[i], array[j]})).toList();
       list.forEach(lis -> System.out.println("Pair: [" + lis[0] + ", " + lis[1] + "]"));
    }




    /**
     * Print all pairs in an array whose sum is less than a given key using java 7
     * @param array
     * @param key
     */
    public static void printPairsLessThanKey(int[] array, int key){
        //List<int[]> list = new ArrayList<>();
        for(int i=0;i<array.length;i++){
            for(int j=i+1; j<array.length;j++){
                if(array[i]+ array[j] < key){
                    //list.add(new int[]{array[i],array[j]});
                    System.out.println("Pair: [" + array[i] + ", " + array[j] + "]");
                }
            }
        }
    }

    public static void printPairsLessThanKeyJava8(int[] array, int key){
        List<int[]> pairs = IntStream.range(0,array.length).boxed().flatMap(i -> IntStream.range(i + 1,array.length)
                .filter(j -> array[i] + array[j] < key).mapToObj(j-> new int[]{array[i],array[j]})).toList();
        pairs.forEach(pair -> System.out.println("Pair: [" + pair[0] + ", " + pair[1] + "]"));
    }
}
