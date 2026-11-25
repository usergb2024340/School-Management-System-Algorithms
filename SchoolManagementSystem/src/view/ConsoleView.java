/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import java.util.Scanner;
import model.Employee;

public class ConsoleView {

    private final Scanner scanner = new Scanner(System.in);

    public void showBanner() {
        System.out.println("=================================");
        System.out.println("FIRST STEPS CLINICAL SCHOOL");
        System.out.println("EMPLOYEE MANAGEMENT");
        System.out.println("=================================");
    }

    public String askFilename() {
        System.out.print("Please enter the filename to read: ");
        return scanner.nextLine().trim();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showEmployees(List<Employee> list, int limit) {
        int count = Math.min(limit, list.size());
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + list.get(i).getName());
        }
    }
    public String askName() {
        System.out.print("Enter the full name to search for: ");
        return scanner.nextLine().trim();
    }

    public void showSearchResult(Employee employee, String searchedName) {
        if (employee == null) {
            System.out.println("No employee found with the name: " + searchedName);
        } else {
            System.out.println("Employee found:");
            System.out.println("Name:         " + employee.getName());
            System.out.println("Manager Type: " + employee.getManagerType());
            System.out.println("Department:   " + employee.getDepartment());
        }
    }
    public void showMenu() {
        System.out.println();
        System.out.println("Do You wish to SORT or SEARCH:");
        for (MenuOption option : MenuOption.values()) {
            System.out.println(option.getNumber() + ".  " + option.getLabel());
        }
    }

    public MenuOption readMenuChoice() {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                MenuOption option = MenuOption.fromNumber(Integer.parseInt(input));
                if (option != null) {
                    return option;
                }
            } catch (NumberFormatException e) {
                // not a number, fall through to the error message below
            }
            System.out.println("Invalid choice. Please enter a number between 1 and "
                    + MenuOption.values().length + ".");
        }
    }
}