package org.takeuforward.array1.extra;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/permutations-ii/
// Solution : https://leetcode.com/problems/permutations/solutions/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning/
// Time Complexity: O(N!). For finding all possible permutations it is taking N!xN. N represents the number of elements present in the input array.
// Space Complexity: O(1)
public class GeneratePermutationsWithDuplicate {
    public static void main(String args[]) {
        int []nums = {1,1,3};
        List<List<Integer>> permutations = generatePermutations(nums);
        System.out.println(permutations);
    }

    private static List<List<Integer>> generatePermutations(int[] nums) {
        List<List<Integer>> permutations = new ArrayList();
        List<Integer> temp = new ArrayList();
        backTrack(nums, permutations, temp, new boolean[nums.length]);
        return permutations;
    }

    static HashSet<List<Integer>> hs = new HashSet<>();
    private static void backTrack(int[] nums, List<List<Integer>> permutations, List<Integer> temp, boolean used[]) {
        if(temp.size() == nums.length) {
            permutations.add(new ArrayList<>(temp));
        } else {
            for(int i=0; i<nums.length; i++) {
                if(used[i])
                    continue;

                used[i] = true;
                temp.add(nums[i]);
                backTrack(nums, permutations, temp, used);
                used[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}
