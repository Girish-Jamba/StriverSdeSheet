package org.takeuforward.array2.extra;

import static org.takeuforward.CommonUtils.printArray;

public class MergeSort {
    public static void main(String[] args) {
        long[] arr = {5,3,2,1,4};
        //long[] arr = {38,27,43,3,9,82,10};
        printArray(arr);
        sort(arr, 0, arr.length-1);
        printArray(arr);
    }

    private static void sort(long[] arr, int left, int right) {
        if(left<right) {
            int mid = left + (right-left)/2;
            sort(arr, left, mid);
            sort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(long[] arr, int left, int mid, int right) {
        int n1 = mid-left+1;
        int n2 = right-mid;

        long []leftArr = new long[n1];
        long []rightArr = new long[n2];

        for(int i=0; i<n1; i++) {
            leftArr[i] = arr[left+i];
        }

        for(int i=0; i<n2; i++) {
            rightArr[i] = arr[mid+1+i];
        }

        int i=0,j=0,k=left;
        while(i<n1 && j<n2) {
            if(leftArr[i]<=rightArr[j])
                arr[k++] = leftArr[i++];
            else {
                arr[k++] = rightArr[j++];
            }
        }

        while(i<n1)
            arr[k++] = leftArr[i++];
        while(j<n2)
            arr[k++] = rightArr[j++];
    }
}
