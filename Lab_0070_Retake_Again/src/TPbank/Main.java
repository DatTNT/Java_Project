/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TPbank;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author dattn
 */
public class Main {

    public static void main(String[] args) {
        Ebank ebank = new Ebank();
        Scanner sc = new Scanner(System.in);
        ManageEBank manage = new ManageEBank();
        while (true) {
            displayMenu();
            int choice = ebank.getInt("Enter your choice: ", "Choice must be 1 - 4", "Choice must be 1 - 4", "Choice must be digit", 1, 4);
            Locale VietNam = new Locale("vn");
            Locale English = new Locale("en");
            switch (choice) {
                case 1:
                    ebank.setBundle(VietNam);
                    manage.getAction(ebank);
                    break;
                case 2:
                    ebank.setBundle(English);
                    manage.getAction(ebank);
                    break;
                case 3:
                    System.exit(0);
                    break;

            }

        }
    }

    private static void displayMenu() {
        System.out.println("-------Login Program-------\n "
                + "1. Vietnamese\n "
                + "2. English\n "
                + "3. Exit Please");
    }

 
}
