//	b)  Написать функцию boolean testCurrencyFormat(String regexFormat);
//			- которая тестирует регулярку на заданных выше примерах
//			- возвращает  true, если все тесты прошли корректно, false - иначе
package HomeTask.HomeTask5;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexBoolean {

    public static void main(String[] args) {
        result();

    }

    private static String result() {
        String regex = "[А-Я].*[.]";
        String str = "В лесу родилась елочка," +
                "в лесу она росла." +
                "Зимой и летом стройная" +
                "Зеленая была.";
        Pattern pattern = Pattern.compile(regex);
        boolean result1 = pattern.matcher(str).matches();
        boolean result2 = Pattern.matches(regex, str);

        System.out.println("Result1: " + result1);
        System.out.println("Result2: " + result2);
        return result();
    }

    public static int select() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите 1 или 2: ");
        int inputString = scan.nextInt();
        return inputString;

    }
}
