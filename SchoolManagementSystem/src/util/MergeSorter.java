/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.ArrayList;
import java.util.List;
import model.Employee;

public class MergeSorter {

    // Returns a new list sorted A-Z by name. The original list was adapted to the school.
    public static List<Employee> sort(List<Employee> list) {
        // Base case: 0 or 1 items are already sorted
        if (list.size() <= 1) {
            return new ArrayList<>(list);
        }

        int middle = list.size() / 2;
        List<Employee> left = sort(list.subList(0, middle));
        List<Employee> right = sort(list.subList(middle, list.size()));

        return merge(left, right);
    }

    private static List<Employee> merge(List<Employee> left, List<Employee> right) {
        List<Employee> result = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < left.size() && j < right.size()) {
            // <= keeps equal names in their original order (stable)
            if (left.get(i).getName().compareToIgnoreCase(right.get(j).getName()) <= 0) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        // One side may still have items left over
        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }
}