package org.takeuforward.array2;

// https://takeuforward.org/data-structure/count-inversions-in-an-array/
public class CountInversions {
    static long inversionCount=0;
    public static void main(String[] args) {
        long[] arr = {5,3,2,1,4};
        //long[] arr = {38,27,43,3,9,82,10};
        long inversionCount = getInversions1(arr, arr.length);
        System.out.println(inversionCount);
        inversionCount = getInversions2(arr, arr.length);
        System.out.println(inversionCount);
    }

// Time Complexity: O(N LOG N)
// Space Complexity: O(N).
    private static long getInversions2(long[] arr, int n) {
        return sort(arr, 0, arr.length-1);
    }

    private static long sort(long[] arr, int left, int right) {
        long inversionCount = 0;
        if(left<right) {
            int mid = left + (right-left)/2;
            inversionCount+=sort(arr, left, mid);
            inversionCount+=sort(arr, mid+1, right);
            inversionCount+=merge(arr, left, mid, right);
        }
        return inversionCount;
    }

    private static long merge(long[] arr, int left, int mid, int right) {
        int n1 = mid-left+1;
        int n2 = right-mid;
        long count = 0;

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
                count+=leftArr.length-i;
            }
        }

        while(i<n1) {
            arr[k++] = leftArr[i++];
        }
        while(j<n2) {
            arr[k++] = rightArr[j++];
        }
        return count;
    }


// Time Complexity: O(N^2)
// Space Complexity: O(N).
    public static long getInversions1(long[] arr, int n) {
        long inversion=0;
        for(int i=0; i<arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i]>arr[j])
                    inversion++;
            }
        }
        return inversion;
    }
}