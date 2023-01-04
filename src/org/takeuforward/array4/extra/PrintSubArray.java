package org.takeuforward.array4.extra;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.takeuforward.CommonUtils.printArray;

// https://www.codingninjas.com/codestudio/library/subsequence-vs-substring
// Formula : (N*(N+1))/2, Where n is the length of the string & all the values are unique (It also included empty sub array also)

public class PrintSubArray {
    public static void main(String[] args) {
        String s = "ninja";
        //String s = "tree";
        Set<String> setString = new LinkedHashSet<>();
        for(int i=0; i<s.length(); i++) {
            for(int j=s.length(); j>i; j--) {
                setString.add(s.substring(i,j));
            }
        }
        System.out.println("Count : " + setString.size());
        System.out.println(setString);

        int arr[] = {1,5,4};
        Set<int[]> setInteger = new LinkedHashSet<>();
        for(int i=0; i<arr.length; i++) {
            for(int j=arr.length; j>i; j--) {
                int a[] = new int[j-i];
                int zero = 0;
                for(int k=i;k<j; k++)
                    a[zero++] = arr[k];
                setInteger.add(a);
            }
        }

        System.out.println("Count : " + setInteger.size());
        for(int temp[] : setInteger) {
            printArray(temp);
        }


    }
}
