import java.io.*;
import java.util.Scanner;


public class Assignment4 {
    private static final String FILE_NAME = "assignment.txt";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        System.out.println("--- Welcome to the Simple File Manager ---");

        do {
            printMenu();
            choice = getSafeInt();

            switch (choice) {
                case 1 -> writeToFile(false); // Overwrite
                case 2 -> readFromFile();
                case 3 -> writeToFile(true);  // Append
                case 4 -> System.out.println("Goodbye! Have a great day.");
                default -> System.out.println("Oops! That's not a valid option. Try 1-4.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1) Write (New File)");
        System.out.println("2) Read (View Content)");
        System.out.println("3) Append (Add to File)");
        System.out.println("4) Exit");
        System.out.print("Selection: ");
    }

    private static void writeToFile(boolean append) {
        System.out.print(append ? "Enter text to add: " : "Enter text for the new file: ");
        String input = scanner.nextLine();

        
        try (FileWriter fw = new FileWriter(FILE_NAME, append);
             BufferedWriter bw = new BufferedWriter(fw)) {
            
            if (append) bw.newLine(); 
            bw.write(input);
            
            System.out.println(append ? "Successfully added to the file." : "File created and saved.");
        } catch (IOException e) {
            System.err.println("Failed to save data: " + e.getMessage());
        }
    }

    private static void readFromFile() {
        File file = new File(FILE_NAME);
        
        if (!file.exists()) {
            System.out.println("The file doesn't exist yet! Try writing something first.");
            return;
        }

        System.out.println("\n--- Current File Content ---");
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("----------------------------");
        } catch (IOException e) {
            System.err.println("Could not read the file: " + e.getMessage());
        }
    }

    private static int getSafeInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        int val = scanner.nextInt();
        scanner.nextLine(); 
        return val;
    }
}