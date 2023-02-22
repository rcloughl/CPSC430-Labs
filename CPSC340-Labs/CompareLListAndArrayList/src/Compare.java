import java.util.ArrayList;
import java.util.LinkedList;

public class Compare {
    public static void main (String[] args) {
        long startTime = System.nanoTime();

    /*    ArrayList<String> list = new ArrayList();
        for (int i=0; i<500000;i++){
            list.add(0,"5");
        }
     */

        LinkedList llist = new LinkedList();
        for (int i = 0; i < 500000; i++) {
            llist.add(0,"5");
        }

            long endTime = System.nanoTime();
            long elapsedMS = (endTime - startTime) / 1000000;
            System.out.println("Elapsed Time = " + elapsedMS + " millisecond.");
    }
}