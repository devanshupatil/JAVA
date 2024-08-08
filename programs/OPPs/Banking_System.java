import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Bank {

    String bankName;
    String address;
    List<List<Branch>> branchs = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addBranch(String branchName, int branchId, String branchAddress) {

        System.out.print("Enetr Branch name: ");
        branchName = sc.nextLine();

        System.out.print("Enter Branch address: ");
        branchAddress = sc.nextLine();

    }

    public void getBranch() {

    }
}

class Branch {
    String branchName;
    private int branchId;
    String branchLocation;

    public void addAccount(Account account) {

    }

    public void getAccount(int usreId) {

    }

    public void closeAccount(int accountNumber) {

    }

}

class Employee {
    int employeeId;
    String employeeName;
    String employeePostion;

    public void Transaction(Transaction transaction)

    {

    }

    public void assistCostomer(Costomer costomer) {

    }
}

class Costomer {
    private String userName;
    protected int userId;
    protected double password;
    protected String address;

    public void openAccount(Account ac) {

    }

    public void closeAccount(int accountNumber) {

    }
}

class Account {
    protected int accountNumber;
    protected double balance;
    protected String type;
    List<Transaction> transactions = new ArrayList<>();

    public void deposit(double amount) {

    }

    public void withdraw(double amount) {

    }

    public double getBlance() {
        return balance;
    }

    public void addTransaction(Transaction transaction) {

    }

}

class Transaction {
    int transactionId;
    Date date;
    double amount;
    int type;

    public void execute() {

    }

    public void reverse() {

    }
}

public class Banking_System {
    public static void main(String[] args) {

    }

}