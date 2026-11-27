/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import java.util.Scanner;
import model.Department;
import model.Employee;
import model.ManagerType;

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

    // ---------- Adding new records ----------

    public String askNewName() {
        while (true) {
            System.out.print("Enter the new employee's full name: ");
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                return name;
            }
            System.out.println("Name cannot be empty.");
        }
    }

    public ManagerType askManagerType() {
        ManagerType[] types = ManagerType.values();
        while (true) {
            System.out.println("Choose a Manager Type:");
            for (int i = 0; i < types.length; i++) {
                System.out.println((i + 1) + ". " + types[i]);
            }
            System.out.print("Enter the number or the name: ");
            String input = scanner.nextLine().trim();

            ManagerType selected = null;
            try {
                int number = Integer.parseInt(input);
                if (number >= 1 && number <= types.length) {
                    selected = types[number - 1];
                }
            } catch (NumberFormatException e) {
                selected = ManagerType.fromString(input);
            }

            if (selected != null) {
                return selected;
            }
            System.out.println("Invalid Manager Type. Please choose one from the list.");
        }
    }

    public Department askDepartment() {
        Department[] departments = Department.values();
        while (true) {
            System.out.println("Choose a Department:");
            for (int i = 0; i < departments.length; i++) {
                System.out.println((i + 1) + ". " + departments[i]);
            }
            System.out.print("Enter the number or the name: ");
            String input = scanner.nextLine().trim();

            Department selected = null;
            try {
                int number = Integer.parseInt(input);
                if (number >= 1 && number <= departments.length) {
                    selected = departments[number - 1];
                }
            } catch (NumberFormatException e) {
                selected = Department.fromString(input);
            }

            if (selected != null) {
                return selected;
            }
            System.out.println("Invalid Department. Please choose one from the list.");
        }
    }

    public void showNewRecords(List<Employee> newRecords) {
        System.out.println("New records added so far:");
        for (int i = 0; i < newRecords.size(); i++) {
            System.out.println((i + 1) + ". " + newRecords.get(i));
        }
    }

    // ---------- Binary tree ----------

    public void showTree(List<List<Employee>> levels, int height, int nodeCount) {
        System.out.println("Employee hierarchy (level order):");
        for (int i = 0; i < levels.size(); i++) {
            System.out.println("Level " + (i + 1) + ":");
            for (Employee employee : levels.get(i)) {
                System.out.println("   " + employee);
            }
        }
        System.out.println();
        System.out.println("Tree height: " + height + " levels");
        System.out.println("Total nodes: " + nodeCount);
    }

    // ---------- Menu ----------

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