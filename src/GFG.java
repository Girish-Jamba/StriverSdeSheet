// Java program to implement
// the above approach
//https://www.geeksforgeeks.org/longest-common-subsequence-of-two-arrays-out-of-which-one-array-consists-of-distinct-elements-only/
import java.util.*;
class GFG
{

    // Function to find the Longest Common
// Subsequence between the two arrays
    static int LCS(int[] firstArr,int[] secondArr)
    {
        // Maps elements of firstArr[]
        // to their respective indices
        HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();

        // Traverse the array firstArr[]
        for (int i = 0; i < firstArr.length; i++)
        {
            mp.put(firstArr[i], i + 1);
        }

        // Stores the indices of common elements
        // between firstArr[] and secondArr[]
        Vector<Integer> tempArr = new Vector<>();

        // Traverse the array secondArr[]
        for (int i = 0; i < secondArr.length; i++)
        {

            // If current element exists in the Map
            if (mp.containsKey(secondArr[i]))
            {
                tempArr.add(mp.get(secondArr[i]));
            }
        }

        // Stores lIS from tempArr[]
        Vector<Integer> tail = new Vector<>();
        tail.add(tempArr.get(0));

        for (int i = 1; i < tempArr.size(); i++)
        {
            if (tempArr.get(i) > tail.lastElement())
                tail.add(tempArr.get(i));
            else if (tempArr.get(i) < tail.get(0))
                tail.add(0, tempArr.get(i));
        }
        return (int)tail.size();
    }

    // Driver Code
    public static void main(String[] args)
    {
        int[] firstArr = { 3,5,1,8};
        int[] secondArr = { 3,3,5,3,8};
        System.out.print(LCS(firstArr, secondArr));
    }
}

// This code is contributed by gauravrajput1
