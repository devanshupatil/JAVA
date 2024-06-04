import java.util.Arrays;
import java.util.Comparator;

public class FreactionalKnapsack {
    public static void main(String arge[]) {
        int value[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        double ratio[][] = new double[value.length][2];

        for (int i = 0; i < value.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double) weight[i];
        }

        // ascending order sorting
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        int capacity = 50;
        int finalValue = 0;

        for (int i = ratio.length - 1; i >= 0; i--) {
            int index = (int) ratio[i][0];

            if (capacity >= weight[index]) {
                finalValue += value[index];
                capacity -= weight[index];
            } else {
                finalValue += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("Final Value = " + finalValue);

    }

}
