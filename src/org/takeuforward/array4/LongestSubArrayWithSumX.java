package org.takeuforward.array4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// https://takeuforward.org/data-structure/length-of-the-longest-subarray-with-zero-sum/
public class LongestSubArrayWithSumX {
    public static void main(String[] args) {
        //ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,3,-1,4,-4));
        //ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,0,-5));
        //ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,3,-5,6,-2));
        //ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5,5,-10,1,1,1,-3));
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(-1,1,-1,1));
        System.out.println(longestSubsetWithSumX1(arr, 0));
        System.out.println(longestSubsetWithSumX2(arr, 0));
    }

// Time Complexity: O(N)
// Space Complexity: O(N)
    public static int longestSubsetWithSumX2(ArrayList<Integer> arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int sum = 0;

        for(int i=0; i<arr.size(); i++) {
            sum += arr.get(i);

            if (sum == n) {
                maxLength = i + 1;
            } else {
                if (map.get(sum) != null) {
                    maxLength = Math.max(maxLength, i-map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }

        return maxLength;
    }

// Time Complexity: O(N^2)
// Space Complexity: O(1)
    public static int longestSubsetWithSumX1(ArrayList<Integer> arr, int n) {
        int maxLength=0;
        for(int i=0; i<arr.size(); i++) {
            int sum = 0;
            for(int j=i; j<arr.size(); j++) {
                sum+=arr.get(j);
                if(sum==n) {
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
        }

        return maxLength;
    }
}