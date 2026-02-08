/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tanmaydhumal
 */
class Employee {

    double salary;

    Employee(double salary) {
        this.salary = salary;
    }

    void displaySalary() {
        System.out.println("Salary before hike: " + salary);
    }
}


class FullTimeEmployee extends Employee {

    FullTimeEmployee(double salary) {
        super(salary);
    }

    void calculateSalary() {
        double hike = salary * 0.50;
        salary = salary + hike;
        System.out.println("Salary after 50% hike: " + salary);
    }
}

class InternEmployee extends Employee {

    InternEmployee(double salary) {
        super(salary);
    }

    void calculateSalary() {
        double hike = salary * 0.25;
        salary = salary + hike;
        System.out.println("Salary after 25% hike: " + salary);
    }
}

public class Assignment2 {
    public static void main(String[] args) {

        FullTimeEmployee f1 = new FullTimeEmployee(40000);
        f1.displaySalary();
        f1.calculateSalary();

        System.out.println();

        InternEmployee i1 = new InternEmployee(20000);
        i1.displaySalary();
        i1.calculateSalary();
    }
}
