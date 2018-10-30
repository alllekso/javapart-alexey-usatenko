package HomeTask.HomeTask2;
import java.util.Scanner;
//Релизовать программу возведения числа в квадрат

public class Hometask2Task2 {
    public static void main(String[] args) {
        System.out.println("Введите число:");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        System.out.println("Введите число для возведения в степень:");
        int b = scan.nextInt();
        double c = Math.pow(a, b);
        System.out.printf("Результат возведения числа %d в степень %d равен: ",  a, b);
        System.out.print(c);
    }
}
