/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;

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