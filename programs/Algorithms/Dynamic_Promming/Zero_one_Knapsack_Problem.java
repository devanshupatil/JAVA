
public class Zero_one_Knapsack_Problem {

    public static void main(String[] args) {
        int weight[] = { 3, 4, 6, 5 };
        int Profit[] = { 2, 3, 1, 4 };

        // Sort weight Array
        for (int i = 0; i < weight.length - 1; i++) {
            if (weight[i] > weight[i + 1]) {
                int temp = weight[i];
                weight[i] = weight[i + 1];
                weight[i + 1] = temp;
                temp = Profit[i];
                Profit[i] = Profit[i + 1];
                Profit[i + 1] = temp;
            }
        }
        int bagCapacitry = 8;
        int x = 0;
        int y = 0;
        int z = 0;
        int Arr[][] = new int[weight.length + 1][bagCapacitry + 1];

        // Calculate the Maximum profit
        for (int i = 1; i <= weight.length; i++) {
            for (int j = 1; j <= bagCapacitry; j++) {

                if (weight[i - 1] > j) {
                    Arr[i][j] = Arr[i - 1][j];
                } else {
                    x = j - weight[i - 1];
                    y = Profit[i - 1];
                    z = Arr[i - 1][j];

                    Arr[i][j] = Math.max((Arr[i - 1][x] + y), z);

                }
                printArray(Arr, weight.length, bagCapacitry);

            }
        }
        System.out.println("The maximum profit = " + Arr[weight.length][bagCapacitry]);

        int bagItems[] = new int[weight.length];
        int j = 0;
        int i = weight.length;

        // Calculate the numbrs of values take in bag
        while (bagCapacitry >= 0) {

            if (Arr[i][bagCapacitry] == 0) {
                break;
            } else {
                if (Arr[i][bagCapacitry] != Arr[i - 1][bagCapacitry]) {

                    bagItems[j] = Arr[i - 1][bagCapacitry];
                    bagCapacitry -= Profit[i - 1];
                    j++;
                    i--;

                    if (Arr[i][bagCapacitry] != Arr[i - 1][bagCapacitry]) {

                        bagItems[j] = Arr[i][bagCapacitry];
                        bagCapacitry -= Profit[i - 1];
                        j++;
                    }
                } else {
                    i--;
                }
            }
        }
        j = 0;
        System.out.print("Number of items we take = ");
        while (bagItems[j] != 0) {
            System.out.print(bagItems[j] + " ");
            j++;

        }
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