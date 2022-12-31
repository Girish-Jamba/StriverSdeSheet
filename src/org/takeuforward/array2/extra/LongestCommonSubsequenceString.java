package org.takeuforward.array2.extra;

import java.util.ArrayList;
import java.util.HashMap;

import static org.takeuforward.CommonUtils.printArray;

// Problem : https://leetcode.com/problems/longest-common-subsequence/
// Solution : https://leetcode.com/problems/longest-common-subsequence/solutions/348965/java-m-n-time-o-n-space/
/*
* Logic: https://www.programiz.com/dsa/longest-common-subsequence#:~:text=The%20longest%20common%20subsequence%20(LCS,positions%20within%20the%20original%20sequences.
* if its a match then take diagonal value +1
* if its not match then max (previous + above)
* */
public class LongestCommonSubsequenceString {
    public static void main(String[] args) {
        String s1 = "abcde"; String s2 = "ace";
        //String s1 = "abc"; String s2 = "abc";
        //String s1 = "abcba"; String s2 = "abcbcba";
        System.out.print("S1 : " + s1 + "\nS2 : " + s2 + "\nLCS: ");
        System.out.println("Result 1 : " + longestCommonSubsequence1(s1, s2));
        System.out.println("Result 2 : " + longestCommonSubsequence2(s1, s2));
    }

// Time Complexity: O(M *N)
// Space Complexity: O(N)
    public static int longestCommonSubsequence2(String s1, String s2) {
        if(s1.length()==0||s2.length()==0)
            return 0;
        int m=s1.length(),n=s2.length();
        int[][] dp=new int[2][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i%2][j]=dp[(i-1)%2][j-1]+1;
                else
                    dp[i%2][j]=Math.max(dp[i%2][j-1],dp[(i-1)%2][j]);
//                printArray(dp);
            }
        }

        return dp[m%2][n];
    }

// Time Complexity: O(M *N)
// Space Complexity: O(N)
    public static int longestCommonSubsequence1(String s1, String s2) {
        int [][]arr = new int[s1.length()+1][s2.length()+1];
        for(int i=1; i<=s1.length(); i++) {
            for(int j=1; j<=s2.length(); j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    arr[i][j] = arr[i-1][j-1]+1;
                } else {
                    arr[i][j] = Math.max(arr[i][j-1], arr[i-1][j]);
                }
            }
        }

        int index = arr[s1.length()][s2.length()];
        int temp = index;

        char[] lcs = new char[index];

        int i = s1.length(), j = s2.length();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs[index - 1] = s1.charAt(i - 1);

                i--;
                j--;
                index--;
            }

            else if (arr[i - 1][j] > arr[i][j - 1])
                i--;
            else
                j--;
        }

        // Printing the sub sequences
        for (int k = 0; k < temp; k++)
            System.out.print(lcs[k]);
        System.out.println("");

        return arr[s1.length()][s2.length()];
    }
}