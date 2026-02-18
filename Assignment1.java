

import java.util.Scanner;

class Student {
    private String name;
    private int rollNo;
    private int m1, m2, m3, m4, m5;
    private float average;
    private char grade;

    // Constructor
    public Student(String name, int rollNo, int m1, int m2, int m3, int m4, int m5) {
        this.name = name;
        this.rollNo = rollNo;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
        this.m5 = m5;
    }

    // Method Calculate avg and grade
    public void calculateResult() {
        average = (m1 + m2 + m3 + m4 + m5) / 5.0f;

        if (average >= 75)
            grade = 'A';
        else if (average >= 60)
            grade = 'B';
        else
            grade = 'C';
    }

    // Display result
    public void display() {
        System.out.println("\nName    : " + name);
        System.out.println("Roll No : " + rollNo);
        System.out.println("Average : " + average);
        System.out.println("Grade   : " + grade);
    }
}

public class Assignment1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Name: ");
            sc.nextLine(); // clear buffer
            String name = sc.nextLine();

            System.out.print("Roll No: ");
            int rollNo = sc.nextInt();

            System.out.print("Enter 5 marks:\n ");
            int m1 = sc.nextInt();
            int m2 = sc.nextInt();
            int m3 = sc.nextInt();
            int m4 = sc.nextInt();
            int m5 = sc.nextInt();

            students[i] = new Student(name, rollNo, m1, m2, m3, m4, m5);
            students[i].calculateResult();
        }

        System.out.println("\n Student Results");

        for (int i = 0; i < n; i++) {
            students[i].display();
        }

        sc.close();
    }
}
