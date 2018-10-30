package HomeTask.HomeTask1;
import java.util.Scanner;
//		a) Написать Java программу, которая выводит на консоль следующий текст (в несколько строк):
//			(Для каждого нового предложения использовать отдельный вызов print или println)
//
//			Привет!
//			Это моя первая программа. Я уже пишу на Java.
//			Программировать - это удовольствие.
//			Моя цель - ...

public class Hometask1 {
    public static void main(String[] args) {
        String hello = "Привет! ", introduce = "Это моя первая программа. Я уже пишу на Java";
        String hard = "Программировать - это удовольствиe.";

        System.out.println(hello + introduce);
        System.out.println(hard);
        System.out.println("Моя цель - сдать домашнее задание 01");
        System.out.println("Нажмите любую клавишу для отображения задания №10 и нажмите Enter");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

//		a) Написать Java программу, которая выводит на консоль следующую фигуру:
//			*
//			**
//			***
//			****
//			*****
//			******

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

