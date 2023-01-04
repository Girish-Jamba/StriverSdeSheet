package org.takeuforward.array4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://takeuforward.org/data-structure/4-sum-find-quads-that-add-up-to-a-target-value/
public class FourSumFindAllCombinations {
    public static void main(String[] args) {
        //int nums[] = {1,0,-1,0,-2,2}; int target = 0;
        //int nums[] = {2,2,2,2,2}; int target = 8;
        int nums[] = {1000000000,1000000000,1000000000,1000000000}; int target = -294967296;
        System.out.println(fourSum1(nums, target));
        System.out.println(fourSum2(nums, target));
        System.out.println(fourSum3(nums, target, nums.length));
    }

// Time Complexity: O(N LOG N + N^3) Sorting the array takes N log N and three nested loops will be taking N³.
// Space Complexity: O(1)
    public static String fourSum3(int[] arr, int target, int n) {
        if(arr==null || arr.length==0)
            return "No";

        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                int twoSum = target - arr[i] - arr[j];
                int left = j+1;
                int right = arr.length-1;
                while(left<right) {
                    long res = (long)arr[i] + arr[j] + arr[left] + arr[right];
                    if(res == target) {
                        return "Yes";
                    }
                    else if (arr[left]+arr[right]<twoSum)
                        left++;
                    else
                        right--;
                }
            }
        }
        return "No";
    }

// Time Complexity: O(N LOG N + N^3) Sorting the array takes N log N and three nested loops will be taking N³.
// Space Complexity: O(1)
    public static List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> lsResult = new ArrayList<>();
        if(nums==null || nums.length==0)
            return lsResult;

        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                int twoSum = target - nums[i] - nums[j];
                int left = j+1;
                int right = nums.length-1;
                while(left<right) {
                    long res = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if(res == target) {
                        ArrayList<Integer> ls = new ArrayList(Arrays.asList(nums[i], nums[j], nums[left++], nums[right]));
                        lsResult.add(ls);

                        while(i<j && left<right && nums[left]==ls.get(2))
                            left++;

                        while(i<j && left<right && nums[right]==ls.get(3))
                            right--;
                    }
                    else if (nums[left]+nums[right]<twoSum)
                        left++;
                    else
                        right--;
                }
                while(j+1<nums.length && nums[j]==nums[j+1])
                    j++;
            }
            while(i+1<nums.length && nums[i]==nums[i+1])
                i++;
        }

        return lsResult;
    }

// Time Complexity: O(N^4)
// Space Complexity: O(1)
    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> lsResult = new ArrayList<>();
        if(nums==null || nums.length==0)
            return lsResult;

        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                for(int k=j+1; k<nums.length-i; k++) {
                    for(int l=k+1; l<nums.length; l++) {
                        if(nums[i]+nums[j]+nums[k]+nums[l] == target) {
                            lsResult.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        }
                    }
                }
            }
        }

        return lsResult;
    }
}
