/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;
import model.Task;

/**
 *
 * @author dattn
 */
public class Main {

    public static void main(String[] args) {
        View_Task view = new View_Task();
        while (true) {
            Scanner sc = new Scanner(System.in);
            displayMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    view.displayAddTask();
                    break;
                case 2:
                    view.displayTaskList();
                    break;
                case 3:
                    view.displayRemoveList();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }

        }
    }

    private static void displayMenu() {
        System.out.println("\t\t\t\tMENU\n"
                + "1. Add\n"
                + "2. Display\n"
                + "3. Remove\n");
    }
}
