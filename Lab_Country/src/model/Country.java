/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dattn
 */
public class Country {
    protected String countryCode;
    protected String countryName;
    protected float area;

    /**
     * constructor no parameter
     */
    public Country() {
    }
    
    /**
     * Constructor have parameter 
     * @param countryCode
     * @param countryName
     * @param area 
     */
    public Country(String countryCode, String countryName, float area) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.area = area;
    }

    public String getCountryCode() {
        return countryCode;
    }
    
    /**
     * check countryCode not empty
     * @param countryCode 
     */
    public void setCountryCode(String countryCode) {
        if(countryCode != null){
            this.countryCode = countryCode;
        }
    }

    public String getCountryName() {
        return countryName;
    }

    /**
     * check countryName not empty
     * @param countryName 
     */
    public void setCountryName(String countryName) {
        if(countryName != null){
            this.countryName = countryName;
        }
    }

    public float getArea() {
        return area;
    }
    
    /**
     * Check area up to 0
     * @param area 
     */
    public void setArea(float area) {
        if (area > 0) {
            this.area = area;
        }
    }
    
    public void display(){
        System.out.format("%-15s %-15s %-10s", countryCode,countryName,area);
    }
    
}
