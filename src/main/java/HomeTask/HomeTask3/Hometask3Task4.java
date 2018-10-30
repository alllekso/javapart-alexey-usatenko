/*4) Реализовать программу, которая:
        - считывает с клавиатуры строку
        - удаляет из строки все цифры
        - выводит исходную строку
        - выводит преобразованную строку
        - выводит список удаленных символов*/
package HomeTask.HomeTask3;

import java.util.Scanner;

public class Hometask3Task4 {

    public static void main(String[] args) {
        System.out.println("Введите строку из букв и целых чисел:");
        String str = inputString();
        fullString(str);
        noNumbers(str);
        onlyNumbers(str);
    }

    public static String inputString() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
    public static void fullString(String str) {
        System.out.println("Вся строка: " + str);
    }

        public static void noNumbers(String str) {
        System.out.println("Только буквы:");
//        System.out.println(str.replaceAll("[0-9]", ""));
        System.out.println(str.replaceAll("\\d", ""));
    }

    public static void onlyNumbers(String str) {
        System.out.println("Только числа:");

//        System.out.println(str.replaceAll("[^A-Za-z]", ""));
        System.out.println(str.replaceAll("\\D", ""));
    }
}