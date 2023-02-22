// BubbleSort.java

import java.util.Random;

public class BubbleSort {

    public static void bubbleSort(int[] array) {
        boolean changed = true;

        while (changed) {
            changed = false;
            for (int i = 0; i <= (array.length - (i+2)); i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    changed = true;
                }
            }
        }
    }

    public static void main(String args[]) {
        long startTime = System.nanoTime();

        int SIZE = Integer.parseInt(args[0]);
        // put in random numbers
        int[] nums = new int[SIZE];
        Random rng = new Random();
        for (int i = 0; i < SIZE; i++) {
            nums[i] = rng.nextInt(100);
        }

        /*
        // print them
        System.out.print("Unsorted numbers: ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print("\n");
         */
        // sort them
        bubbleSort(nums);

        /*
        // print them again
        System.out.println("Sorted numbers: ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print("\n");
        */

        long endTime = System.nanoTime();
        long elapsedMS = (endTime - startTime) / 1000000;
        System.out.println("Elapsed Time = " + elapsedMS + " millisecond.");
    }
}

