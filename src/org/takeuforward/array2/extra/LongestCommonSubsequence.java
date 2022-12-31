package org.takeuforward.array2.extra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static org.takeuforward.CommonUtils.printList;

// https://www.geeksforgeeks.org/longest-common-subsequence-of-two-arrays-out-of-which-one-array-consists-of-distinct-elements-only/
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        //int arr1[] = {3,5,1,8}; int arr2[] = {3,3,5,3,8};
        //int arr1[] = {1,3,2,4,5}; int arr2[] = {2,3,4,5,2,8};
        //int arr1[] = {8,3,4,6,2}; int arr2[] = {7,3,4,7,2};
        //int arr1[] = {1,2,3,4,5,6,7,8,9}; int arr2[] = {0,0,3,2,1,5,8,8,8,8};
        //int arr1[] = {1}; int arr2[] = {2};
        int arr1[] = {1,2,3,4,5}; int arr2[] = {1,2,2,6,7,2,3,4};
        System.out.println("Result 1 : " + commonSequence1(arr1, arr2));
        System.out.println("Result 2 : " + commonSequence2(arr1, arr2));
        System.out.println("Result 3 : " + commonSequence3(arr1, arr2));
        System.out.println("Result 4 : " + commonSequence4(arr1, arr2));
    }

// Time Complexity: O(N LogN)
// Space Complexity: O(N).
    public static int commonSequence4(int arr1[], int arr2[])  {
        // Maintain map for item & its index from arr1
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr1.length; i++) {
            map.put(arr1[i], i);
        }

        // Maintain list containing index from arr1 if the item from arr2 exist
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<arr2.length; i++) {
            if(map.containsKey(arr2[i]))
                list.add(map.get(arr2[i]));
        }

        if(list.size()<1)
            return 0;

        int maxCount=1;
        int maxCountAtI=1;
        for(int i=1; i<list.size(); i++) {
            if(list.get(i)>list.get(i-1)) {
                maxCountAtI++;
            } else {
                maxCountAtI=1;
            }

            if(maxCountAtI>maxCount)
                maxCount = maxCountAtI;
        }

        System.out.println("Map : " + map);
        System.out.println("list : " + list);
        return maxCount;
    }

// Time Complexity: O(N LOGN)
// Space Complexity: O(N).
    public static int commonSequence3(int arr1[], int arr2[])  {
        // Maintain map for item & its index from arr1
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr1.length; i++) {
            map.put(arr1[i], i);
        }

        // Maintain list containing index from arr1 if the item from arr2 exist
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr2.length; i++) {
            if(map.containsKey(arr2[i]))
                set.add(map.get(arr2[i]));
        }
        return set.size();
    }

// Time Complexity: O(N LOGN)
// Space Complexity: O(N).
    public static int commonSequence2(int arr1[], int arr2[])  {
        // Maintain map for item & its index from arr1
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr1.length; i++) {
            map.put(arr1[i], i);
        }

        // Maintain list containing index from arr1 if the item from arr2 exist
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<arr2.length; i++) {
            if(map.containsKey(arr2[i]))
                list.add(map.get(arr2[i]));
        }

        if(list.size()<1)
            return 0;
        ArrayList<Integer> result = new ArrayList<>();
        int lastIndex = list.get(0);
        result.add(lastIndex);
        for(int i=1; i<list.size(); i++) {
            if(list.get(i) > lastIndex){
                result.add(list.get(i));
                lastIndex = list.get(i);
            }
            else if(list.get(i) < list.get(0)){
                result.add(0, list.get(i));
                lastIndex = list.get(i);
            }
        }
        System.out.println("Map : " + map);
        System.out.println("list : " + list);
        System.out.println("Tail : " + result);

        return result.size();
    }

// Time Complexity: O(N^2)
// Space Complexity: O(N).
    public static int commonSequence1(int arr1[], int arr2[])  {
        int max=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr1.length; i++) {
            map.put(arr1[i], i);
        }

        for(int i=0; i<arr2.length; i++) {
            int lastMax = 0;
            int lastIndex = -1;
            for(int j=i; j<arr2.length; j++) {
                int counter = map.getOrDefault(arr2[j], -1);
                if(counter>-1 && counter>lastIndex) {
                    System.out.print(arr2[j] + " ");
                    lastIndex = counter;
                    lastMax++;
                }
            }
            System.out.println(lastMax);
            if(lastMax>max) {
                max = lastMax;
            }
        }
        return max;
    }
}
