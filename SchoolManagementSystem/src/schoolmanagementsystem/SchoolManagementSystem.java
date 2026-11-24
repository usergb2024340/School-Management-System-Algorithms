/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package schoolmanagementsystem;

import java.io.IOException;
import java.util.List;
import model.Employee;
import util.FileLoader;

public class SchoolManagementSystem {

    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("FIRST STEPS CLINICAL SCHOOL");
        System.out.println("EMPLOYEE MANAGEMENT");
        System.out.println("=================================");

        // Temporary test (will be replaced by the controller in commit 5)
        try {
            List<Employee> list = FileLoader.load("Applicants_Form.txt");
            System.out.println("File read successfully: " + list.size() + " records");
            System.out.println(list.get(2)); // James Anderson
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
    }
}