package org.takeuforward.array1;

import java.util.ArrayList;
import java.util.List;

// https://takeuforward.org/data-structure/kadanes-algorithm-maximum-subarray-sum-in-an-array/
public class MaxSubarray {
    public static void main(String args[]) {
        //int arr[] = {1, 2, 7, -4, 3, 2, -10, 9, 1};
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //int arr[] = {-7, -8, -16, -4, -8, -5, -7, -11, -10, -12, -4, -6, -4, -16, -10};
        System.out.println("Max Sub-array : " + findMaxSubarray2(arr));
    }

//  Time Complexity: O(N)
//  Space Complexity: O(1)
    private static List<Integer> findMaxSubarray2(int[] arr) {
        List<Integer> subArrayIndex = new ArrayList<>();
        long maxSoFar=Long.MIN_VALUE, maxSumAtI=0;
        int startIndex=0;
        for(int i=0;i<arr.length;i++){
            maxSumAtI+=arr[i];
            if(maxSumAtI> maxSoFar) {
                maxSoFar=maxSumAtI;
                subArrayIndex.clear();
                subArrayIndex.add(startIndex);
                subArrayIndex.add(i);
            }
            if(maxSumAtI<0) {
                maxSumAtI=0;
                startIndex=i+1;
            }
        }
        return subArrayIndex;
    }

//  Time Complexity: O(N^2)
//  Space Complexity: O(1)
    private static List<Integer> findMaxSubarray1(int[] arr) {
        List<Integer> subArrayIndex = new ArrayList<>();
        long sum = arr[0];
        for(int i=0; i<arr.length; i++) {
            if(sum<arr[i])
                sum = arr[i];
            int temp = 0;
            for(int j=i; j<arr.length; j++) {
                temp = temp + arr[j];
                if (temp > sum){
                    sum = temp;
                    subArrayIndex.clear();
                    subArrayIndex.add(i);
                    subArrayIndex.add(j);
                }
            }
        }
        return subArrayIndex;
    }
}
