
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

class Bank {

    protected String name;
    protected String code;
    protected HashMap<String, Branch> branchs = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    protected void addBranch(Branch branch) {

        System.out.println();
        System.out.print("Enter branch name: ");
        branch.branchName = sc.nextLine();

        System.out.print("Enter location: ");
        branch.location = sc.nextLine();

        branch.branchCode = UUID.randomUUID().toString();

        System.out.println("Branch code: " + branch.branchCode);
        branchs.put(branch.branchCode, branch);

        System.out.println(branch.branchName + " branch is successfully added in " + branch.location);

    }

    protected void getBranch(String branchCode) {

        System.out.println();
        System.out.print("Enter branch code: ");
        branchCode = sc.nextLine();

        if (branchs.containsKey(branchCode)) {
            System.out.println();
            System.out.println("Branch name: " + branchs.get(branchCode).branchName);
            System.out.println("Branch code: " + branchs.get(branchCode).branchCode);
            System.out.println("Location: " + branchs.get(branchCode).location);
            return;
        } else {
            System.out.println();
            System.out.println("Invalid code!, Please try again");
            return;
        }

    }

    protected void removeBranch(String branchCode) {

        System.out.println();
        System.out.print("Enter branch code: ");
        branchCode = sc.nextLine();

        if (branchs.containsKey(branchCode)) {

            branchs.remove(branchCode);
            System.out.println("Branch is successfully removed \n");
            return;

        } else {

            System.out.println("Invalid code!, Please try again");
            return;
        }
    }

    protected void getAllBranch() {

        System.out.println();
        System.out.println(branchs);
    }
}

class Branch {

    protected String branchName;
    protected String branchCode;
    protected String location;
    protected HashMap<Integer, Account> accounts = new HashMap<>();
    protected HashMap<Integer, Costomer> costomers = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    protected void addAccount(Costomer costomer, Account account) {

        System.out.println();
        System.out.print("Entar user name: ");
        costomer.Name = sc.nextLine();

        System.out.print("Enter address: ");
        costomer.address = sc.nextLine();

        System.out.print("Enter phone number: ");
        costomer.phone_no = sc.nextInt();

        costomer.userId = random.nextInt(1000000000);
        account.accountNumber = random.nextInt(1000000000);

        accounts.put(account.accountNumber, account);
        costomers.put(account.accountNumber, costomer);

        System.out.println(costomer.Name + " is successfully added the " + account.type);
        System.out.println("User Id: " + costomer.userId);
        System.out.println("Account number: " + account.accountNumber);

        return;

    }

    protected void getAccount(int accountNumber) {

        System.out.println();
        System.out.print("Enter account number: ");
        accountNumber = sc.nextInt();

        if (accounts.containsKey(accountNumber)) {

            System.out.println("Name: " + costomers.get(accountNumber).Name);
            System.out.println("User Id: " + costomers.get(accountNumber).userId);
            System.out.println("Phone Number: " + costomers.get(accountNumber).phone_no);
            System.out.println("Address: " + costomers.get(accountNumber).address);
            System.out.println("Account Number: " + accounts.get(accountNumber).accountNumber);
            System.out.println("Balance: " + accounts.get(accountNumber).balancel);
            return;
        } else {
            System.out.println();
            System.out.println("Invalid Account Number!, Please try again");
            return;
        }

    }

    protected void removeAccount(int accountNumber) {

        System.out.println();
        System.out.print("Enter account number: ");
        accountNumber = sc.nextInt();

        if (accounts.containsKey(accountNumber)) {

            accounts.remove(accountNumber);
            costomers.remove(accountNumber);

            System.out.println("Account is successfully removed.");
            return;
        } else {
            System.out.println();
            System.out.println("Invalid Account Number!, Please try again");
            return;
        }
    }

    protected void addLoan() {

    }

    protected void removeLoan() {

    }

    protected void getLoan() {

    }

    public String toString() {
        return "  Branch ID: " + branchCode + ", Name: " + branchName + ", Location: " + location;
    }
}

class Loan {

    int loanNumber;
    double amount;
    String type;

    void addCustomar() {

    }

    void prepayment() {

    }

    void getEMI() {

    }
}

class Account {
    protected int accountNumber;
    protected double balancel;
    protected String type;
    Scanner sc = new Scanner(System.in);
    protected Branch branch = new Branch();

    void debitAmount(double amount) {

        System.out.println();
        System.out.print("Enter account number: ");
        accountNumber = sc.nextInt();

        if (branch.accounts.containsKey(accountNumber)) {

            branch.accounts.get(accountNumber).balancel += amount;

            System.out.println("Your momey is successfully debited.");
            return;
        } else {
            System.out.println();
            System.out.println("Invalid Account Number!, Please try again");
            return;
        }

    }

