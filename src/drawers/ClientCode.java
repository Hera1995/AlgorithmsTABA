package drawers;

import java.util.ArrayList;

public class ClientCode {

    public static void main(String[] args) {
        // Use this code to generate the data in arraylist of drawers
        ArrayList[] drawers = Drawer.generateData();
        // To access the individual drawers use the drawers[index]
        // The following code allows you to get the size of each drawer
        System.out.println("The sizes of drawers:");
        for (int i = 0; i < drawers.length; i++) {
            System.out.println("The size of drawer index " + i + " is: " + drawers[i].size());
        }

        /*
        // To access the elements of a drawer use drawers[0][index]
        for (int i = 0; i < drawers[0].size(); i++) {
            //This prints the individual elements of drawer 0
            System.out.println(drawers[0].get(i));
        }
         */
        /**
         * ************************************************************************************
         */
        //Question2 part A
        //create 10 threads
        Thread[] threads = new Thread[10];

        //create an array of calculators
        CalculateStat[] calculators = new CalculateStat[10];

        for (int i = 0; i < 10; i++) {
            calculators[i] = new CalculateStat(drawers[i]);

            //put each calculator into a thread 
            threads[i] = new Thread(calculators[i]);
            threads[i].start();
        }

        // wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted while waiting: " + e.getMessage());
            }
        }

        // print statistics for drawers
        System.out.println("The sum, average, maximum and minimum of the drawers: ");
        for (int i = 0; i < 10; i++) {
            System.out.println("Drawer index " + i + " Sum: " + calculators[i].getSum()
                    + ", Average: " + calculators[i].getAverage()
                    + ", Maximum: " + calculators[i].getMax()
                    + ", Minimum: " + calculators[i].getMin());
        }

        //Question2 part B
        //data members and initializations
        int grandTotalSum = 0;
        double grandTotalAverage = 0;
        int grandTotalMax = calculators[0].getMax();
        int grandTotalMin = calculators[0].getMin();
        int totalSize = 0;

        //calculations of 10 drawers
        for (int i = 0; i < 10; i++) {
            int drawerSum = calculators[i].getSum();
            int drawerMax = calculators[i].getMax();
            int drawerMin = calculators[i].getMin();
            int drawerSize = calculators[i].getSize();
            
            //calculate total size
            totalSize += drawerSize;
            
            //calculate grand total
            grandTotalSum += drawerSum;
            
            //calculate grand maximum
            if (drawerMax > grandTotalMax) {
                grandTotalMax = drawerMax;
            }
            
            //calculate grand minimum
            if (drawerMin < grandTotalMin) {
                grandTotalMin = drawerMin;
            }
        }
        //calculate grand average
        grandTotalAverage = (double)grandTotalSum / totalSize;

        //print the grand total, average, maximum and minimum of all the drawers
        System.out.println("Grand total: " + grandTotalSum
                + ", Grand average: " + grandTotalAverage
                + ", Grand maximum: " + grandTotalMax
                + ", Grand minimum: " + grandTotalMin);

    }
}
