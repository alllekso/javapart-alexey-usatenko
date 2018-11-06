package com.telesens.academy.lesson10;

import com.telesens.academy.automationpractice.model.EntityDress;

import java.util.Arrays;

public class SortDemo {
    public static void main(String[] args) {
        EntityDress[] actualDresses = getActualDresses();
        System.out.println(Arrays.toString(actualDresses));
        Arrays.sort(actualDresses);
        System.out.println(Arrays.toString(actualDresses));
    }

    private static EntityDress[] getActualDresses() {
        return new EntityDress[]{
                new EntityDress()
                        .withModel("demo_3")
                        .withName("Printed Dress")
                        .withColor("Orange")
                        .withSize("S")
                        .withPrice(26.00),

                new EntityDress()
                        .withModel("demo_4")
                        .withName("Printed Dress")
                        .withColor("Beige")
                        .withSize("S")
                        .withPrice(50.99),

                new EntityDress()
                        .withModel("demo_1")
                        .withName("Faded Short Sleeve T-shirts")
                        .withColor("Orange")
                        .withSize("S")
                        .withPrice(16.51),

                new EntityDress()
                        .withModel("demo_5")
                        .withName("Printed Summer Dress")
                        .withColor("Yellow")
                        .withSize("S")
                        .withPrice(28.98),
        };
    }
}
