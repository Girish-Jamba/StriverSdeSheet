package org.takeuforward.array4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// https://takeuforward.org/data-structure/length-of-longest-substring-without-any-repeating-character/
public class LongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring1(s));
        System.out.println(lengthOfLongestSubstring2(s));
        System.out.println(lengthOfLongestSubstring3(s));
    }

//  Time Complexity: O(N)
//  Space Complexity: O(N) as hashmap will be used to store the unique characters
    public static int lengthOfLongestSubstring3(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int len = 0;

        while(right < str.length()) {
            if (map.containsKey(str.charAt(right)))
                left = Math.max(map.get(str.charAt(right))+1, left);
            map.put(str.charAt(right), right);
            len = Math.max(len, right-left+1);
            right++;
        }
        return len;
    }

//  Time Complexity: O(N LOG N) as there is nesting of loop
//  Space Complexity: O(N) as hashset will be used to store the unique characters
    public static int lengthOfLongestSubstring2(String str) {
        if(str.length()==0)
            return 0;
        int maxAns = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        int left = 0;
        for(int right=0; right<str.length(); right++) { // outer loop for traversing the string
            if(set.contains(str.charAt(right))) {
                while(left < right && set.contains(str.charAt(right))) {
                    set.remove(str.charAt(right));
                    left++;
                }
            }
            set.add(str.charAt(right));
            maxAns = Math.max(maxAns, right-left+1);
        }
        return maxAns;
    }

//  Time Complexity: O(N^2) as there is nesting of loop
//  Space Complexity: O(N) as hashset will be used to store the unique characters
    public static int lengthOfLongestSubstring1(String str) {
        if(str.length()==0)
            return 0;
        int maxAns = Integer.MIN_VALUE;
        for(int i=0; i<str.length(); i++) { // outer loop for traversing the string
            Set<Character> set = new HashSet<>();
            for (int j=i; j<str.length(); j++) { // nested loop for getting different string starting with str[i]
                if(set.contains(str.charAt(j))) {
                    maxAns = Math.max(maxAns, set.size());
                    break;
                }
                set.add(str.charAt(j));
            }
        }
        return maxAns;
    }
}
