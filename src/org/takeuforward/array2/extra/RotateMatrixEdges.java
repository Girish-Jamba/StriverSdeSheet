package org.takeuforward.array2.extra;

import java.util.ArrayList;
import java.util.Arrays;
import static org.takeuforward.CommonUtils.print2DList;

// https://www.codingninjas.com/codestudio/problems/981260?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
public class RotateMatrixEdges {
    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();        matrix.add(new ArrayList<Integer>(Arrays.asList(1,2,3,4)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(5,6,7,8)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(9,10,11,12)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(13,14,15,16)));

        print2DList(matrix);
        rotateMatrix(matrix);
        print2DList(matrix);
    }

//  Time Complexity: O(N)
//  Space Complexity: O(1)
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> matrix) {
        int top=0, left=0, bottom= matrix.size()-1, right= matrix.get(0).size()-1;

        while(top< bottom && left < right) // to iterate for all elements until it reaches center
        {
            for(int i = top; i< bottom; i++) // top to bottom
                swap(matrix,i, left,i+1, left);
            for(int i = left; i< right; i++) // left to right
                swap(matrix, bottom,i  , bottom,i+1);
            for(int i = bottom; i>top; i--) // bottom to top
                swap(matrix,i, right,i-1, right);
            for(int i = right; i> left +1; i--) // right to left + 1    to avoid 1st element which was swapped earlier during top - bottom
                swap(matrix,top,i,top,i-1);

            top++;
            left++;
            bottom--;
            right--; // to itarate for internal elements
        }
    }
    static void swap(ArrayList<ArrayList<Integer>> mat, Integer i1, Integer j1 , Integer i2, Integer j2) {
        Integer t = mat.get(i1).get(j1);
        mat.get(i1).set(j1 , mat.get(i2).get(j2) );
        mat.get(i2).set(j2 , t);
    }
}
