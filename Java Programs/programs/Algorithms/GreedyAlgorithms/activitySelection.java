
import java.util.*;

public class activitySelection {

    public static void main(String agrs[]) {

        int Start[] = { 1, 3, 0, 5, 8, 5 };
        int End[] = { 2, 4, 6, 7, 9, 9 };
        int maxActivitys = 1;

        // sorting
        int activity[][] = new int[Start.length][3];
        for (int i = 0; i < Start.length; i++) {
            activity[i][0] = i;
            activity[i][1] = Start[i];
            activity[i][2] = End[i];
        }
        // lambda functon -> shortfrom
        // comparator is a lambda function
        Arrays.sort(activity, Comparator.comparingDouble(o -> o[2])); // for the 2d array
        // o[2] is, we have to sort colum numberd 2 (End Array)
        /*
         * 0 1 2
         * | | | |
         * | | | |
         * | | | |
         * | | | |
         */

        ArrayList<Integer> ans = new ArrayList<>();

        // First activity
        ans.add(activity[0][0]); // Passing index of array
        int lastEnd = activity[0][2];

        for (int i = 1; i < End.length; i++) {
            if (activity[i][1] >= lastEnd) {
                maxActivitys++;
                ans.add(activity[i][0]);
                lastEnd = activity[i][2];
            }
        }

        System.out.println("Max activity = " + maxActivitys);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
    }
}