package org.takeuforward.array2;

import static org.takeuforward.CommonUtils.printArray;

// https://takeuforward.org/data-structure/merge-two-sorted-arrays-without-extra-space/
// Time Complexity: O(N)
// Space Complexity: O(1)
public class Merge2SortedArrays {
    public static void main(String args[]) {
        //int nums1[] = {1, 4, 8, 10, 0, 0, 0}; int nums2[] = {2, 3, 9};
        //int nums1[] = {1,2,3,0,0,0}; int nums2[] = {2, 5, 6};
        //int nums1[] = {0,0}; int nums2[] = {1,2};
        int nums1[] = {2,0}; int nums2[] = {1};
        merge(nums1, 1, nums2, nums2.length);
        printArray(nums1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;

        for(int i=nums1.length-1;i>=0 && n>=0; i--){
            if(m>=0 && nums1[m] > nums2[n]) {
                nums1[i] = nums1[m];
                nums1[m--] = 0;
            } else if(m<0 || nums1[m] <= nums2[n]) {
                nums1[i] = nums2[n];
                nums2[n--] = 0;
            }
        }
    }
}
