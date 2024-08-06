import java.util.Scanner;

public class Score_High {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int arr[] = new int[4];
            for (int j = 0; j < 4; j++) {
                arr[j] = sc.nextInt();
            }
            int max = arr[0];

            for (int k = 0; k < 4; k++) {
                if (max < arr[k]) {
                    max = arr[k];
                }
            }

            System.out.println(max);

        }
        sc.close();
    }
}