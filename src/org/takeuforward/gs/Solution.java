package org.takeuforward.gs;

// Goldman R2 : Coderpad round

/* Problem Name is &&& Snowpack &&& PLEASE DO NOT REMOVE THIS LINE. */

/*
** Instructions to candidate.
**  1) Given an array of non-negative integers representing the elevations
**     from the vertical cross section of a range of hills, determine how
**     many units of snow could be captured between the hills.
**
**     See the example array and elevation map below.
**                                 ___
**             ___                |   |        ___
**            |   |        ___    |   |___    |   |
**         ___|   |    ___|   |   |   |   |   |   |
**     ___|___|___|___|___|___|___|___|___|___|___|___
**     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
**                                 ___
**             ___                |   |        ___
**            |   | *   *  _*_  * |   |_*_  * |   |
**         ___|   | *  _*_|   | * |   |   | * |   |
**     ___|___|___|_*_|___|___|_*_|___|___|_*_|___|___
**     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}

  left  0   1   3   3    3   3   3   4   4  4   4   4
  right 4   4   4   4    4   4   4   4   3  3   3   0
        0   0   0   3    2   1   3   0
      [left 1
      mid 1
      right 1

**
**     Solution: In this example 13 units of snow (*) could be captured.
**
**  2) Consider adding some additional tests in doTestsPass().
**  3) Implement computeSnowpack() correctly.
*/

class Solution {
    /*
     **  Find the amount of snow that could be captured.
     */
    public static int computeSnowpack(int[] arr) {
        // Todo: Implement computeSnowpack
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        int max =0;
        for(int i=arr.length-1; i>=0; i--) {
            max = Math.max(max, arr[i]);
            right[i] = max;
        }

        max=0;
        int res = 0;
        for(int i=0; i<arr.length; i++) {
            max = Math.max(max, arr[i]);
            res += Math.min(right[i], max) -arr[i];
        }
        return res;
    }

    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass() {
        boolean result = true;
        result &= computeSnowpack(new int[] {0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0}) == 13;

        result &= computeSnowpack(new int[] {}) == 0;
        result &= computeSnowpack(new int[] {0, 0, 0}) == 0;
        result &= computeSnowpack(new int[] {0, 1, 3, 0, 1, 2, 0, 3, 2, 0, 3, 0}) == 13;
        result &= computeSnowpack(new int[] {0, 1, 4, 0, 1, 2, 0, 4, 2, 0, 3, 0}) == 17;

        result &= computeSnowpack(new int[] {0, 1, 2,4}) == 0;
        result &= computeSnowpack(new int[] {4,3,2}) == 0;
        result &= computeSnowpack(new int[] {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}) == 10;
        result &= computeSnowpack(new int[] {0, 0, 0, 0, 0}) == 0;
        result &= computeSnowpack(new int[] {0, 0, 1, 0, 0}) == 0;
        result &= computeSnowpack(new int[] {1}) == 0;
        result &= computeSnowpack(new int[] {}) == 0;
        return result;
    }

    /*
     **  Execution entry point.
     */
    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }
}