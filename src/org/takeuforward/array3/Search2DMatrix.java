package org.takeuforward.array3;

public class Search2DMatrix {
    public static void main(String args[]) {
        int [][]matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        boolean result = searchMatrix2(matrix, target);
        System.out.println(result);
    }

//  Time Complexity: O(LOG(M*N))
//  Space Complexity: O(1)
    public static boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix.length==0)
            return false;

        int low = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int high = (n * m ) -1;
        while (low<=high) {
            int mid = low+(high-low)/2;
            if(matrix[mid/m][mid%m]==target)
                return true;
            else if (matrix[mid/m][mid%m] < target)
                low = mid+1;
            else
                high = mid-1;
        }
        return false;
    }

// Time Complexity: O(N^2)
// Space Complexity: O(1).
    public static boolean searchMatrix1(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j]==target)
                    return true;
            }
        }
        return false;
    }
}
