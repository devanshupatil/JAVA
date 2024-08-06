
public class Coins_Problem {
    public static void main(String agrs[]) {
        int Amount = 15;
        int Coins[] = { 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int Arr[][] = new int[Coins.length + 1][Amount + 1];

        // Initialize
        for (int i = 0; i <= Coins.length; i++) {
            Arr[i][0] = 1; // One way to make amount 0
        }

        for (int i = 1; i <= Coins.length; i++) {
            for (int j = 1; j <= Amount; j++) {
                if (Coins[i - 1] > j) {
                    Arr[i][j] = Arr[i - 1][j];
                } else {
                    Arr[i][j] = Arr[i - 1][j] + Arr[i][j - Coins[i - 1]];
                    printArray(Arr, Coins.length, Amount);
                }
            }
        }

        System.out.println("The number of ways to change the amount " + Amount + " = " + Arr[Coins.length][Amount]);

    }

    public static void printArray(int[][] arr, int rows, int cols) {
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
