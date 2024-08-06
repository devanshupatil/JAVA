package Basic_Problem_Solving;

import java.util.Scanner;

public class bitwiseOperators {
    public static void main(String[] args) throws Exception {
        int n = 5; // 0101
        int pos = 1;
        int bitMask = 1 << pos;

        System.out.println("Get Bit :- ");
        System.out.println(bitMask & n);

        System.out.print("\n");
        System.out.println("***************************");

        System.out.println("Set Bit :-");
        System.out.println(bitMask | n);

        System.out.print("\n");
        System.out.println("***************************");

        System.out.println("Clear Bit :- ");
        int notBitMask = ~(bitMask);
        System.out.println(notBitMask & n);

        System.out.print("\n");
        System.out.println("***************************");

        System.out.println("Update Bit :- ");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the '0' or '1', which you have to change: ");
        int input = sc.nextInt();

        if (input == 0) {
            int notBit = ~(bitMask);
            System.out.println(notBit & n);

        } else {
            System.out.println(bitMask | n);

        }
        sc.close();
    }
}
