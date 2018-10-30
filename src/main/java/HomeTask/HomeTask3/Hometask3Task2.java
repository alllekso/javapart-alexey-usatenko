//2) Напишите программу, которая:
//	- считывает строку
//	- выводит исходную строку
//	- выводит количество и список, которые заканчиваются буквами 'ED'
package HomeTask.HomeTask3;


import java.util.Scanner;

public class Hometask3Task2 {
    static String myString = stream();

    public static void main(String[] args) {
        System.out.print("Вы ввели строку: ");
        stream();
        count();


    }

    private static void count() {
        int number = 0;
        for (int i = 0; i < myString.split(" ").length; i++) {
            number = number + 1;
        }
    }

    private static String stream() {
        Scanner scan = new Scanner((System.in));
        System.out.println("Введите несколько слов. Некоторые слова должны содержать окончание \"-ed\"");
        String input = scan.nextLine();
        return input;
    }

}
