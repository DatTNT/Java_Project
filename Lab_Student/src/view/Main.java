/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;
import jdk.nashorn.internal.parser.Lexer;

/**
 *
 * @author dattn
 */
public class Main {

    public static void main(String[] args) {
        ViewStudent view = new ViewStudent();
        Scanner sc = new Scanner(System.in);
        while (true) {
            displayMenu();
            int choice = Validate.getInt("Enter your choice: ", "Number must be 1-5", "Number must be 1-5", "Number must be digit", 1, 5);
            switch (choice) {
                case 1:
                    view.displayCreateStudent();
                    break;
                case 2:
                    view.displayFindAndSortStudent();
                    break;
                case 3:
                    view.displayUpdateAndDelete();
                    break;
                case 4:
                    view.report();
                    break;
                case 5:
                    System.exit(0);
                    break;
                
            }
        }

    }

    private static void displayMenu() {
        System.out.println("\t\t\t\tWELCOME TO STUDENT MANAGEMENT\n"
                + "1. Create\n"
                + "2. Find and Sort\n"
                + "3. Update/Delete\n"
                + "4. Report\n"
                + "5. Exit");
    }
}
