package com.question1;

import java.util.ArrayList;

/**
 * public class created DishDesignImplementation to use different type of Dishes designing
 */
public class DishDesignImplementation {

    public int dishId;
    public String dName;
    public double creationTime;

    public DishDesignImplementation(int dishId, String dName, double creationTime) {

        // 3-arguments parameterized constructor

        super();
        this.dishId = dishId;
        this.dName = dName;
        this.creationTime = creationTime;

    }

    /**
     * override toString() method
     * @return this associated to return new Dish with their id, name and preparation time
     */
    @Override
    public String toString() {
        return "dish_prepared[dishId=" + dishId
                + ", dishName=" + dName
                + ", dishPreparation_Time =" + creationTime
                + "]";
    }
    // main class
    public static void main(String[] args) {

        // ArrayList object to store dish records
        ArrayList<DishDesignImplementation> dish_Records = new ArrayList<DishDesignImplementation>();

        // add dish records to all objects
        dish_Records.add(new DishDesignImplementation(141, "Biryani", 11));
        dish_Records.add(new DishDesignImplementation(152, "Polao", 20 ));
        dish_Records.add(new DishDesignImplementation(103, "Ice Cream", 10.50));
        dish_Records.add(new DishDesignImplementation(104, "Palak-paneer", 20.5));
        dish_Records.add(new DishDesignImplementation(105, "Samosha", 45));

        // retrieving employee records using enhanced forEach loop
        for (DishDesignImplementation dish : dish_Records) {
            System.out.println(dish);
        }
    }
}

