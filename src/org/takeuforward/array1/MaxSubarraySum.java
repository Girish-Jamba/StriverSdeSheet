package org.takeuforward.array1;

// https://takeuforward.org/data-structure/kadanes-algorithm-maximum-subarray-sum-in-an-array/
public class MaxSubarraySum {
    public static void main(String args[]) {
        //int arr[] = {1, 2, 7, -4, 3, 2, -10, 9, 1};
        //int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int arr[] = {-7, -8, -16, -4, -8, -5, -7, -11, -10, -12, -4, -6, -4, -16, -10};
        System.out.println("Max Subarray Sum : " + findMaxSubarraySum2(arr));
    }
//  Time Complexity: O(N)
//  Space Complexity: O(1)
    private static long findMaxSubarraySum2(int[] arr) {
        long maxSoFar=Long.MIN_VALUE, maxSumAtI=0;
        for(int i=0;i<arr.length;i++){
            maxSumAtI+=arr[i];
            if(maxSumAtI> maxSoFar) {
                maxSoFar=maxSumAtI;
            }
            if(maxSumAtI<0) {
                maxSumAtI=0;
            }
        }
        return maxSoFar;
    }

//  Time Complexity: O(N^2)
//  Space Complexity: O(1)
    private static long findMaxSubarraySum1(int[] arr) {
        long sum = arr[0];
        for(int i=0; i<arr.length; i++) {
            if(sum<arr[i])
                sum = arr[i];
            int temp = 0;
            for(int j=i; j<arr.length; j++) {
                temp = temp + arr[j];
                sum = Math.max(sum, temp);
            }
        }
        return sum;
    }
}
