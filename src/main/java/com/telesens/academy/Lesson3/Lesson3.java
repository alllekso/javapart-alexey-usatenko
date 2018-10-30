package com.telesens.academy.Lesson3;

import java.util.Scanner;

public class Lesson3 {

    public static void main(String[] args) {
        System.out.println("Enter int");
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
            System.out.println(array[i]);
        }
    }
}