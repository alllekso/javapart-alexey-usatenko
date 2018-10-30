package HomeTask.HomeTask2;
//Написать программу ввода с клавиатуры последовательно 3 чисел. Вывести минимальное максимальное и средние значения
import java.util.OptionalDouble;
import java.util.Arrays;
import java.util.Scanner;

public class Hometask2Task1 {
    public static void main(String[] args) {
        System.out.println("Введите 3 числа:");
        Scanner scan = new Scanner(System.in);
        int[] tab = new int[3];
        for (int i = 0; i < 3; i++)
            tab[i] = scan.nextInt();
        int min = Arrays.stream(tab).min().getAsInt();
        int max = Arrays.stream(tab).max().getAsInt();
        OptionalDouble avg = Arrays.stream(tab).average();
        System.out.println("Min = " + min);
        System.out.println("Max = " + max);
        System.out.println("Avg = " + avg.getAsDouble());
}
}

