package com.telesens.academy.lesson15;

import com.telesens.academy.automationpractice.model.EntityDress;
import com.telesens.academy.lesson10.CompareDresses;

import java.util.Arrays;
import java.util.Comparator;

        public class StreamPractice {
            public static void main(String[] args) {
                EntityDress[] dresses = CompareDresses.getExpectedDresses();
//
//        Arrays.stream(dresses)
//                .peek(System.out::println)
//                .filter(c->c.getColor().equals("Orange"))
//                .reduce(StreamPractice::maxByPrice)
//                .ifPresent(System.out::println);

                Double[] result = Arrays.stream(dresses)
                        .map(EntityDress::getPrice)
                        .sorted(Comparator.reverseOrder())
                        .peek(System.out::println)
                        .toArray(Double[]::new);

            }
    private static EntityDress maxByPrice( EntityDress e1, EntityDress e2){
        if (e1.getPrice() > e2.getPrice())
            return e1;
        else return e2;
    }
}