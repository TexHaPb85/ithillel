package edu.ithillel.generics;

import edu.ithillel._common.food.Apple;
import edu.ithillel._common.food.Banana;
import edu.ithillel._common.food.Fruit;

import java.util.ArrayList;
import java.util.List;

/**
 * using <? extends Fruit> wildcard we get read-only object which inner T type cannot be changed but can be read
 */
public class CollectionWildCardExample {
    public static void main(String[] args) {

        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Apple());
        fruits.add(new Banana());
        fruits.add(new Fruit());
        Apple fruit = (Apple)fruits.get(0);

        List<? super Fruit> fruits2 = fruits;
//        fruits.add(new Food());

        GenericContainer<? extends Fruit> frt = new GenericContainer<>();
        Fruit inputType = frt.getInputType();
//        frt.setInputType(new Apple());
//        frt.setInputType(new Banana());
//        frt.setInputType(new Fruit());
//        frt.setInputType(new Food());

        System.out.println(fruits);
    }

    private static void addElementToList(List<? extends Fruit> list, Fruit element) {
        //list.get(0).
        //list.add(element);
        list.add(null);
    }
}
