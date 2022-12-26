/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.Country;
import model.EastAsiaCoutry;

/**
 *
 * @author dattn
 */
public class Main {

    public static void main(String[] args) {
        View_Country view = new View_Country();
         EastAsiaCoutry eastAsiaCoutry = null;
        while (true) {
            //Display menu
            displayMenu();
            //User enter option
            int option = Validate.getInt("Enter option: ", "Range of option form 1 to 5", "Range of option form 1 to 5", "Option must be from digit", 1, 5);
            
           
            switch (option) {
                case 1:
                    
                    eastAsiaCoutry = view.displayInputuser();
 
                    break;
                case 2:
                    //Display Country
                    view.displayInfor(eastAsiaCoutry);
                    break;
                case 3:
                    view.displaySearch();
                    break;
                case 4:
                    view.displaySortInfor();
                    break;
                case 5:
                    System.exit(0);
                    break;

            }

        }

    }

    private static void displayMenu() {
        System.out.println("MENU\n"
                + "1. Input\n"
                + "2. Display\n"
                + "3. Search\n"
                + "4. Display sort\n"
                + "5. Exit\n");
    }
}
