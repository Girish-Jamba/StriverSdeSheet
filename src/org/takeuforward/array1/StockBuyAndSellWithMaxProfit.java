package org.takeuforward.array1;

import java.util.ArrayList;
import java.util.Arrays;

// https://takeuforward.org/data-structure/stock-buy-and-sell/
public class StockBuyAndSellWithMaxProfit {

    public static void main(String args[]) {
        ArrayList<Integer> lsPrices = new ArrayList<Integer>(Arrays.asList(7,1,5,3,6,4));
        System.out.println("Maximum Profit is : " + maximumProfit2(lsPrices));
    }

//    Time complexity: O(n)
//    Space Complexity: O(1)
    public static int maximumProfit2(ArrayList<Integer> prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i<prices.size(); i++) {
            min = Math.min(min, prices.get(i));
            maxProfit = Math.max(maxProfit, prices.get(i)-min);
        }
        return maxProfit;
    }

//    Time complexity: O(n ^ 2)
//    Space Complexity: O(1)
    public static int maximumProfit1(ArrayList<Integer> prices){
        int maxProfit = 0;
        for(int i=0; i<prices.size(); i++) {
            for(int j=i+1; j<prices.size(); j++) {
                if(prices.get(j) > prices.get(i)) {
                    maxProfit = Math.max(prices.get(j) - prices.get(i), maxProfit);
                }
            }
        }
        return maxProfit;
    }
}
