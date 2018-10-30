//Создать новый проект/класс.
//
//        Создать метод createArrayDialog, который в диалоговом режиме
//        запрашивает размер массива, все его элементы и возвращает
//        созданный числовой массив
//
//        Создать метод sum, который вычисляет сумму элементов массива
//
//        Создать метод max, который определяет максимальный элемент
//
//        Создать метод countEven, который вычисляет сумму четных элементов
//        массива
//
//        Создать метод printArray, который выводит массив на консоль
//
//        Создать метод printReport, который принимает в качестве аргументов
//        размер массива, сумму, макс, кол-во четных элементов и выводит
//        отчет на консоль:
//
//        Размер: 3
//
//        Сумма: 18
//
//        Максимальный: 10
//
//        Кол-во четных: 2
//
//        Продемонстрировать работу программы (в методe main не должно быть
//        другого кода, кроме вызовов созданных методов)

package com.telesens.academy.Lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class Task1ArrayActions {

    static int[] array = createArrayDialog();

    public static void main(String[] args) {
        printReport(array);
    }

    private static void printReport(int[] array) {
        System.out.print("Вы ввели массив из элементов: ");
        printArray(array);
        System.out.print("Сумма всех чисел массива: ");
        System.out.println(sum(array));
        System.out.print("Максимальное число массива: ");
        System.out.println(max(array));
        System.out.print("Сумма всех чётных чисел массива: ");
        System.out.println(countEvenSum(array));
        System.out.println("Количество чётных чисел в массиве: ");
        System.out.println(countEvenSumNumber(array));
    }

    private static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    //Ввод массима с консоли
    private static int[] createArrayDialog() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int a = scan.nextInt();
        int array[] = new int[a];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Введите " + (i + 1) + "-й элемент массива: ");
            array[i] = scan.nextInt();
        }
        return array;
    }

    //Сумма всех элементов массива
    private static int sum(int[] array) {
        int summa = 0;
        for (int i = 0; i < array.length; i++) {
            summa = summa + array[i];
        }
        return summa;
    }

    //Поиск максимального значения в массиве
    public static int max(int[] array) {
        Arrays.sort(array);
        int maxID = array[array.length - 1];
        return maxID;
    }

    //Сумма всех чётных элементов массива
    private static int countEvenSum(int[] array) {
        int summaChetnix = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                summaChetnix = summaChetnix + array[i];
                count = count + 1;
            }
        }
        return summaChetnix;
    }

    //Количество всех чётных элементов массива
    private static int countEvenSumNumber(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                count = count + 1;
            }
        }
        return count;
    }
}
