import java.util.Scanner;

public class TheLastLevels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int remainingLevels = sc.nextInt();
            int minComplete = sc.nextInt();
            int minBreak = sc.nextInt();
            int completeTime = 0;

            while (remainingLevels > 0) {
                if (remainingLevels <= 3) {
                    completeTime += (remainingLevels * minComplete);
                    remainingLevels = 0;
                } else {
                    remainingLevels -= 3;
                    completeTime += (3 * minComplete) + minBreak;
                }
            }
            System.out.println(completeTime);
        }
        sc.close();

    }

}
