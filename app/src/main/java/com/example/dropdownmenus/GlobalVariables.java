package com.example.dropdownmenus;

import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class GlobalVariables {

    public static List<Product> getProducts() {

        //Dairy - 6 items
        Product egg = new Product("Eggs", 10, 1.8);
        Product milk = new Product("Milk", 1, 1.25);
        Product butter = new Product("Butter", 250, 2.0);
        Product yogurt = new Product("Yogurt", 450, 1.0);
        Product feta = new Product("Feta", 1, 1);

        //Fruits - 6 items
        Product banana = new Product("Banana", 1, 1.0);
        Product peach = new Product("Peach", 7, 4.0);
        Product lemon = new Product("Lemon", 1, 1);
        Product apple = new Product("Apple", 6, 3.5);
        Product tomato = new Product("Tomato", 7, 1);
        Product pear = new Product("Pear", 6, 3.75);

        //Vegetables - 6 items
        Product broccoli = new Product("Broccoli", 1, 1);
        Product carrot = new Product("Broccoli", 1, 1);
        Product avocado = new Product("Avocado", 1, 1.25);
        Product cucumber = new Product("Cucumber", 1, 1.5);
        Product onion = new Product("Onion", 1, 1.1);
        Product pepper = new Product("Pepper", 1, 1.5);

        //Meat - 7 items
        Product beef = new Product("Beef", 350, 11);
        Product chicken_breast = new Product("Chicken Breast", 350, 10);
        Product chicken_leg = new Product("Chicken Leg", 350, 4);
        Product mince_meat = new Product("Minced Meat", 350, 6);
        Product pork_fillet = new Product("Pork", 350, 6.5);
        Product whole_chicken = new Product("Whole Chicken", 1, 8);
        Product tofu = new Product("Tofu", 350, 4);

        ArrayList<Product> food_prices = new ArrayList<>();
        food_prices.add(egg);
        food_prices.add(milk);
        food_prices.add(butter);
        food_prices.add(yogurt);
        food_prices.add(feta);
        food_prices.add(banana);
        food_prices.add(peach);
        food_prices.add(lemon);
        food_prices.add(apple);
        food_prices.add(tomato);
        food_prices.add(pear);
        food_prices.add(broccoli);
        food_prices.add(carrot);
        food_prices.add(avocado);
        food_prices.add(cucumber);
        food_prices.add(onion);
        food_prices.add(pepper);
        food_prices.add(beef);
        food_prices.add(chicken_breast);
        food_prices.add(chicken_leg);
        food_prices.add(mince_meat);
        food_prices.add(pork_fillet);
        food_prices.add(whole_chicken);
        food_prices.add(tofu);

        return food_prices;
    }



}
