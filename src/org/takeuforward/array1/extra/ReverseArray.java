package org.takeuforward.array1.extra;

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

    public static void printArray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
