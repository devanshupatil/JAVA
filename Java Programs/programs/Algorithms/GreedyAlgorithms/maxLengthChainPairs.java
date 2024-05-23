import java.util.Arrays;
import java.util.Comparator;

public class maxLengthChainPairs {

    public static void main(String[] arge) {
        int pair[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };

        Arrays.sort(pair, Comparator.comparingDouble(o -> o[1]));
        int chainLength = 1;
        int pairEnd = pair[0][1]; // Last selected pair end / Chain end

        for (int i = 0; i < pair.length; i++) {
            if (pair[i][0] > pairEnd) {
                chainLength++;
                pairEnd = pair[i][1];
            }
        }
        System.out.println("Maximun pair length = " + chainLength);
    }

}
