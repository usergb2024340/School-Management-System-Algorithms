/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

public enum ManagerType {
    PRINCIPAL("Principal"),
    VICE_PRINCIPAL("Vice Principal"),
    HEAD_OF_DEPARTMENT("Head of Department"),
    TEAM_LEAD("Team Lead"),
    STAFF("Staff");

    private final String label;

    ManagerType(String label) { this.label = label; }

    public String getLabel() { return label; }

    // Returns null if the text doesn't match any manager type
    public static ManagerType fromString(String text) {
        for (ManagerType m : values()) {
            if (m.label.equalsIgnoreCase(text.trim()) || m.name().equalsIgnoreCase(text.trim())) {
                return m;
            }
        }
        return null;
    }

    @Override
    public String toString() { return label; }
}