package org.takeuforward.array1;

import java.util.ArrayList;

// https://takeuforward.org/data-structure/program-to-generate-pascals-triangle/
// Time Complexity: O(numRows ^ 2). We are creating a 2D array of size (numRows * numCols) (where 1 <= numCols <= numRows), and we are traversing through each of the cells to update it with its correct value
// Space Complexity: Since we are creating a 2D array, space complexity = O(numRows ^ 2).
public class PascalTriangle {

    public static void main(String args[]) {
        System.out.println(printPascal(5));
    }

    public static ArrayList<ArrayList<Long>> printPascal(int n) {
        ArrayList<ArrayList<Long>> root = new ArrayList<>();
        ArrayList<Long> previous = new ArrayList<>();
        for(int i=0; i<n; i++) {
            ArrayList<Long> current = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i)
                    current.add(1l);
                else
                    current.add(previous.get(j-1) + previous.get(j));
            }
            previous = current;
            root.add(current);
        }
        return root;
    }
}
