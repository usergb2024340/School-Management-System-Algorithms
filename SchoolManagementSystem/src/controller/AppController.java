/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.List;
import model.Employee;
import util.BinarySearcher;
import util.FileLoader;
import util.MergeSorter;
import view.ConsoleView;
import view.MenuOption;

public class AppController {

    private final ConsoleView view = new ConsoleView();
    private List<Employee> employees;
    private List<Employee> sortedEmployees;

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
                    break;
                case CREATE_BINARY_TREE:
                    view.showMessage("CREATE A BINARY TREE selected");
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
}