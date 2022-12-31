package org.takeuforward.array1.extra;

import static org.takeuforward.CommonUtils.printArray;

public class ReverseArray {
    public static void main(String args[]) {
        int arr[] = {1,2,3,4,5};
        printArray(arr);
        reverseArray(arr);
        printArray(arr);

    }
    public static void reverseArray(int arr[]) {
        int j= arr.length-1;
        for(int i=0; i<arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j--] = temp;
        }
    }
}
