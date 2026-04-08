package mpj;

import java.util.Scanner;

class Assignment3a {
    
    void calculateArea(int side) {
        System.out.println("Area of Square: " + (side * side));
    }

    
    void calculateArea(int length, int width) {
        System.out.println("Area of Rectangle: " + (length * width));
    }

    
    void calculateArea(double radius) {
        System.out.println("Area of Circle: " + (3.14159 * radius * radius));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        Assignment3a s = new Assignment3a();

        System.out.println("Choose Shape: 1.Square 2.Rectangle 3.Circle");
        
        if (sc.hasNextInt()) {
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter side: ");
                    s.calculateArea(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter length: ");
                    int l = sc.nextInt();
                    System.out.print("Enter width: ");
                    int w = sc.nextInt();
                    s.calculateArea(l, w);
                    break;
                case 3:
                    System.out.print("Enter radius: ");
                    s.calculateArea(sc.nextDouble());
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } else {
            System.out.println("Please enter a valid number.");
        }
        
        sc.close();
    }
}