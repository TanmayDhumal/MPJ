package mpj;

import java.util.Scanner; 


class Hillstations {
    void famousFood() { 
        System.out.println("Local hill food."); 
    }
    void famousFor() { 
        System.out.println("Natural beauty."); 
    }
}


class Manali extends Hillstations {
    @Override
    void famousFood() { System.out.println("Manali Food: Sidu."); }
    @Override
    void famousFor() { System.out.println("Manali is famous for: Adventure sports."); }
}

class Mussoorie extends Hillstations {
    @Override
    void famousFood() { System.out.println("Mussoorie Food: Aloo ke Gutke."); }
    @Override
    void famousFor() { System.out.println("Mussoorie is famous for: The Mall Road."); }
}


public class Assignment3b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hillstations h; // Parent reference variable

        System.out.println("Enter Hillstation Choice (1. Manali, 2. Mussoorie): ");
        
        if (sc.hasNextInt()) {
            int choice = sc.nextInt();

            if (choice == 1) {
                h = new Manali(); 
            } else if (choice == 2) {
                h = new Mussoorie(); 
            } else {
                System.out.println("Invalid choice, defaulting to general Hillstation.");
                h = new Hillstations();
            }

        
            h.famousFood();
            h.famousFor();
        } else {
            System.out.println("Error: Please enter a numeric choice.");
        }

        sc.close();
    }
}

