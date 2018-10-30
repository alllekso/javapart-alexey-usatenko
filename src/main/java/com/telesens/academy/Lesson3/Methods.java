package com.telesens.academy.Lesson3;

import java.util.Scanner;

public class Methods {

    public static void main(String[] args) {
        int max = inputNumber();
        System.out.println(sum(max));
    }

    public static int inputNumber() {
        System.out.println("Введите число больше нуля:");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n <= 0) {
            System.out.println("Введите число больше нуля:");
            n = scan.nextInt();
        }
        return n;
    }
    
    public static int sum(int max) {
        int sum = 0;
        for (int i = 0; i <= max; i++)
            sum = sum + i;
        return  sum;
    }
}
