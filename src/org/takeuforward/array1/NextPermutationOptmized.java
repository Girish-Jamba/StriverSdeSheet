package org.takeuforward.array1;

import java.util.ArrayList;
import java.util.List;

import static org.takeuforward.CommonUtils.printArray;

// https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/
// Time Complexity: O(N). For the first iteration backward, the second interaction backward and reversal at the end takes O(N) for each, where N is the number of elements in the input array. This sums up to 3*O(N) which is approximately O(N).
// Space Complexity: O(1)
public class NextPermutationOptmized {
    public static void main(String args[]) {
        int nums[] = {1,5,1};
        printArray(nums);
        nextPermutation(nums);
        printArray(nums);
    }

    public static void nextPermutation(int[] nums) {
        if(nums == null || nums.length<=1)
            return;

        int i=nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1])
            i--;

        if(i>=0) {
            int j = nums.length-1;
            while(nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1, nums.length-1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int nums[], int i, int j) {
        while(i<j)
            swap(nums, i++, j--);
    }
}