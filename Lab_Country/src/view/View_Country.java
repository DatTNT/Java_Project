/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ManageEasrAsiaCountries;
import java.util.ArrayList;
import model.Country;
import model.EastAsiaCoutry;

/**
 *
 * @author dattn
 */
public class View_Country {

    ManageEasrAsiaCountries manage = new ManageEasrAsiaCountries();

    EastAsiaCoutry displayInputuser() {
        //check size of list (11 country)
        if (manage.getCountryList().size() == 11) {
            System.out.println("Enough Country !! cannot add anymore !!");
           
        }

        String code, name, terrain;
        float area;

        while (true) {
            code = Validate.getString("Enter code of Country: ", "Code must be letter", Validate.REGEX_CODE);
            //check duplicate
            if (checkDuplicateCode(code)) {
                System.out.println("CODE IS DUPLICATE");
            } else {
                break;
            }

        }
        while (true) {
            name = Validate.getString("Enter name of Country: ", "Code must be letter", Validate.REGEX_CODE);;
            //check duplicate
            if (checkDuplicateName(name)) {
                System.out.println("NAME IS DUPLICATE");
            } else {
                break;
            }

        }

        area = Validate.getFloat("Enter area", "Area must be greater than 0", "Area must be greater than 0", "Area must be float number", 0, Float.MAX_VALUE);
        terrain = Validate.getString("Enter terrain of Country: ", "Terrain must be letter", Validate.REGEX_TERRAIN);

        EastAsiaCoutry eastAsiaCoutry = new EastAsiaCoutry(code, name, area, terrain);
        manage.addCountry(eastAsiaCoutry);

        System.out.println("Add Success!!!");
        
        return eastAsiaCoutry;
        
    }

    void displayInfor(EastAsiaCoutry eastAsiaCoutry) {
//        EastAsiaCoutry country = manage.getCountryList().get(manage.getCountryList().size() - 1);

        System.out.format("%-15s %-15s %-10s %-10s\n", "ID", "Name", "Area", "Terrain");
        
        eastAsiaCoutry.display();
    }

    void displaySearch() {
        ArrayList<EastAsiaCoutry> countryFound = new ArrayList<>();
        //input name
        String name = Validate.getString("Enter name of Country: ", "Code must be letter", Validate.REGEX_CODE);;
        name = name.toLowerCase();

        //find country
        countryFound = manage.findCountry(name);

        //check country
        if (countryFound.isEmpty()) {
            System.out.println("Not FOUND!!!!");
        } else {
            System.out.format("%-15s %-15s %-10s %-10s\n", "ID", "Name", "Area", "Terrain");
            for (EastAsiaCoutry eastAsiaCoutry : countryFound) {
                eastAsiaCoutry.display();
            }
        }

    }

    void displaySortInfor() {
        //Check size
        if (manage.getCountryList().isEmpty()) {
            System.out.println("Not FOUND!!!!");
            return;
        }
        
        //listSort
        ArrayList<EastAsiaCoutry> listSort = new ArrayList<>();
        
        //add add element in countryList
        listSort.addAll(manage.getCountryList());
        
        //sorting
        listSort = manage.SortList(listSort);
        
        //display
        System.out.format("%-15s %-15s %-10s %-10s\n", "ID", "Name", "Area", "Terrain");
            for (EastAsiaCoutry eastAsiaCoutry : listSort) {
                eastAsiaCoutry.display();
            }
        
    }

    /**
     * Check duplicate code
     *
     * @param code
     * @return true: any country have code false: no country have code
     */
    private boolean checkDuplicateCode(String code) {
        for (EastAsiaCoutry eastAsiaCoutry : manage.getCountryList()) {
            if (eastAsiaCoutry.getCountryCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check duplicate name
     *
     * @param code
     * @return true: any country have name false: no country have name
     */
    private boolean checkDuplicateName(String name) {
        for (EastAsiaCoutry eastAsiaCoutry : manage.getCountryList()) {
            if (eastAsiaCoutry.getCountryName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

}
