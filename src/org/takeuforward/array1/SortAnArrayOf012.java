package org.takeuforward.array1;

// https://takeuforward.org/data-structure/sort-an-array-of-0s-1s-and-2s/
public class SortAnArrayOf012 {
    public static void main(String args[]) {
        int []nums = {2,0,2,1,1,0};

        print(nums);
        sortArray(nums);
        print(nums);
    }

// Time Complexity: O(N)
// Space Complexity: O(1).
    public static void sortArray(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        int temp;
        while (mid <= hi) {
            //print(nums);
            switch (nums[mid]) {
                case 0: {
                    temp = nums[lo];
                    nums[lo] = nums[mid];
                    nums[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2: {
                    temp = nums[mid];
                    nums[mid] = nums[hi];
                    nums[hi] = temp;
                    hi--;
                    break;
                }
            }
        }
    }


    public static void print(int [] nums) {
        for(int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}