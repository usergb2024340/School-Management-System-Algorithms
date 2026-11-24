/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Department;
import model.Employee;
import model.ManagerType;

public class FileLoader {

    public static List<Employee> load(String filename) throws IOException {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            reader.readLine(); // skip the header line
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                Employee e = parseLine(line);
                if (e != null) {
                    employees.add(e);
                }
            }
        }
        return employees;
    }

    private static Employee parseLine(String line) {
        String[] parts = line.split(",", -1); // -1 keeps empty fields

        if (parts.length < 8) {
            System.out.println("Skipping invalid line: " + line);
            return null;
        }

        // Normal rows have 9 fields
        String name = parts[0].trim() + " " + parts[1].trim();
        String departmentText = parts[5];
        String position = (parts.length == 9) ? parts[6].trim() : "";
        String jobTitle = parts[parts.length - 2].trim();

        Department department = Department.fromString(departmentText);
        if (department == null) {
            System.out.println("Skipping line, unknown department: " + line);
            return null;
        }

        return new Employee(name, deriveManagerType(jobTitle, position), department);
    }

    private static ManagerType deriveManagerType(String jobTitle, String position) {
        if (jobTitle.equalsIgnoreCase("Principal")) return ManagerType.PRINCIPAL;
        if (jobTitle.equalsIgnoreCase("Vice Principal")) return ManagerType.VICE_PRINCIPAL;
        if (jobTitle.equalsIgnoreCase("Head of Department")) return ManagerType.HEAD_OF_DEPARTMENT;
        if (jobTitle.equalsIgnoreCase("Team Lead")) return ManagerType.TEAM_LEAD;
        return ManagerType.STAFF;
    }
}