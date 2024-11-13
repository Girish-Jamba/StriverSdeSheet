import java.util.PriorityQueue;

import static org.takeuforward.CommonUtils.printArray;

public class Solution {

    public static void main(String args[]) {
        //int input[][] = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        //int res[][] = highFive(input);
        //printArray(res);
        System.out.println(reachingPoints(1,1,3,5));
    }

    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(tx >= sx && ty >= sy){
            if(tx > ty) {
                if(sy == ty) return (tx - sx) % ty == 0;
                tx %= ty;
            }
            else {
                if(sx == tx) return (ty - sy) % tx == 0;
                ty %= tx;
            }
        }
        return false;
    }

    public static int[][] highFive(int[][] items) {
        int size = 0;
        PriorityQueue[] s = new PriorityQueue[101];
        int n = 5;
        for (int[] item : items) {
            int i = item[0], score = item[1];
            if (s[i] == null) {
                ++size;
                s[i] = new PriorityQueue<>(n);
            }
            s[i].offer(score);
            if (s[i].size() > n) {
                s[i].poll();
            }
        }
        int[][] res = new int[size][2];
        int j = 0;
        for (int i = 0; i < 101; ++i) {
            if (s[i] == null) {
                continue;
            }
            int avg = sum(s[i]) / n;
            res[j][0] = i;
            res[j++][1] = avg;
        }
        return res;
    }

    private static int sum(PriorityQueue<Integer> q) {
        System.out.println("Size : " + q.size());
        int s = 0;
        while (!q.isEmpty()) {
            s += q.poll();
        }
        return s;
    }
}