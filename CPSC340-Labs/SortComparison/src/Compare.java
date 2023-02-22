public class Compare {
    public static void main (String[] args) {
        long startTime = System.nanoTime();




        long endTime = System.nanoTime();
        long elapsedMS = (endTime - startTime) / 1000000;
        System.out.println("Elapsed Time = " + elapsedMS + " millisecond.");
    }
}
