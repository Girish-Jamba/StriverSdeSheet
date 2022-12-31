package org.takeuforward.array2;

import java.util.Arrays;
import java.util.HashSet;

// https://takeuforward.org/data-structure/find-the-duplicate-in-an-array-of-n1-integers/
public class FindDuplicateinAnArrayOfNPlus1 {
    public static void main(String args[]) {
        //int nums[] = {2,2,2,2,2};
        //int nums[] = {1,2,1};
        //int nums[] = {1,3,4,2,3};
        int nums[] = {2,5,9,6,9,3,8,9,7,1};
        System.out.println(findDuplicate5(nums));
    }

// Time complexity: O(N). Since we traversed through the array only once.
//Space complexity: O(1).
    public static int findDuplicate5(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

// Time Complexity: O(N).
// Space Complexity: O(N).
    public static int findDuplicate4(int[] nums) {
        // This logic works if numbers are starting from 0/1 and are continuous in nature.
        int freq[] = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            if(freq[nums[i]] == 0)
                freq[nums[i]] += 1;
            else
                return nums[i];
        }
        return 0;
    }

// Time Complexity: O(N log N). NlogN for sorting the array and O(N) for traversing through the array and checking if adjacent elements are equal or not.
// Space Complexity: O(1).
    public static int findDuplicate3(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++) {
            if (nums[i] == nums[i+1])
                return nums[i];
        }
        return 0;
    }

// Time Complexity: O(N log N)
// Space Complexity: O(1).
    public static int findDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            if(set.contains(nums[i]))
                return nums[i];
            else
                set.add(nums[i]);
        }
        return 0;
    }

// Time Complexity: O(N)
// Space Complexity: O(1).
    public static int findDuplicate1(int[] nums) {
        int arrSum=0;
        int sum=0;
        for(int i=0; i<nums.length-1; i++) {
            arrSum += nums[i];
            sum += i+1;
        }
        arrSum += nums[nums.length-1];
        return arrSum-sum;
    }
}
