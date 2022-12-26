/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author dattn
 */
public class Order {
    private String customer;
    private ArrayList<Fruit> listFruitOrder = new ArrayList<>();

    public Order() {
    }

    public Order(String customer, ArrayList<Fruit> listFruit) {
        this.customer = customer;
        this.listFruitOrder = listFruit;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public ArrayList<Fruit> getListFruitOrder() {
        return listFruitOrder;
    }

    public void setListFruitOrder(ArrayList<Fruit> listFruit) {
        this.listFruitOrder = listFruit;
    }

    
    public double getTotal() {
      double total = 0;
        double temp;
        //loop from the fist fruit to the last fruit in the order list
        for (int i = 0; i < listFruitOrder.size(); i++) {
            //total bill = fruit * quantity
            temp = listFruitOrder.get(i).getPrice() * listFruitOrder.get(i).getQuantity();
            total += temp;
        }
        return total;
        
    }
    
     public Fruit getFruitByID(String id) {
        for (Fruit fruit : listFruitOrder) {
            if (fruit.getId().equalsIgnoreCase(id)) {
                return fruit;
            }
        }
        return null;
    }
     
     
    public void addFruitToOrder(Fruit orderedFruit) {
        //check if the fruit have been order before or not
        Fruit existedFruit = getFruitByID(orderedFruit.getId());
        //if the fruit haven't been order before, add a new fruit in the order list
        //if it's existed in the order, stack the quantity
        if (existedFruit == null) {
          listFruitOrder.add(orderedFruit);
        } else {
            existedFruit.setQuantity(orderedFruit.getQuantity() + existedFruit.getQuantity());
        }
    }
    
}
