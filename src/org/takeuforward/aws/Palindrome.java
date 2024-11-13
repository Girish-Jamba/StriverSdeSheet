package org.takeuforward.aws;

public class Palindrome {
    public static void main(String args[]) {
        Palindrome p = new Palindrome();
        //int result = p.getCount("ABC");
        //int result = p.getCount("AACECAAAA");
        int result = p.getCount("AGHJKUTER");
        System.out.println("Result : " + result);
    }

    public int getCount(String input) {
        int noOfMinChars = 0;
        int start=0;
        int end=input.length()-1;
        while(start<end){
            if(input.charAt(start) != input.charAt(end)) {
                noOfMinChars++;
            } else {
                start++;
            }
            end--;
        }

        return noOfMinChars;
    }
}
