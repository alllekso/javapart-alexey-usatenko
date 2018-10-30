//В переменной n хранится натуральное двузначное число.
// Создайте программу, вычисляющую и выводящую на экран сумму цифр числа n.
package HomeTask.HomeTask2;

import java.util.Scanner;

public class Hometask2Task8and9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите двузначное натуральное число:");
        int n = scan.nextInt();
        System.out.println("Cумма цифр двузначного числа равна: " + (n/10 + n%10));

        //В переменной n хранится натуральное трёхзначное число.
        //	Создайте программу, вычисляющую и выводящую на экран сумму цифр числа n.
        System.out.println("Введите трёхзначное натуральное число:");
        int m = scan.nextInt();
        System.out.print("Cумма цифр трёхзначного числа равна: " + (m/100 + (m/10)%10 + m%10));
    }
}
