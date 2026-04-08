package mpj;

import java.io.*;
import java.util.Scanner;

class BankingException extends Exception {
    public BankingException(String message) {
        super(message);
    }
}

public class Assignment4 {
    static final String FILE_NAME = "banking_data.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Banking System Menu ---");
            System.out.println("1. Create Account\n2. Withdraw Money\n3. View Records\n4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1: createAccount(sc); break;
                    case 2: withdraw(sc); break;
                    case 3: viewRecords(); break;
                    case 4: System.out.println("Exiting..."); break;
                    default: System.out.println("Invalid Choice!");
                }
            } catch (BankingException | IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 4);
        sc.close();
    }

    static void createAccount(Scanner sc) throws BankingException, IOException {
        System.out.print("Enter Customer ID (1-20): ");
        int cid = sc.nextInt();
        if (cid < 1 || cid > 20) throw new BankingException("ID must be between 1 and 20.");

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Initial Deposit: ");
        double amount = sc.nextDouble();
        if (amount < 0) throw new BankingException("Amount must be positive.");
        if (amount < 1000) throw new BankingException("Minimum 1000 required to open account.");

        FileWriter fw = new FileWriter(FILE_NAME, true);
        fw.write(cid + "," + name + "," + amount + "\n");
        fw.close();
        System.out.println("Account created successfully!");
    }

    static void withdraw(Scanner sc) throws BankingException {
        System.out.print("Enter withdrawal amount: ");
        double wthAmt = sc.nextDouble();
        double currentBalance = 5000; 
        if (wthAmt > currentBalance) throw new BankingException("Insufficient Balance!");
        System.out.println("Withdrawal successful! Remaining: " + (currentBalance - wthAmt));
    }

    static void viewRecords() throws IOException {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No records found.");
            return;
        }
        Scanner fr = new Scanner(file);
        System.out.println("CID | Name | Balance");
        while (fr.hasNextLine()) {
            System.out.println(fr.nextLine().replace(",", " | "));
        }
        fr.close();
    }
}