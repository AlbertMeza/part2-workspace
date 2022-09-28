/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import com.javatunes.billing.EuropeTax;
import com.javatunes.billing.Location;
import com.javatunes.billing.OnlineTax;
import com.javatunes.billing.USATax;
import java.util.Collection;

public class Order {
  private String id;
  private Location location;
  private double totalCost; //= processCart();
  public Order(String id, Location location) {
    this.id = id;
    this.location = location;
  }
  
  /**
   * DONE:
   * get the items from the cart and iterate over them, print each item's product code
   * get cart total and print
   */
  public void processCart(ShoppingCart<? extends Product> cart) {
    System.out.println("Order: " + getId() + " contains the following:");
    
    Collection<? extends Product> cartItems = cart.allItems();
    for (Product product : cartItems) {
      System.out.println(product.getCode());
    }
    totalCost = cart.total();
    System.out.println("Order Total: " + totalCost);
  }
  
  public String getId() {
    return id;
  }

  public double getTaxes(){
    double taxes =0;
    switch(getLocation()){
      case USA:
        USATax usa = new USATax();
        taxes = usa.taxAmount(getTotalCost());
        break;
      case EUROPE:
        EuropeTax eu = new EuropeTax();
        taxes = eu.taxAmount(getTotalCost());
        break;
      case ONLINE:
        OnlineTax online = new OnlineTax();
        taxes = online.taxAmount(getTotalCost());
        break;
      default:
        break;
    }
    return taxes;
  }

  public double getTotalCost() {
    return totalCost;
  }

  public Location getLocation() {
    return location;
  }
}