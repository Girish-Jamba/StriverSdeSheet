package org.takeuforward.array4.extra;

// https://www.codingninjas.com/codestudio/library/subsequence-vs-substring
// Formula : (2^N), Where n is the length of the string & all the values are unique
public class PrintSubSequence {
    public static void main(String[] args) {
        String str = "5678";
        printSubsequences1(str, -1, "");
    }

    public static void printSubsequences1(String str, int index, String curr) {
        if(curr!=null & curr.trim().length()>0) {
            System.out.println(curr);
        }

        for(int i=index+1; i<str.length(); i++) {
            curr += str.charAt(i);
            printSubsequences1(str, i, curr);
            curr = curr.substring(0, curr.length()-1);
        }
    }
}
