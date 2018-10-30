package HomeTask.HomeTask2;

import java.util.Scanner;

public class Hometask2Task7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число №1");
        int q = scan.nextInt();
        System.out.println("Введите число №2");
        int w = scan.nextInt();
        System.out.printf("Результат деления числа %d на %d равен: %d и %d в остатке", q, w, q/w, q%w);
    }
}
