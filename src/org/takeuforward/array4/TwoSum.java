package org.takeuforward.array4;

import java.util.*;

import static org.takeuforward.CommonUtils.printArray;

// https://takeuforward.org/data-structure/two-sum-check-if-a-pair-with-given-sum-exists-in-array/
public class TwoSum {
    public static void main(String args[]) {
        // int []nums = {2, 7,11,15};  int target = 9;
        //int []nums = {1,2,3,4,5};  int target = 5;
        int []nums = {2, -6, 2, 5, 2};  int target = 4;
        printArray(twoSum1(nums, target));
        printArray(twoSum2(nums, target));
        printArray(twoSum3(nums, target));
    }

// Time Complexity: O(N)
// Space Complexity: O(N)
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.get(target-nums[i]) != null)
                return new int[]{i,map.get(target-nums[i])};
            else
                map.put(nums[i], i);
        }

        return new int[]{0,0};
    }

// Time Complexity: O(N LOG N)
// Space Complexity: O(N)
    public static int[] twoSum2(int[] nums, int target) {
        int tempNums[] = tempNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tempNums);

        int i=0, j=nums.length-1, num1=0, num2=0;
        while(i<j) {
            int sum = tempNums[i]+tempNums[j];
            if(sum==target) {
                num1 = tempNums[i];
                num2 = tempNums[j];
            }

            if(sum>target)
                j--;
            else
                i++;
        }

        for(int l=0; l<nums.length; l++) {
            if(nums[l]==num1)
                i = l;
            if(nums[l]==num2)
                j = l;
        }

        return new int[]{i,j};
    }

// Time Complexity: O(N^2)
// Space Complexity: O(1)
    public static int[] twoSum1(int[] nums, int target) {
        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i]+nums[j] == target)
                    return new int []{i,j};
            }
        }
        return new int[]{0,0};
    }
}
