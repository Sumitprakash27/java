import java.util.Scanner;

public class ATM {
    static int pin = 3214;
    static double balance = 5000; 
    static double atmBalance = 50000; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Enter the pin
        if (Checking_Pin(sc)) {
            System.out.println("You entered a valid pin.");
            
            // Option for withdrawal or deposit
            System.out.println("Choose an option: ");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            int choice = sc.nextInt();

            if (choice == 1) {
                Withdrawal_Amount(sc); // Handle withdrawal
            } else if (choice == 2) {
                Deposit_Amount(sc); // Handle deposit
            } else {
                System.out.println("Invalid option.");
            }
        } else {
            System.out.println("Invalid PIN, Please try again.");
        }
    }

    // Checking for valid pin
    public static boolean Checking_Pin(Scanner sc) {
        System.out.print("Please enter your ATM pin: ");
        if (sc.hasNextInt()) {
            int userPin = sc.nextInt();
            return userPin == pin; // Returns true if the pin matches, otherwise false
        } else {
            return false; // If the input is not integer then it will give false
        }
    }

    // Withdrawal operation
    public static void Withdrawal_Amount(Scanner sc) {
        System.out.print("Enter the withdrawal amount: ");
        if (sc.hasNextInt()) {
            int withdrawal = sc.nextInt();
            
            // Comparing the amount with the balance
            if (ComparingWithBalance(withdrawal)) { // Checking user balance and ATM balance
                Transaction(withdrawal); // If true then the transaction will be successful
            } else {
                System.out.println("Insufficient balance in your account or ATM.");
            }
        } else {
            System.out.println("Invalid amount, please enter a valid number.");
        }
    }

    // Deposit operation
    public static void Deposit_Amount(Scanner sc) {
        System.out.print("Enter the deposit amount (max 50000): ");
        if (sc.hasNextInt()) {
            int deposit = sc.nextInt();

            // Check if the deposit amount is within the allowed limit
            if (deposit <= 50000) {
                balance += deposit; // Add deposit to user balance
                atmBalance += deposit; // Add deposit to ATM balance
                System.out.println("Deposit successful.");
                System.out.println("Your updated balance: " + balance);
                System.out.println("ATM balance: " + atmBalance);
            } else {
                System.out.println("Maximum Limit reached");
            }
        } else {
            System.out.println("Invalid amount, please enter a valid number.");
        }
    }

    // Checking if the balance is sufficient to withdraw
    public static boolean ComparingWithBalance(int withdrawal) {
        return withdrawal <= balance && withdrawal <= atmBalance;
    }

    // Transaction for withdrawal
    public static void Transaction(int withdrawal) {
        balance -= withdrawal;
        atmBalance -= withdrawal;
        System.out.println("Transaction successful.");
        System.out.println("Your remaining balance: " + balance);
        System.out.println("ATM balance: " + atmBalance);
    }
}
