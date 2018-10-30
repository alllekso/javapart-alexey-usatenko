//Заполнить одномерный целочисленный массив значениями от 1 до 10 включительно.
//	Одномерный массив вывести в строку в виде:
//	[3, 4, 9, 10, 1, 2, 8, 10, 3, 1, 7]
package HomeTask.HomeTask2;

import java.util.Arrays;
import java.util.Scanner;

public class Hometask2Task12 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array;
        array = new int[10];
        System.out.println("Введите 10 чисел:");
        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }
        System.out.println(Arrays.toString(array));
    }
}
