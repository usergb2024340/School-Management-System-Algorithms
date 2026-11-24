/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author user
 */


public enum Department {
    ADMINISTRATION("Administration"),
    IT("IT"),
    HR("HR"),
    FINANCE("Finance"),
    TEACHING("Teaching");

    private final String label;

    Department(String label) { this.label = label; }

    public String getLabel() { return label; }

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
