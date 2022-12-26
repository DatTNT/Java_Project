/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author dattn
 */
public class Main {

    public static void main(String[] args) {
        ViewFruit view = new ViewFruit();
        displayMenu();
        int choice = Validate.getInt("Enter your choice: ", "Must be 1-5", "Must be 1-5", "Must be digit", 1, 4);
        switch (choice) {
            case 1:
                view.displayCreate();
                break;
            case 2:
                view.displayOrder();
                break;
            case 3:
                view.displayShopping();
                break;
            case 4:
                System.exit(0);
                break;

        }
    }

    private static void displayMenu() {
        System.out.println("FRUIT SHOP SYSTEM\n"
                + "1. Create Fruit\n"
                + "2. View orders\n"
                + "3. Shopping (for buyer)\n"
                + "4. Exit");
    }
}
