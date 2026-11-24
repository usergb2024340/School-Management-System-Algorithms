/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

public enum Department {
    ADMISSIONS("Admissions"),
    FINANCE("Finance"),
    HUMAN_RESOURCES("Human Resources"),
    IT("IT Department"),
    MARKETING("Marketing and Communications"),
    OPERATIONS("School Operations"),
    STUDENT_SERVICES("Student Services");

    private final String label;

    Department(String label) { this.label = label; }

    public String getLabel() { return label; }

    // Returns null if the text doesn't match any department
    public static Department fromString(String text) {
        for (Department d : values()) {
            if (d.label.equalsIgnoreCase(text.trim()) || d.name().equalsIgnoreCase(text.trim())) {
                return d;
            }
        }
        return null;
    }

    @Override
    public String toString() { return label; }
}