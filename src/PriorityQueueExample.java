import java.util.HashMap;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main(String args[]) {
        int input[][] = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};

        PriorityQueue<Integer> p[] = new PriorityQueue[2];
        p[0] = new PriorityQueue<>();
        p[1] = new PriorityQueue<>();
        for(int row[] : input) {
            p[row[0]-1].add(row[1]);
            if(p[row[0]-1].size()>5)
                p[row[0]-1].poll();
        }

        System.out.println(p[0].stream().reduce(0, Integer::sum)/5);
        System.out.println(p[1].stream().reduce(0, Integer::sum)/5);
    }
}
