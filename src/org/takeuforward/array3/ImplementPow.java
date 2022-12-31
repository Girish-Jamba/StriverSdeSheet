package org.takeuforward.array3;

// https://takeuforward.org/data-structure/implement-powxn-x-raised-to-the-power-n/
public class ImplementPow {
    public static void main(String[] args) {
        double d = 2.1d;
        int n = -2;
        System.out.println(myPow1(d,n));
        System.out.println(myPow2(d,n));
        System.out.println(myPow3(d,n));
    }

// Time Complexity: O(N)
//Space Complexity: O(1)
    public static double myPow3(double x, int n) {
        double ans = 1.0;
        long nn = n;

        if (nn < 0)
            nn = -1 * nn;

        while (nn > 0) {
            if (nn % 2 == 1) {
                ans = ans * x;
                nn--;
            } else {
                x = x * x;
                nn = nn / 2;
            }
        }
        if (n < 0)
            ans = (double)(1.0) / (double)(ans);
        return ans;
    }

// Time Complexity: O(N)
//Space Complexity: O(1)
    public static double myPow2(double x, int n) {
        double res = 1;
        /*for(int i=1; i<n; i++) {
            res *= x;
        }*/

        for(int i = 0; i<n; i++){
            res = res * x;
        }
        return res;
    }

    public static double myPow1(double x, int n) {
        return Math.pow(x,n);
    }
}
