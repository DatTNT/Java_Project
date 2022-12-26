/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.*;

import view.Validate;

/**
 *
 * @author dattn
 */
public class ManageFruit {

    ArrayList<Fruit> listFruit;
    ArrayList<Order> listOrder;

    public ManageFruit() {
        listFruit = new ArrayList<>();
        listOrder = new ArrayList<>();
    }

    public ArrayList<Order> getListOrder() {
        return listOrder;
    }

    public ArrayList<Fruit> getListFruit() {
        return listFruit;
    }


    
    //check duplicate id 
    public boolean getDuplicateId(String id) {
        for (Fruit fruit : listFruit) {
            if(fruit.getId().equalsIgnoreCase(id)){
                return true;
            }
        }
        return false;
    }

    public boolean checkContinue(String mess, String inputCheck, String regex, String error) {
        String inputValue = Validate.getString(mess,error ,regex);
        if(inputValue.equalsIgnoreCase(inputCheck)){
            return true;
        }
        return false;
    }

    public void displayListFuit(ArrayList<Fruit> listFruit) {
        System.out.format("%-10s%10s%10s%10s\n", "ID","Name","Quantity","Origin");
        for (Fruit fruit : listFruit) {
            System.out.println(fruit);
        }
    }

    public void addFruit(String id, String name, double price, int quantity, String origin) {
        Fruit fruit = new Fruit(id, name, price, origin, quantity);
        listFruit.add(fruit);
        System.out.println("Add Success!!!!");
    }


    public void displayListOrderedFruit(ArrayList<Fruit> listFruitOrder) {
        System.out.printf("%-11s|%-11s|%-11s|%-11s\n", "Product", "Quantity", "Price", "Amount");
        for (int i = 1; i <= listFruitOrder.size(); i++) {
            System.out.printf("%-12s%-12s%-12s%-12s\n", +i + "." + listFruitOrder.get(i - 1).getName(),
                    listFruitOrder.get(i - 1).getQuantity(),
                    listFruitOrder.get(i - 1).getPrice() + "$",
                    listFruitOrder.get(i - 1).getAmount() + "$");
        }
    
    
    }

    public Fruit getFruitByID(String id) {
         for (Fruit fruit : listFruit) {
            if (fruit.getId().equalsIgnoreCase(id)) {
                return fruit;
            }
        }
        return null;
    }

    public void removeFruit(Fruit pickedFruit) {
        listFruit.remove(pickedFruit);
    }

    public void addOrder(Order order) {
        listOrder.add(order);
    }

    
    
    
    
}
