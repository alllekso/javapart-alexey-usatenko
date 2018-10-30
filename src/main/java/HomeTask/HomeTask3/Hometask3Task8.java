//Реализовать программу, которая:
//	- в диалоговом режиме запрашивает размер массива
//	- заполняет массив случайными числами (целые числа)
//	- меняет порядок элементов массива
//	- сортирует массив
//	- выводит исходный массив
//	- выводит перевернутый массив
//	- выводит отсортированный массив
package HomeTask.HomeTask3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hometask3Task8 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateArray()));
    }

    public static int inputArraySize() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public static int[] generateArray() {
        int[] array = new int[inputArraySize()];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(99);
        }
        return array;
    }
}


