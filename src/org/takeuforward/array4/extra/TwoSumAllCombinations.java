package org.takeuforward.array4.extra;

import java.util.*;

import static org.takeuforward.CommonUtils.printArray;

// Problem : https://www.codingninjas.com/codestudio/problems/pair-sum_697295?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
public class TwoSumAllCombinations {
    public static void main(String args[]) {
        // int []nums = {2, 7,11,15};  int target = 9;
        // int []nums = {1,2,3,4,5};  int target = 5;
        // int []nums = {2,-3,3,3,-2};  int target = 0;
        int []nums = {2, -6, 2, 5, 2};  int target = 4;
        //printArray(twoSum1(nums, target));
        //printArray(twoSum2(nums, target));
        //printArray(twoSum3(nums, target));

        System.out.println("All combinations : ");
        List<int[]> res = twoSum1(nums, target);
        for(int i=0; i<res.size(); i++)
            printArray(res.get(i));

        System.out.println();
        res = twoSum2(nums, target);
        for(int i=0; i<res.size(); i++)
            printArray(res.get(i));
    }

// Time Complexity: O(N LOG N)
// Space Complexity: O(N)
    public static List<int[]> twoSum2(int[] nums, int target) {
        List<int[]> ls = new ArrayList<>();
        int tempNums[] = tempNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tempNums);

        int i=0, j=nums.length-1, num1=0, num2=0;
        while(i<j) {
            int sum = tempNums[i]+tempNums[j];
            if(sum==target) {
                int lower = Math.min(tempNums[i],tempNums[j]);
                int upper = Math.max(tempNums[i],tempNums[j]);
                ls.add(new int[]{lower, upper});
            }

            if(sum<target)
                i++;
            else
                j--;
        }

        ls.sort((a,b) -> {
            return a[0]-b[0];
        });
        return ls;
    }

// Time Complexity: O(N^2)
// Space Complexity: O(1)
    public static List<int[]> twoSum1(int[] nums, int target) {
        List<int[]> ls = new ArrayList<>();
        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i]+nums[j] == target) {
                    int lower = Math.min(nums[i],target-nums[i]);
                    int upper = Math.max(nums[i],target-nums[i]);
                    ls.add(new int[]{lower, upper});
                }
            }
        }
        ls.sort((a,b) -> {
            return a[0]-b[0];
        });
        return ls;
    }
}
