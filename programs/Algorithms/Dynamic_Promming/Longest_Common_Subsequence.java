
class Longest_Common_Subsequence {

    public static void main(String arge[]) {
        char x[] = { 'a', 'b', 'a', 'a', 'b', 'a' };
        char y[] = { 'b', 'a', 'b', 'b', 'a', 'b' };

        int Arr[][] = new int[x.length + 1][y.length + 1];

        for (int i = 1; i <= x.length; i++) {
            for (int j = 1; j <= y.length; j++) {
                if (x[i - 1] == y[j - 1]) {
                    Arr[i][j] = 1 + Arr[i - 1][j - 1];
                } else {
                    Arr[i][j] = Math.max(Arr[i][j - 1], Arr[i - 1][j]);
                    printArray(Arr, x.length, y.length);
                }
            }
        }
        System.out.println(Arr[x.length][y.length]);
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
