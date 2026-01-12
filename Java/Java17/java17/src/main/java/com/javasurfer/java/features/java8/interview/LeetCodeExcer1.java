package com.javasurfer.java.features.java8.interview;

import java.util.Arrays;

public class LeetCodeExcer1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 4, 0, 9, 5, 1, 3};
        findTripletWithGivenSum(nums,6);
    }

    /*Given an unsorted integer array, find a triplet with a given sum in it.
            Input:
    nums = [ 2, 7, 4, 0, 9, 5, 1, 3 ]
    target = 6
    Output: Triplet exists.
    The triplets with the given sum 6 are {0, 1, 5}, {0, 2, 4}, {1, 2, 3}*/

    public static void findTripletWithGivenSum(int[] nums, int target) {
       Arrays.sort(nums); //Sorted Array: [0, 1, 2, 3, 4, 5, 7, 9]
       // System.out.println("Sorted Array: "+Arrays.toString(nums));
        int[][] triplets = new int[3][3];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                if (currentSum == target) {
                    System.out.println("Triplet found: " + nums[i] + ", " + nums[left] + ", " + nums[right]);
                    //triplets[i] = new int[]{nums[i], nums[left], nums[right]};
                    left++;
                    right--;
                } else if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
       // System.out.println(Arrays.deepToString(triplets));

    }
}
