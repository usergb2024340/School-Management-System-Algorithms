/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.List;
import model.Employee;

public class BinarySearcher {

    // Looks for a person by full name in a list sorted A-Z.
    // Returns the Employee, or null if not found.
    public static Employee search(List<Employee> sortedList, String name) {
        return search(sortedList, name.trim(), 0, sortedList.size() - 1);
    }

    private static Employee search(List<Employee> list, String name, int low, int high) {
        // Base case: nothing left to search, so the name is not in the list
        if (low > high) {
            return null;
        }

        int middle = low + (high - low) / 2;
        int comparison = name.compareToIgnoreCase(list.get(middle).getName());

        if (comparison == 0) {
            return list.get(middle);                      // found it
        } else if (comparison < 0) {
            return search(list, name, low, middle - 1);   // look in the left half
        } else {
            return search(list, name, middle + 1, high);  // look in the right half
        }
    }
}