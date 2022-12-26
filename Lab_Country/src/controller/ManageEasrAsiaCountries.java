/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.EastAsiaCoutry;

/**
 *
 * @author dattn
 */
public class ManageEasrAsiaCountries {

    ArrayList<EastAsiaCoutry> countryList;

    public ManageEasrAsiaCountries() {
        countryList = new ArrayList<>();
//        countryList.add( new EastAsiaCoutry("VN", "Vietnam", 12, "sadasd"));
//        countryList.add( new EastAsiaCoutry("Indo", "Indo", 12, "sadasd"));
//        countryList.add( new EastAsiaCoutry("LAO", "LAO", 12, "sadasd"));
    }

    

    public ArrayList<EastAsiaCoutry> getCountryList() {
        return countryList;
    }

    /**
     * add new data in countryList
     * @param country 
     */
    public void addCountry(EastAsiaCoutry country) {
        countryList.add(country);
    }

    //Found Name Country
    public ArrayList<EastAsiaCoutry> findCountry(String name) {
        ArrayList<EastAsiaCoutry> countryFound = new ArrayList<>();
        for (EastAsiaCoutry eastAsiaCoutry : countryList) {
            if(eastAsiaCoutry.getCountryName().toLowerCase().contains(name)){
                //add to countryFound
                countryFound.add(eastAsiaCoutry);
            }
        }
        return countryFound;
    }

 

    public ArrayList<EastAsiaCoutry> SortList(ArrayList<EastAsiaCoutry> listSort) {
        Collections.sort(listSort, new Comparator<EastAsiaCoutry>() {
            @Override
            public int compare(EastAsiaCoutry o1, EastAsiaCoutry o2) {
                return o1.getCountryName().compareToIgnoreCase(o2.getCountryName());
            }
        });
        return listSort;
    }

   
    
}
