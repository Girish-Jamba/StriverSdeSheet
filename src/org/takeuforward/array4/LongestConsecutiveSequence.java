package org.takeuforward.array4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://takeuforward.org/data-structure/longest-consecutive-sequence-in-an-array/
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        //int []nums = {100,4,200,1,3,2};
        //int nums[] = {3, 8, 5, 7, 6};
        //int nums[] = {};
        //int nums[] = {1};
        //int []nums = {100,4,200,1,300,7,8,9};
        int []nums = {0,2,0,1};
        System.out.println(longestConsecutive1(nums));
        System.out.println(longestConsecutive2(nums));
    }

// Time Complexity: O(N)
// Space Complexity: O(N)
    public static int longestConsecutive2(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for(int num : nums)
            hashSet.add(num);

        int maxCount=0;

        for(int num: nums) {
            if(!hashSet.contains(num-1)) {
                int count = 1;
                int tempNum = num;
                while(hashSet.contains(tempNum+1)) {
                    count++;
                    tempNum++;
                }

                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;
    }

// Time Complexity: O(N LOG N)
// Space Complexity: O(1)
    public static int longestConsecutive1(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        int count=1;
        int maxCount=count;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i]+1 == nums[i+1])
                ++count;
            else if (nums[i] != nums[i+1])
                count = 1;

            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }
}
