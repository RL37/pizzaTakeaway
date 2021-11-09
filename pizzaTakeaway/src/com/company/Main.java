package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean valid       = false;
        boolean validSize   = false;

        ArrayList<String> toppingsList = new ArrayList<>();

        //pizza variables
        final double pizzaSmall   =  7.90;
        final double pizzaMedium  = 10.99;
        final double pizzaLarge   = 13.99;
        final double toppingCost  =  1.25;
        double       totalCost    =  0;

        while (valid == false) {

            //gets size of pizza
            String pizzaSize = null;
            while (validSize == false) {
                System.out.println("What size of pizza do you want (small, medium, large) :");
                pizzaSize = input.next();
                if (pizzaSize.equals("small") || pizzaSize.equals("medium") || pizzaSize.equals("large")) {
                    if (pizzaSize.equals("small")) {
                        totalCost = totalCost + pizzaSmall;
                    }
                    if (pizzaSize.equals("medium")) {
                        totalCost = totalCost + pizzaMedium;
                    }
                    if (pizzaSize.equals("Large")) {
                        totalCost = totalCost + pizzaLarge;
                    }
                    validSize = true;
                } else {
                    System.out.println("enter a designated pizza size");
                }
            }

            //gets the amount of toppings
            System.out.println("you get 2 free toppings \nyou can then pay an additional " + toppingCost + " for each topping after");
            int toppingsAmount = 2;
            int count = 0;
            for (int i = 0; i < toppingsAmount; i++) {
                try {
                    System.out.println("What topping do you want:");
                    String toppings = input.next();
                    toppingsList.add(i, toppings);
                    count++;
                    if (count >= 2) {
                        System.out.println("How many paid extra toppings do you want");
                        int extraToppings = input.nextInt();
                        toppingsAmount = toppingsAmount + extraToppings;
                        totalCost = totalCost + toppingCost * extraToppings;
                        count = -99999999;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Enter the number of toppings you want " + e);
                } catch (Exception e) {
                    System.out.println("There has been an error " + e);
                }
            }
            valid = true;
            System.out.println("Your total cost is £" + totalCost);
            System.out.println("Of your order of a " + pizzaSize + " with the toppings");
            for (int i = 0; i < toppingsAmount; i++) {
                System.out.print(" "+ toppingsList.get(i) + ",");
            }
        }
    }
}