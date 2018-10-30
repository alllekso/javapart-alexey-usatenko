//Сила тяжести на Луне составляет около 17% земной. Напишите программу, которая вычислила бы ваш вес на Луне
package HomeTask.HomeTask2;
import java.util.Scanner;

public class Hometask2Task5 {
    public static void main(String[] args) {
        System.out.println("Введите ваш вес на планете Земля:");
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        System.out.printf("Ваш вес на Лунен равен: %.2f", x*0.17);
    }
}
