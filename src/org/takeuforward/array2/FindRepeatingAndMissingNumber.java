package org.takeuforward.array2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

// https://takeuforward.org/data-structure/find-the-repeating-and-missing-numbers/
public class FindRepeatingAndMissingNumber {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3,1,2,5,3));
        int []result = missingAndRepeating2(arr, arr.size());
        System.out.println(result[0] + " : " + result[1]);
    }

// Time Complexity: O(N)+O(N).
// Space Complexity: O(N).
    public static int[] missingAndRepeating2(ArrayList<Integer> arr, int n) {
        int array[] = new int[n];
        for(int i=0; i<arr.size(); i++) {
            array[arr.get(i)-1]= array[arr.get(i)-1]+1;
        }
        int result[] = new int[2];
        for(int i=0; i<arr.size(); i++) {
            if(array[i]==0)
                result[0] = i+1;
            if(array[i]==2)
                result[1] = i+1;
        }
        return result;
    }

// Time Complexity: O(N Log N) + O(N)+O(N).
// Space Complexity: O(N).
    public static int[] missingAndRepeating1(ArrayList<Integer> arr, int n) {
        HashSet<Integer> set = new HashSet<>();
        int duplicateNumber=0;
        int sum = 0;
        for(int i=0; i<arr.size(); i++) {
            if(set.contains(arr.get(i)))
                duplicateNumber = arr.get(i);
            else
                set.add(arr.get(i));
            sum += i+1;
        }

        int arrSum=0;
        for(int i=0; i<arr.size(); i++) {
            arrSum+=arr.get(i);
        }
        return new int[]{sum-(arrSum-duplicateNumber), duplicateNumber};
    }
}
