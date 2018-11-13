/*2) Сгенерировать массив 100 абонентов:
        - id возрастает для каждого следующего абонента (необязательно последовательно)
        - со случайными именами и фамилиями (брать из подготовленного массива данных)
        - возраст от 18 до 60 лет
        - телефонный номер заполнить по следующему правилу (задача была на предыдущих занятиях):
        - 10 цифр
        - первый три цифры 999,
        - последняя 0 или 5
        - остальные цифры - любые*/
package HomeTask.lesson15;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Stream;

public class SubscriberDemo {
    public static void main(String[] args) {
        Subscriber subscriber = new Subscriber();
        Subscriber[] subsArray = new Subscriber[100];
        Stream.generate(()->new Random().nextInt())
                .limit(10)
                .forEach(System.out::println);




        System.out.println(Arrays.toString(subsArray));
    }
}
