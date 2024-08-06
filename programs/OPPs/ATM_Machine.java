import java.util.Scanner;

class ATM {
    private float Balance;
    private int PIN = 9294;

    public void checkpin(int count) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter PIN : ");
        int entaredpin = sc.nextInt();
        System.out.println();

        if (count != 5) {
            if (entaredpin == PIN) {

                menu();
            } else {

                System.out.println("INVALIB PIN!");
                count++;
                checkpin(count);
            }
        } else {
            System.out.println("Try After Sometime");
            System.exit(0);
        }
        sc.close();
    }

    public void menu() {

        Scanner sc = new Scanner(System.in);
        System.out.println("1. Check A/C Balance");
        System.out.println("2 .Withdraw Money");
        System.out.println("3. Deposti Money");
        System.out.println("4. Exit");

        System.out.print("\nEnter Opstion : ");
        int opt = sc.nextInt();
        System.out.println();

        switch (opt) {
            case 1:
                CheckBalance();

                break;
            case 2:
                withdramoney();

                break;

            case 3:
                DepositBalance();

                break;

            case 4:
                System.exit(0);

                break;
            default:
                System.out.println("INVALID CHOICE!");

                break;
        }
        sc.close();
    }

    public void CheckBalance() {

        System.out.println("Balance : " + Balance);
        System.out.println("\n*************************\n");
        menu();
    }

    public void withdramoney() {

        System.out.print("Enter Amount : ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        System.out.println();

        if (amount > Balance) {

            System.out.println("Insufficient Balance");
            System.out.println("\n*************************\n");

        } else {

            Balance -= amount;
            System.out.println("Successfully Withdraw");
            System.out.println("\n*************************\n");

        }

        menu();
        sc.close();
    }

    public void DepositBalance() {

        System.out.print("Enter Amount : ");
        Scanner sc = new Scanner(System.in);

        float amount = sc.nextFloat();
        System.out.println();

        Balance += amount;
        System.out.println("Deposit Money Successfully");
        System.out.println("\n*************************\n");
        menu();
        sc.close();

    }

}

public class ATM_Machine {

    public static void main(String[] args) {

        ATM atm = new ATM();
        atm.checkpin(0);
    }

}
