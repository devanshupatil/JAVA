import java.util.Scanner;

public class Non_Negative_Product {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter t : ");
        int t = sc.nextInt();

        for (int l = 0; l < t; l++) { // Run each tast case

            System.out.print("Enter n : ");
            int n = sc.nextInt();
            int arr[] = new int[n];
            int count_0 = 0;
            int count_1 = 0;

            System.out.print("Enter array value : ");

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] < 0) { // If the array of index 'i' value is less than 0
                    count_1++; // add by one
                }

                if (arr[i] == 0) { // If the array of index 'i' value is equal to 0
                    count_0++; // add by one
                }
            }

            if (count_1 % 2 == 0 || count_0 >= 1) { // If count_1 is even or count_0 more or equal to 1

                System.out.println(0); // If true, print 0
            } else {
                System.out.println(1); // If false, print 1
            }

        }
        sc.close();
    }
}