    void creditAmount(double amount) {

        System.out.println();
        System.out.print("Enter account number: ");
        accountNumber = sc.nextInt();

        if (branch.accounts.containsKey(accountNumber)) {

            branch.accounts.get(accountNumber).balancel -= amount;

            System.out.println("Your Transation is successfully down.");
            return;

        } else {

            System.out.println();
            System.out.println("Invalid Account Number!, Please try again");
            return;
        }
    }
}

class Saving_Account extends Account {
    int min_Balance;
    Date date_Of_Opping;

    void addCostomer() {

    }

    void removeCostomer() {

    }
}

class Current_Account extends Account {
    int interest_Rate;
    Date date_Of_Opping;

    void addCostomer() {

    }

    void removeCostomer() {

    }
}

class Costomer {
    int userId;
    String Name;
    String address;
    int phone_no;
}

public class Banking_System {

    public static String accountType(int Choise) {

        System.out.println();
        System.out.println("1. Saving Account");
        System.out.println("2. Current Account");
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter choise: ");
        Choise = sc.nextInt();

        switch (Choise) {
            case 1:

                return "Saving Account";
            case 2:

                return "Current Account";

            default:
                System.out.println("Invalid Choise, Please try again");
                break;
        }

        accountType(Choise);
        return null;
    }

    public static void accountsMenu(int choise) {
        System.out.println();
        System.out.println("1. Open Account");
        System.out.println("2. Close Account");
        System.out.println("3. Check Account");
        System.out.println("4. Back");

        Branch branch = new Branch();
        Account account = new Account();
        Costomer costomer = new Costomer();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Choise: ");
        choise = sc.nextInt();

        switch (choise) {
            case 1:

                branch.addAccount(costomer, account);
                break;
            case 2:

                branch.removeAccount(0);
                break;
            case 3:

                branch.getAccount(0);
                break;

            case 4:
                return;
            default:
                System.out.println("Invalid choise, Please try again");
                break;
        }
        System.out.println();
        accountsMenu(choise);

    }

    public static void branchMenu(int choise) {
        System.out.println();
        System.out.println("1. Open new Branch");
        System.out.println("2. Check Branch");
        System.out.println("3. Check All Branch");
        System.out.println("4. close Branch");
        System.out.println("5. Back");

        Bank bank = new Bank();
        Branch branch = new Branch();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Choise: ");
        choise = sc.nextInt();

        switch (choise) {
            case 1:
                bank.addBranch(branch);

                break;
            case 2:
                bank.getBranch(null);
                break;
            case 3:

                bank.getAllBranch();
                break;
            case 4:
                bank.removeBranch(null);

                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choise, Please try again");
                break;
        }
        System.out.println();
        branchMenu(choise);
    }

    public static void desplayMenu() {
        System.out.println("1. Branch");
        System.out.println("2. Accounts");
        System.out.println("3. Loans");
        System.out.println("4. Exit");
        return;
    }

    public static void Loans(int Choise) {

        System.out.println();
        System.out.println("1. Take Loan");
        System.out.println("2. Close Loan");
        System.out.println("3. Check Loan");
        System.out.println("4. Get EMI");
        System.out.println("5. Back");

        Branch branch = new Branch();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Choise: ");
        Choise = sc.nextInt();

        switch (Choise) {

            case 1:
                branch.addLoan();
                break;
            case 2:
                branch.removeLoan();

                break;
            case 3:
                branch.getLoan();

                break;
            case 4:

                break;

            case 5:

                return;
            default:
                System.out.println("Invalid choise, Please try again");
                break;
        }

        Loans(Choise);
    }

    public static void UserChoise(int Choise) {

        Scanner sc = new Scanner(System.in);

        desplayMenu();
        System.out.print("Enter Choise: ");
        Choise = sc.nextInt();

        switch (Choise) {
            case 1:
                branchMenu(0);
                break;
            case 2:
                accountsMenu(0);
                break;
            case 3:
                Loans(0);
                break;
            case 4:
                System.out.println("\nTHANK YOU FOR USEING BANKING SYSYTEM.");
                System.exit(0);

                break;
            default:
                System.out.println("Invalid choise, Please try again");
                break;
        }

        System.out.println();
        UserChoise(0);
    }

    public static void main(String[] args) {

        System.out.println("-----------*** WELCOME TO BANKING SYSTEM ***-----------\n");
        System.out.println("----->> Choose the choise <<-----");
        UserChoise(0);
    }

}
