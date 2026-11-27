/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Department;
import model.Employee;
import model.EmployeeTree;
import model.ManagerType;
import util.BinarySearcher;
import util.FileLoader;
import util.MergeSorter;
import view.ConsoleView;
import view.MenuOption;

public class AppController {

    private static final int TREE_SIZE = 20;

    private final ConsoleView view = new ConsoleView();
    private List<Employee> employees;
    private List<Employee> sortedEmployees;
    private final List<Employee> newRecords = new ArrayList<>();

    public void run() {
        view.showBanner();
        loadEmployees();

        boolean running = true;
        while (running) {
            view.showMenu();
            MenuOption choice = view.readMenuChoice();

            switch (choice) {
                case SORT:
                    view.showMessage("SORT selected");
                    sortedEmployees = MergeSorter.sort(employees);
                    view.showMessage("First 20 names in alphabetical order:");
                    view.showEmployees(sortedEmployees, 20);
                    break;
                case SEARCH: {
                    view.showMessage("SEARCH selected");
                    ensureSorted();
                    String name = view.askName();
                    Employee found = BinarySearcher.search(sortedEmployees, name);
                    view.showSearchResult(found, name);
                    break;
                }
                case ADD_RECORDS:
                    view.showMessage("ADD RECORDS selected");
                    addRecord();
                    break;
                case CREATE_BINARY_TREE:
                    view.showMessage("CREATE A BINARY TREE selected");
                    buildAndShowTree();
                    break;
                case EXIT:
                    view.showMessage("Goodbye!");
                    running = false;
                    break;
            }
        }
    }

    // Keeps asking for a filename until the file is read successfully
    private void loadEmployees() {
        while (employees == null) {
            String filename = view.askFilename();
            try {
                employees = FileLoader.load(filename);
                view.showMessage("File read successfully");
            } catch (IOException e) {
                view.showMessage("Could not read file: " + e.getMessage());
            }
        }
    }

    // The search needs a sorted list, so sort first if the user hasn't yet
    private void ensureSorted() {
        if (sortedEmployees == null) {
            sortedEmployees = MergeSorter.sort(employees);
        }
    }

    // Asks for a new employee, validates the choices and stores the record in memory
    private void addRecord() {
        String name = view.askNewName();

        if (nameExists(name)) {
            view.showMessage("An employee with that name already exists. Record not added.");
            return;
        }

        ManagerType managerType = view.askManagerType();
        Department department = view.askDepartment();

        Employee employee = new Employee(name, managerType, department);
        employees.add(employee);
        newRecords.add(employee);

        // Keep the sorted list up to date so the search still works
        sortedEmployees = MergeSorter.sort(employees);

        view.showMessage("Record added successfully.");
        view.showNewRecords(newRecords);
    }

    private boolean nameExists(String name) {
        for (Employee e : employees) {
            if (e.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    // Builds the hierarchy tree from TREE_SIZE employees, most senior first,
    // inserting them level by level, then shows the result
    private void buildAndShowTree() {
        if (employees.size() < TREE_SIZE) {
            view.showMessage("At least " + TREE_SIZE + " records are needed to build the tree.");
            return;
        }

        EmployeeTree tree = new EmployeeTree();
        int inserted = 0;

        // ManagerType.values() is in rank order: Principal first, Staff last
        for (ManagerType type : ManagerType.values()) {
            for (Employee e : employees) {
                if (e.getManagerType() == type && inserted < TREE_SIZE) {
                    tree.insert(e);
                    inserted++;
                }
            }
        }

        view.showTree(tree.levelOrder(), tree.height(), tree.size());
    }
}