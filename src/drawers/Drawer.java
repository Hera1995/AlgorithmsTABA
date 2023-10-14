package drawers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Drawer {
    static ArrayList<Integer>[] drawers =new ArrayList[10];;
    public static ArrayList[] generateData() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            // Generates 10000 random numbers between -10,000 and 10,000
            int[] numbers = random.ints(10000, -10000, 10000).toArray();
            drawers[i] = new ArrayList<Integer>();
            for (int j = 0; j < numbers.length; j++) {
                drawers[i].add(numbers[j]);
            }
        }
        return drawers;
    }
    
    
}
