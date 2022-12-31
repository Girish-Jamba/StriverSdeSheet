package org.takeuforward.array2;

import static org.takeuforward.CommonUtils.printArray;

// https://takeuforward.org/data-structure/rotate-image-by-90-degree/
public class RotateMatrixBy90Degree {
    public static void main(String args[]) {
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        printArray(matrix);
        //rotate1(matrix);
        rotate2(matrix);
    }

//  Time Complexity: O(N^2) One O(N*N) for transposing the matrix and O(N*N) for reversing the matrix.
//  Space Complexity: O(1)
    public static void rotate2(int[][] matrix) {
        // Transpose matrix
        for (int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length && j<i; j++) {
                if(i>j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        // Reverse matrix
        for (int i=0; i<matrix.length; i++) {
            int k = matrix[i].length-1;
            for(int j=0; j<matrix[i].length/2; j++) {
                int temp = matrix[i][k-j];
                matrix[i][k-j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        printArray(matrix);
    }

//  Time Complexity: O(N^2). O(N*N) to linearly iterate and put it into some other matrix.
//  Space Complexity: O(N^2).
    public static void rotate1(int[][] matrix) {
        int n = matrix.length-1;
        int newMatrix[][] = new int[matrix[0].length][matrix.length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++) {
                newMatrix[j][n-i] = matrix[i][j];
            }
        }
        printArray(newMatrix);
    }
}
