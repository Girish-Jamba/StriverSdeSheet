package org.takeuforward.array1;

import java.util.ArrayList;
import java.util.List;

// https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/

// Time Complexity: O(N!*N). For finding, all possible permutations, it is taking N!xN. N represents the number of elements present in the input array. Also for searching input arrays from all possible permutations will take N!.
// Space Complexity: O(1)
public class NextPermutation {
    public static void main(String args[]) {
        int nums[] = {1,2,3};
        nextPermutation(nums);
    }

    public static void nextPermutation(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> temp = new ArrayList();
        backTrack(nums, permutations, temp);

        nums = new int[]{3, 2, 1};
        int i=0;
        List<Integer> ls = null;
        for(; i<permutations.size(); i++) {
            ls = permutations.get(i);
            if(ls.get(0)==nums[0] && ls.get(1)==nums[1] && ls.get(2)==nums[2])
                break;
        }

        if(i<permutations.size()-1) {
            ls = permutations.get(++i);
        } else if(ls.get(0)==nums[0] && ls.get(1)==nums[1] && ls.get(2)==nums[2]) {
            ls = permutations.get(0);
        }
        System.out.println("Result : " + ls.get(0) + " : " + ls.get(1) + " : " + ls.get(2));
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