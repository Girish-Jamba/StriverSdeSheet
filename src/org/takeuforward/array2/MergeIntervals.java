package org.takeuforward.array2;

import java.util.*;

import static org.takeuforward.CommonUtils.printArray;

// https://takeuforward.org/data-structure/merge-overlapping-sub-intervals/
public class MergeIntervals {
    public static void main(String[] args) {
        //int [][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        //int [][] intervals = {{1,4},{4,5}};
        //int [][] intervals = {{1,4},{0,4}};
        //int [][] intervals = {{1,4},{0,1}};
        //int [][] intervals = {{1,4},{0,0}};
        int [][] intervals = {{1,4},{0,2},{3,5}};
        intervals = merge(intervals);
        printArray(intervals);
    }

// Time Complexity: O(NlogN) + O(N) + O(N). O(N) for array to list conversion, O(NlogN) for sorting and O(N) for list to array.
// Space Complexity: O(N) to return the answer of the merged intervals.
    public static int[][] merge(int[][] intervals) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<intervals.length; i++) {
            list.add(Arrays.asList(new Integer[]{intervals[i][0],intervals[i][1]}));
        }
        Collections.sort(list, (a,b) -> a.get(0)-b.get(0));

        List<Integer> current = null;
        List<Integer> next = null;
        for(int i=0; i<list.size()-1;) {
            current = list.get(i);
            next = list.get(i+1);
            if(current.get(1)>=next.get(0) || current.get(1)==next.get(1)) {
                list.set(i, Arrays.asList(new Integer[]{Math.min(current.get(0), next.get(0)), Math.max(current.get(1), next.get(1))}));
                list.remove(next);
            } else {
                i++;
            }
        }

        List<Integer> temp = null;
        int result[][] = new int[list.size()][2];
        for(int i=0; i<list.size(); i++) {
            temp = list.get(i);
            result[i][0] = temp.get(0);
            result[i][1] = temp.get(1);
        }
        return result;
    }
}
