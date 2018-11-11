package com.telesens.academy.lesson14.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaDemo {
    public static void main(String[] args) {
        String str = "Hello World";
        String res = doSomethingWithString(str, s->s.toUpperCase());
        String res2 = doSomethingWithString(str, String::toLowerCase);
        System.out.println(res);
        System.out.println(res2);

        String[] straka = {"aest 1", "zez", "bestATest", "hello test!", "tZrue"};
        List<String> newListStr = new ArrayList<>(Arrays.asList(straka));
        newListStr.sort((d1, d2)-> {

            if (d1.length() > d2.length()) {
                return 1;
            }
            else if (d1.length() < d2.length())
                return -1;
            else return 0;

        });
        System.out.println(newListStr);




        boolean isInRange = checkNumber(10, num -> num >= 10 && num <= 20);
        System.out.println(isInRange);
//        LambdaDemo lambdaDemo = new LambdaDemo();
//        String resNext = lambdaDemo.doSomethingWithStringNoStatic(str);
    }

    private static String doSomethingWithString(String str, Function<String, String> operation) {
        return operation.apply(str);
    }

    private static boolean checkNumber(int number, Predicate<Integer> checker) {
        return checker.test(number);

    }

    private String doSomethingWithStringNoStatic(String str) {
        return null;
    }
}