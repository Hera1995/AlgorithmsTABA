package drawers;

import java.util.ArrayList;

class CalculateStat extends Thread {

    //Question2 part A
    //data members
    private ArrayList<Integer> drawer;
    private int sum;
    private int max;
    private int min;
    private double average;
    private int size;

    //constructors
    public CalculateStat(ArrayList<Integer> drawer, int sum, int totalCount, int max, int min, double average) {
        this.drawer = drawer;
        this.sum = sum;
        this.max = drawer.get(0);//initialize the first data as max
        this.min = drawer.get(0);//initialize the first data as min
        this.average = average;
        this.size = size;
    }

    public CalculateStat(ArrayList<Integer> drawer) {
        this.drawer = drawer;
    }

    public CalculateStat() {
    }

    //setters and getters
    public void setDrawer(ArrayList<Integer> drawer) {
        this.drawer = drawer;
    }

    public int getSum() {
        return sum;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public double getAverage() {
        return average;
    }

    public int getSize() {
        return size;
    }

    
    // calculate statistics
    public void calculate() {
        sum = 0;

        for (int num : drawer) {
            sum += num;//sum
            if (num > max) {
                max = num;//max
            }
            if (num < min) {
                min = num;//min
            }
        } // for loop
        
        size = drawer.size();
        average = (double) sum / size;//average
    } // calculate() method

    @Override
    public void run() {
        calculate();
    }


}
