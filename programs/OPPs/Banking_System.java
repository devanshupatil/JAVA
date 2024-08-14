
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

class Bank {

    protected String name;
    protected String code;
    protected HashMap<Integer, Branch> branchs = new HashMap<>();
    protected HashMap<String, Integer> branchCode = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    protected Integer getBranchCode(String location) {

        if (branchCode.containsKey(location)) {

            return branchCode.get(location);
        } else {
            System.out.println("Sorry branch is not available in " + location);
        }
        return null;
    }

    protected void addBranch() {

        Branch branch = new Branch();
        System.out.println();
        System.out.print("Enter branch name: ");
        branch.branchName = sc.nextLine();

        System.out.print("Enter location: ");
        branch.location = sc.nextLine();

        branch.branchCode = random.nextInt(100);

        branchCode.put(branch.location, branch.branchCode);
        branchs.put(branch.branchCode, branch);

        System.out.println();
        System.out.println(branch.branchName + " branch is successfully added in " + branch.location);
        System.out.println("Branch code: " + branch.branchCode);

        return;

    }

    protected void getBranch(Integer branchCode) {

        System.out.println();
        System.out.print("Enter branch code: ");
        branchCode = sc.nextInt();
        sc.nextLine();

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

    protected void removeBranch(Integer branchCode) {

        System.out.println();
        System.out.print("Enter branch code: ");
        branchCode = sc.nextInt();
        sc.nextLine();

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
    protected Integer branchCode;
    protected String location;
    protected HashMap<Integer, Account> accounts = new HashMap<>();

    Scanner sc = new Scanner(System.in);

    protected void addAccount(Integer branchcode) {

        Saving_Account saving = new Saving_Account();
        Current_Account current = new Current_Account();

        String type = saving.desplayAccountType();

        if (type == "Saving Account") {

            saving.addCostomer(branchcode, type);
            saving.type = type;
            accounts.put(saving.accountNumber, saving);

        } else {

            current.addCostomer(branchcode, type);
            current.type = type;
            accounts.put(current.accountNumber, current);
        }

        return;
    }

    protected void getAccount(int accountNumber) {

        System.out.print("Enter account number: ");
        accountNumber = sc.nextInt();

        System.out.println();
        if (accounts.containsKey(accountNumber)) {

            System.out.println("Name: " + accounts.get(accountNumber).costomer.Name);
            System.out.println("User Id: " + accounts.get(accountNumber).costomer.userId);
            System.out.println("Phone Number: " + accounts.get(accountNumber).costomer.phone_no);
            System.out.println("Address: " + accounts.get(accountNumber).costomer.address);
            System.out.println("Account Number: " + accounts.get(accountNumber).accountNumber);

            if (accounts.get(accountNumber).type == "Saving Account") {
                System.out.println(
                        "Account type: " + accounts.get(accountNumber).saving_Accounts.get(accountNumber).type);

                System.out
                        .println("Balance: " + accounts.get(accountNumber).saving_Accounts.get(accountNumber).balancel);
            } else {
                System.out.println(
                        "Account type: " + accounts.get(accountNumber).current_Accounts.get(accountNumber).type);
                System.out.println(
                        "Balance: " + accounts.get(accountNumber).current_Accounts.get(accountNumber).balancel);
            }

        } else {

            System.out.println();
            System.out.println("Invalid Account Number!, Please try again");
        }
        return;

    }

    protected void removeAccount(int accountNumber) {

        System.out.print("Enter account number: ");
        accountNumber = sc.nextInt();

        if (accounts.containsKey(accountNumber)) {

            if (accounts.get(accountNumber).type == "Saving Account") {

                accounts.get(accountNumber).saving_Accounts.remove(accountNumber);
            } else {

                accounts.get(accountNumber).current_Accounts.remove(accountNumber);
            }
            accounts.remove(accountNumber);

            System.out.println("Account is successfully removed.");
            return;
        } else {
            System.out.println();
            System.out.println("Invalid Account Number!, Please try again");
            return;
        }
    }

    public String toString() {
        return "  Branch ID: " + branchCode + ", Name: " + branchName + ", Location: " + location;
    }
}

class Account {

    protected int accountNumber;
    protected double balancel;
    protected String type;
    protected HashMap<Integer, Saving_Account> saving_Accounts = new HashMap<>();
    protected HashMap<Integer, Current_Account> current_Accounts = new HashMap<>();
    protected Costomer costomer = new Costomer();

    Scanner sc = new Scanner(System.in);

    protected String desplayAccountType() {
        int choise = 0;

        while (choise >= 0 && choise <= 3) {

            System.out.println();
            System.out.println("1. Saving Account");
            System.out.println("2. Current Account");

            System.out.println();
            System.out.print("Enter choise: ");
            choise = sc.nextInt();

            switch (choise) {
                case 1:
                    return "Saving Account";
                case 2:
                    return "Current Account";
                default:
                    System.out.println("Invalid Choise, Please try again");
                    break;
            }
        }
        return null;
    }

    protected void debitAmount(double amount, Integer Account_no) {

        System.out.print("Enter amount: ");
        amount = sc.nextDouble();

        if (type == "Saving Account") {

            if (saving_Accounts.containsKey(Account_no)) {

                saving_Accounts.get(Account_no).balancel = saving_Accounts.get(Account_no).balancel + amount;
                System.out.println();
                System.out.println(" Your momey is successfully debited.");

            } else {

                System.out.println();
                System.out.println("Invalid Account Number!, Please try again");
            }
        } else {

            if (current_Accounts.containsKey(Account_no)) {

                current_Accounts.get(Account_no).balancel = current_Accounts.get(Account_no).balancel + amount;
                System.out.println();
                System.out.println("Your momey is successfully debited.");

            } else {

                System.out.println();
                System.out.println("Invalid Account Number!, Please try again");
            }
        }

        return;

    }

    protected void creditAmount(double amount, Integer Account_no) {
        System.out.print("Enter amount: ");
        amount = sc.nextDouble();

        if (type == "Saving Account") {

            if (saving_Accounts.containsKey(Account_no)) {

                if (saving_Accounts.get(Account_no).balancel >= amount) {

                    saving_Accounts.get(Account_no).balancel = saving_Accounts.get(Account_no).balancel - amount;
                    System.out.println();
                    System.out.println("Your Transation is successfully down.");

                } else {
                    System.out.println();
                    System.out.print("Insufficient Fund!");
                }

            } else {

                System.out.println();
                System.out.println("Invalid Account Number!, Please try again");
            }

        } else {

            if (current_Accounts.containsKey(Account_no)) {

                if (current_Accounts.get(Account_no).balancel >= amount) {

                    current_Accounts.get(Account_no).balancel = current_Accounts.get(Account_no).balancel - amount;
                    System.out.println();
                    System.out.println("Your Transation is successfully down.");

                } else {

                    System.out.println();
                    System.out.print("Insufficient Fund!");
                }

            } else {

                System.out.println();
                System.out.println("Invalid Account Number!, Please try again");
            }
        }

        return;
    }

    protected double transferAmount(double User_amount, Integer Receiver_Account_no, int User_Account_No) {

        if (User_Account_No != 0) {

            System.out.print("Enter Amount: ");
            User_amount = sc.nextDouble();

            if (saving_Accounts.containsKey(User_Account_No)) {

                if (saving_Accounts.get(User_Account_No).balancel >= User_amount) {

                    saving_Accounts.get(User_Account_No).balancel -= User_amount;

                } else {
                    System.out.println();
                    System.out.print("Insufficient Fund!");
                }

            } else if (current_Accounts.containsKey(User_Account_No)) {

                if (saving_Accounts.get(User_Account_No).balancel >= User_amount) {

                    current_Accounts.get(User_Account_No).balancel -= User_amount;

                } else {

                    System.out.println();
                    System.out.print("Insufficient Fund!");
                }
            } else {

                System.out.println();
                System.out.println("Invalid User Account Number!, Please try again");
            }
        } else {

            if (saving_Accounts.containsKey(Receiver_Account_no)) {

                saving_Accounts.get(Receiver_Account_no).balancel += User_amount;
                System.out.println();
                System.out.println("Your Transation is successfully down.");

            } else if (current_Accounts.containsKey(Receiver_Account_no)) {

                current_Accounts.get(Receiver_Account_no).balancel += User_amount;
                System.out.println();
                System.out.println("Your Transation is successfully down.");

            } else {

                System.out.println();
                System.out.println("Invalid receiver account number!, Please try again");
            }

        }

        return User_amount;

    }

    public String toString() {
        return "  Account Number: " + accountNumber + ", Account Type: " + type + ", Balance: " + balancel;
    }
}

class Saving_Account extends Account {

    double min_Balance;
    String date_Of_Opping;

    protected void addCostomer(Integer branchCode, String Type) {
        Saving_Account saving_account = new Saving_Account();

        Random random = new Random();

        System.out.println();
        sc.nextLine();
        System.out.print("Entar user name: ");
        costomer.Name = sc.nextLine();

        System.out.print("Enter address: ");
        costomer.address = sc.nextLine();

        System.out.print("Enter date: ");
        date_Of_Opping = sc.nextLine();

        System.out.print("Enter phone number: ");
        costomer.phone_no = sc.nextInt();

        costomer.userId = random.nextInt(1000000000);
        accountNumber = random.nextInt(1000000000);
        saving_account.type = Type;
        saving_account.accountNumber = accountNumber;
        saving_Accounts.put(accountNumber, saving_account);

        System.out.println();
        System.out.println(costomer.Name + " is successfully generated the " + Type);
        System.out.println("User Id: " + costomer.userId);
        System.out.println("Account number: " + accountNumber);
        System.out.println("Branch code: " + branchCode);
    }

}

class Current_Account extends Account {
    int interest_Rate;
    String date_Of_Opping;

    protected void addCostomer(Integer branchCode, String Type) {
        Current_Account current_account = new Current_Account();

        Random random = new Random();

        System.out.println();
        System.out.print("Entar user name: ");
        costomer.Name = sc.nextLine();

        System.out.print("Enter address: ");
        costomer.address = sc.nextLine();

        System.out.print("Enter date: ");
        date_Of_Opping = sc.nextLine();

        System.out.print("Enter phone number: ");
        costomer.phone_no = sc.nextInt();

        costomer.userId = random.nextInt(1000000000);
        accountNumber = random.nextInt(1000000000);
        current_account.type = Type;
        current_account.accountNumber = accountNumber;
        current_Accounts.put(accountNumber, current_account);

        System.out.println();
        System.out.println(costomer.Name + " is successfully generated the " + Type);
        System.out.println("User Id: " + costomer.userId);
        System.out.println("Account number: " + accountNumber);
        System.out.println("Branch code: " + branchCode);
    }
}

class Costomer {
    int userId;
    String Name;
    String address;
    int phone_no;
}

public class Banking_System {

    public static void desplayMenu() {
        System.out.println("1. Branch");
        System.out.println("2. Accounts");
        System.out.println("3. Exit");
        return;
    }

    public static void UserChoise(int Choise) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        String location;
        Integer branchCode;
        Integer accountNumber;

        while (Choise >= 0 && Choise <= 5) {

            desplayMenu();
            System.out.print("Enter Choise: ");
            Choise = sc.nextInt();

            switch (Choise) {
                case 1:
                    int choise = 0;
                    while (choise >= 0 && choise <= 6) {

                        System.out.println();
                        System.out.println("1. Open new Branch");
                        System.out.println("2. Check Branch");
                        System.out.println("3. Check All Branch");
                        System.out.println("4. close Branch");
                        System.out.println("5. Back");

                        System.out.print("Enter Choise: ");
                        choise = sc.nextInt();

                        switch (choise) {
                            case 1:
                                bank.addBranch();

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
                                choise = 7;
                                break;
                            default:
                                System.out.println("Invalid choise, Please try again");
                                break;
                        }

                    }
                    break;
                case 2:
                    int opt = 0;

                    while (opt >= 0 && opt <= 8) {

                        System.out.println();
                        System.out.println("1. Open Account");
                        System.out.println("2. Close Account");
                        System.out.println("3. Check Account");
                        System.out.println("4. Withdraw Money");
                        System.out.println("5. Deposit Money");
                        System.out.println("6. Transfer Money");
                        System.out.println("7. Back");

                        System.out.print("Enter Choise: ");
                        opt = sc.nextInt();
                        sc.nextLine();

                        if (opt == 7) {
                            opt = 9;
                            break;
                        }

                        System.out.println();
                        System.out.print("Enter branch location: ");
                        location = sc.nextLine();

                        if (bank.branchCode.containsKey(location)) {
                            switch (opt) {
                                case 1:

                                    branchCode = bank.getBranchCode(location);

                                    bank.branchs.get(branchCode).addAccount(branchCode);
                                    break;
                                case 2:

                                    branchCode = bank.getBranchCode(location);

                                    bank.branchs.get(branchCode).removeAccount(0);
                                    break;
                                case 3:

                                    branchCode = bank.getBranchCode(location);

                                    bank.branchs.get(branchCode).getAccount(0);
                                    break;

                                case 4:

                                    System.out.print("Enter Account Number: ");
                                    accountNumber = sc.nextInt();
                                    branchCode = bank.getBranchCode(location);

                                    if (bank.branchs.get(branchCode).accounts.containsKey(accountNumber)) {

                                        bank.branchs.get(branchCode).accounts.get(accountNumber).creditAmount(0.0,
                                                accountNumber);
                                    } else {
                                        System.out.println();
                                        System.out.println("Invalid account number, Please try again");
                                    }

                                    break;
                                case 5:

                                    System.out.print("Enter Account Number: ");
                                    accountNumber = sc.nextInt();
                                    branchCode = bank.getBranchCode(location);

                                    if (bank.branchs.get(branchCode).accounts.containsKey(accountNumber)) {

                                        bank.branchs.get(branchCode).accounts.get(accountNumber).debitAmount(0.0,
                                                accountNumber);
                                    } else {
                                        System.out.println();
                                        System.out.println("Invalid account number, Please try again");
                                    }
                                    break;

                                case 6:
                                    Integer Your_Account_no;
                                    Integer Account_no;
                                    String receiver_barnch_location;
                                    Integer receiver_barnch_code;
                                    double amount;

                                    System.out.print("Enter user account number: ");
                                    Your_Account_no = sc.nextInt();
                                    branchCode = bank.getBranchCode(location);

                                    sc.nextLine();
                                    System.out.print("Enter receiver branch address: ");
                                    receiver_barnch_location = sc.nextLine();
                                    receiver_barnch_code = bank.getBranchCode(receiver_barnch_location);

                                    System.out.print("Enter receiver account numbre: ");
                                    Account_no = sc.nextInt();

                                    if (bank.branchs.get(branchCode).accounts.containsKey(Your_Account_no)) {

                                        amount = bank.branchs.get(branchCode).accounts.get(Your_Account_no)
                                                .transferAmount(0, 0,
                                                        Your_Account_no);

                                        if (bank.branchs.get(receiver_barnch_code).accounts.containsKey(Account_no)) {

                                            if (bank.branchs.get(branchCode).accounts
                                                    .get(Your_Account_no).saving_Accounts
                                                    .get(Your_Account_no).balancel >= amount) {

                                                bank.branchs.get(branchCode).accounts.get(Account_no)
                                                        .transferAmount(amount, Account_no,
                                                                0);
                                            }
                                        } else

                                        {
                                            System.out.println("Invalid receiver account numbre!, Please try again");
                                        }

                                    } else

                                    {
                                        System.out.println("Invalid user account numbre!, Please try again");
                                    }

                                    break;
                                default:
                                    System.out.println("Invalid choise, Please try again");
                                    break;
                            }
                        } else {

                            System.out.println("Sorry the branch is not available");
                        }

                    }

                    break;

                case 3:
                    System.out.println("\nTHANK YOU FOR USEING BANKING SYSYTEM.");
                    System.exit(0);

                    break;
                default:
                    System.out.println("Invalid choise, Please try again");
                    break;
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {

        System.out.println("-----------*** WELCOME TO BANKING SYSTEM ***-----------\n");
        System.out.println("----->> Choose the choise <<-----");
        UserChoise(0);
    }
}