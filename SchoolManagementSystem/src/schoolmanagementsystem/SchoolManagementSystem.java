/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package schoolmanagementsystem;

import model.Department;
import model.Employee;
import model.ManagerType;

public class SchoolManagementSystem {

    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("FIRST STEPS CLINICAL SCHOOL");
        System.out.println("EMPLOYEE MANAGEMENT");
        System.out.println("=================================");

        // Temporary test of the model
        Employee test = new Employee("Test Person", ManagerType.TEACHER, Department.TEACHING);
        System.out.println(test);
    }
}
