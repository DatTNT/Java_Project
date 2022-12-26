/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dattn
 */
public class EastAsiaCoutry extends Country{
    private String terrain;
    
    /**
     * construction no para
     */
    public EastAsiaCoutry() {
    }
    
    /**
     * extend function Country
     * @param terrain
     * @param countryCode
     * @param countryName
     * @param area 
     */
    public EastAsiaCoutry( String countryCode, String countryName, float area,String terrain) {
        super(countryCode, countryName, area);
        this.terrain = terrain;
    }

    @Override
    public void display() {
        System.out.format("%-15s %-15s %-10s %-10s\n", "ID", "Name", "Area", "Terrain");
    }
    
    
    
}
