package hackerrank;

import java.util.ArrayList;

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
