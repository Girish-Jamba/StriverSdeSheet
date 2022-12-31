package org.takeuforward.array1;


import static org.takeuforward.CommonUtils.printArray;

// https://takeuforward.org/data-structure/set-matrix-zero/
public class SetMatrixZero {
    public static void main(String args[]) {
        //int arr[][] = {{7, 19, 3},{4, 21 , 0}};
        //int arr[][] = {{1},{0}};
        //int arr[][] = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int arr[][] = {{-4,-2147483648,6,-7,0},{-8,6,-8,-6,0},{2147483647,2,-9,-6,-10}};


        printArray(arr);
        setZeros(arr);
        printArray(arr);
    }

// Time Complexity: O(2*(N*M)), as we are traversing two times in a matrix,
// Space Complexity: O(1).
    public static void setZeros(int matrix[][]) {
        int col0=1;

        for(int i=0; i<matrix.length; i++) {
            if(matrix[i][0] == 0)
                col0=0;
            for(int j=1; j<matrix[i].length; j++) {
                if(matrix[i][j]==0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for(int i=matrix.length-1; i>=0; i--) {
            for(int j=matrix[i].length-1; j>=1; j--) {
                if(matrix[i][0] == 0 || matrix[0][j] ==0)
                    matrix[i][j] = 0;
            }
            if(col0==0)
                matrix[i][0]=0;
        }
    }
}
