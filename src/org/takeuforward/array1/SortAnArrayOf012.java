package org.takeuforward.array1;

// https://takeuforward.org/data-structure/sort-an-array-of-0s-1s-and-2s/
public class SortAnArray {
    public static void main(String args[]) {
        int []nums = {2,0,2,1,1,0};

        print(nums);
        sortColors(nums);
        print(nums);
    }

    public static void print(int [] nums) {
        for(int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void sortColors(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        int temp;
        while (mid <= hi) {
            System.out.print("lo:"+lo+ ", mid:"+mid+ ", hi:"+hi +" -> ");
            print(nums);
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
}
