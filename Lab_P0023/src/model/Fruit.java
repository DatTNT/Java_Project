/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dattn
 */
public class Fruit {
    private String id;
    private String name;
    private double  price;
    private String origin;
    private int quantity;

    public Fruit() {
    }

    public Fruit(String id, String name, double price, String origin, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.origin = origin;
        this.quantity = quantity;
    }

    public double getAmount() {
        return price * quantity;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity > 0){
            this.quantity = quantity;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id != null){
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null){
            this.name = name;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price > 0.0){
            this.price = price;
        }
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        if(origin != null){
            this.origin = origin;
        }
    }

    @Override
    public String toString() {
        return String.format("%-10s%-10s%-10s%-10s", id,name,price,origin,origin);
    }
    
    
}
