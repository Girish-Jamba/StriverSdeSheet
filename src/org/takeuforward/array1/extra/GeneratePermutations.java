package org.takeuforward.array1.extra;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations/description/
// Solution : https://leetcode.com/problems/permutations/solutions/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning/
// Time Complexity: O(N!). For finding all possible permutations it is taking N!xN. N represents the number of elements present in the input array.
// Space Complexity: O(1)
public class GeneratePermutations {
    public static void main(String args[]) {
        int []nums = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> permutations = generatePermutations(nums);
        System.out.println(permutations);
    }

    private static List<List<Integer>> generatePermutations(int[] nums) {
        List<List<Integer>> permutations = new ArrayList();
        List<Integer> temp = new ArrayList();
        backTrack(nums, permutations, temp);
        return permutations;
    }

    private static void backTrack(int[] nums, List<List<Integer>> permutations, List<Integer> temp) {
        if(temp.size() == nums.length) {
            permutations.add(new ArrayList<>(temp));
        } else {
            for(int i=0; i<nums.length; i++) {
                if(temp.contains(nums[i]))
                    continue;
                temp.add(nums[i]);
                backTrack(nums, permutations, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}
