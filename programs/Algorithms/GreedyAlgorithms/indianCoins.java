import java.util.ArrayList;
import java.util.Arrays;

public class indianCoins {
    public static void main(String[] arge) {
        int indianCoins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        int amount = 590;
        int count = 0;
        int index = indianCoins.length - 1;
        Arrays.sort(indianCoins);
        ArrayList<Integer> ans = new ArrayList<>();

        while (amount != 0) {

            if (amount >= indianCoins[index]) {
                amount -= indianCoins[index];
                ans.add(indianCoins[index]);
                count++;
            } else {
                index--;
            }

        }
        System.out.println("Total minimun coins used = " + count);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();

    }

}