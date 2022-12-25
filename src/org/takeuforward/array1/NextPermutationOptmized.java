package org.takeuforward.array1;

import java.util.ArrayList;
import java.util.List;

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

    public static void printArray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
/*
prev = 0
cur = 0
next = 0
- Start parsing from end to start
if prev>curr & (curr>next | next>curr)
    temp = prev
    prev = curr
    curr = temp
else if curr>prev & curr>next & prev>next
    temp = prev
    prev = curr
    curr = next
    next = temp
else if curr>prev & curr>next & next>prev
    temp = prev;
    prev = next
    next = curr
    curr = temp
else if ()


else if cur>next && prev>next
    temp = prev
    prev = curr
    curr = next
    next = prev
else if cur>next && next>prev
    temp = prev
    prev = next
    next = curr
    curr = temp
* */












/*
- Continue to parse till current > previous
- if current == end then
    temp = current
    current = previous
    previous = temp
* if current > previous


* if previous < current > next/0
    temp = previous
    previous = next
    next = current
    current = temp
* if previous > current < next
    temp = current
    current = next
    next = temp
* if previous < current < next
    temp = previous
    previous = current
    current = next
    next = temp

 */