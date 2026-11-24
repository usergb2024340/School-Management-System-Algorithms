/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */


public class Employee {
    private final String name;
    private final ManagerType managerType;
    private final Department department;

    public Employee(String name, ManagerType managerType, Department department) {
        this.name = name;
        this.managerType = managerType;
        this.department = department;
    }

    public String getName() { return name; }
    public ManagerType getManagerType() { return managerType; }
    public Department getDepartment() { return department; }

    @Override
    public String toString() {
        return name + " | " + managerType + " | " + department;
    }
}