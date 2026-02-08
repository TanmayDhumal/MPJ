class Student {

    // Instance variables
    int id;
    String name;
    int age;

    // Constructor
    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Method to display student details
    void displayInfo() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        
    }
}

public class Assignment1 {
    public static void main(String[] args) {

        // Object creation
        Student s1 = new Student(02, "Tanmay", 20);
        Student s2 = new Student(05, "Lakshya", 20);

        // Calling methods
        s1.displayInfo();
        s2.displayInfo();
    }
}
