/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ManageFruit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.Fruit;
import model.Order;

/**
 *
 * @author dattn
 */
public class ViewFruit {

    ManageFruit manage = new ManageFruit();

    void displayCreate() {
        while (true) {
            String id = getId();

            if (manage.getDuplicateId(id)) {
                System.out.println("You have Duplicate");
                if (!manage.checkContinue("Do you want to continue (Y/N)?", "y", Validate.REGEX_YN, "Must be Y/N")) {
                    manage.displayListFuit(manage.getListFruit());
                    break;
                }
            } else {
                String name = getName();
                double price = getPrice();
                int quantity = getQuantity();
                String origin = getOrigin();
                manage.addFruit(id, name, price, quantity, origin);
                if (!manage.checkContinue("Do you want to continue (Y/N)?", "y", Validate.REGEX_YN, "Must be Y/N")) {
                    manage.displayListFuit(manage.getListFruit());
                    break;
                }
            }
        }

    }

    void displayOrder() {
        ArrayList<Order> listOrder = manage.getListOrder();
        if (listOrder.isEmpty()) {
            System.out.println("No Order Have Been Created!");
        }

        Collections.sort(listOrder, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return Double.compare(o1.getTotal(), o2.getTotal());
            }
        });

        //else display all orders
        for (Order order : listOrder) {
            System.out.println("Customer: " + order.getCustomer());
            manage.displayListOrderedFruit(order.getListFruitOrder());
            System.out.printf("Total: %s$\n", order.getTotal());
            System.out.println("");
        }
    }

    private String getId() {
        String id = Validate.getString("Enter your id: ", "Wrong!!!!", Validate.REGEX_STRING);
        return id;
    }

    private String getName() {
        String name = Validate.getString("Enter your name: ", "Must be String", Validate.REGEX_STRING);
        return name;
    }

    private double getPrice() {
        double price = Validate.getDouble("Enter your price: ", "Wrong", "Wrong", "Must be digit", 0, Double.MAX_VALUE);
        return price;
    }

    private int getQuantity() {
        int quantity = Validate.getInt("Enter your quantity: ", "Wrong", "Wrong", "Must be digit", 0, Integer.MAX_VALUE);
        return quantity;
    }

    private String getOrigin() {
        String origin = Validate.getString("Enter your origin: ", "Must be String", Validate.REGEX_STRING);
        return origin;
    }

    void displayShopping() {
        Order order = new Order();

        //check if the shop still have fruit or not
        if (manage.getListFruit().isEmpty()) {
            System.out.println("NO FRUITS HAVE BEEN IMPORTED YET!");
            return;
        }
        while (true) {
            //display all fruit in the shop
            manage.displayListFuit(manage.getListFruit());
            Fruit pickedFruit;
            //loop until user get fruit they want
            while (true) {
                String id = getId();
                pickedFruit = manage.getFruitByID(id);
                if (pickedFruit == null) {
                    System.out.println("Not a valid fruit id!");
                } else {
                    //display selected fruit name
                    System.out.println("You selected: " + pickedFruit.getName());
                    break;
                }
            }
            //allow user to enter number of fruit they want to order
            int orderQuantity;
            while (true) {
                orderQuantity = getQuantity();
                //print out a message if the number of fruit they order bigger than the remaining
                if (orderQuantity > pickedFruit.getQuantity()) {
                    System.out.println("We only have " + pickedFruit.getQuantity() + " left!");
                } else {
                    break;
                }
            }

            //create an ordered fruit to add to the order list later
            Fruit orderedFruit = new Fruit();
            orderedFruit.setId(pickedFruit.getId());
            orderedFruit.setName(pickedFruit.getName());
            orderedFruit.setOrigin(pickedFruit.getOrigin());
            orderedFruit.setQuantity(orderQuantity);
            orderedFruit.setPrice(pickedFruit.getPrice());

            //set remaining quantity of a fruit after user ordered
            pickedFruit.setQuantity(pickedFruit.getQuantity() - orderQuantity);

            //if a fruit have nothing left means there nothing to order
            //then we gonna delete that fruit in the list
            if (pickedFruit.getQuantity() == 0) {
                manage.removeFruit(pickedFruit);
            }

            //add a fruit to the customer order
            //control.addFruitToOrder(orderedFruit, order);
            order.addFruitToOrder(orderedFruit);
            //ask user if they want to continue to shopping or not
            //if yes, continue to shop else stop
            boolean isCheck = manage.checkContinue("Do you want to order now (Y/N)", "y", Validate.REGEX_YN, "Must be y Or n");
            if (isCheck) {
                break;
            }
            //if all product were bought, display message
            if (manage.getListFruit().isEmpty()) {
                System.out.println("SOLD OUT!");
                break;
            }
        }

        //display user order after they finish shopping
        manage.displayListOrderedFruit(order.getListFruitOrder());
        //display total price
        System.out.println("Total: " + order.getTotal() + "$");
        String customerName = Validate.getString("Input your name: ", "Wrong", Validate.REGEX_STRING);
        //set customer name
        order.setCustomer(customerName);
        //add an order to the list after all required information is entered
        manage.addOrder(order);
        System.out.println("Order Successful!");
    }
}
