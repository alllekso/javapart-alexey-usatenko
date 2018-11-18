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

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
2) Сгенерировать массив 100 абонентов:
		- id возрастает для каждого следующего абонента (необязательно последовательно)
		- со случайными именами и фамилиями (брать из подготовленного массива данных)
		- возраст от 18 до 60 лет
		- телефонный номер заполнить по следующему правилу (задача была на предыдущих занятиях):
			- 10 цифр
			- первый три цифры 999,
			- последняя 0 или 5
			- остальные цифры - любые
 */
public class SubscriberDemo {
    private static String[] firstNames = {"мaша", "Петя", "Вася", "Миша", "Даша", "Катя", "Саша", "Паша"};
    private static String[] lastNames = {"Корженко", "михайленко", "Кузьменко", "Клопотенко", "Половик"};
    private static Random rand =  new Random();
    private static long id = 1L;

    // TODO
    private static String txtFile = "subscribers.txtFile";
    private static String xlsFile = "subscribers.xlsx";

    private static String PROP_NAME = "java-part.properties";

    public static void main(String[] args) {

//        OutputStream os = new FileOutputStream("");
//        OutputStreamWriter osw = new OutputStreamWriter(os);
        Properties prop = new Properties();
        InputStream resourceStream = SubscriberDemo.class.getClassLoader().getResourceAsStream(PROP_NAME);
        try {
            prop.load(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String subscriberFile = prop.getProperty("subscriber.txt");
        try (FileWriter fw = new FileWriter(subscriberFile)) {
            System.out.println("***Generate***");
            Subscriber[] array =
                    Stream
                            .generate(SubscriberDemo::nextSubscriber)
//                .generate(()->SubscriberDemo.nextSubscriber()) // можно так
//                .generate(()->{
//                    return SubscriberDemo.nextSubscriber();
//                }) // можно и так
                            .limit(100)
                            .filter(SubscriberDemo.distinctBy(Subscriber::getPhoneNumber))
                            .peek(System.out::println)
//                            .peek(ConsumerExceptional.wrap(s->fw.write(s.toString())))
                            .peek(s->{
                                try {
                                    fw.write(prepareSubscriber(s)+"\n");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            })
                            .toArray(Subscriber[]::new);
            System.out.println("***Finish***");

            List<Subscriber> list = new ArrayList<>(Arrays.asList(array));

            Arrays.sort(array);
            System.out.println(Arrays.toString(array));

            list.sort(Comparator.comparingInt(Subscriber::getAge));
//        list.sort((s1, s2)-> Integer.compare(s1.getAge(), s2.getAge()));

            System.out.println(list);
//            3) 	Из массива:
//            - исключить дубликаты
//                    - отсортировать по id,
//            - сохранить в список (List


            List uniqueAbonents = list.stream()
                    .distinct()
                    .sorted((i1, i2) -> i2.getId().compareTo(i1.getId()))
                    .peek(System.out::println)
                    .collect(Collectors.toList());

//            4) Из списка абонентов:
//            - отсортировать по телефонному номеру
//                    - отфильтровать по возрасту от 20 до 30
//                    - перевести первый символ имени и фамилии в верхний регистр
//            - перевести все символы кроме первого в нижний регистр
//                    - вывести на консоль
            System.out.println("************");
            list.stream()
                    .sorted(Comparator.comparing(Subscriber::getPhoneNumber))
                    .filter(a -> a.getAge() >= 20 && a.getAge() <= 30)
                    .peek(a -> a.getFirstName().substring(0, 1).toUpperCase())
                    .peek(a -> a.getLastName().substring(0, 1).toUpperCase())
                    .peek(a -> a.getFirstName().substring(1).toLowerCase())
                    .peek(a -> a.getLastName().substring(1).toLowerCase())
                    .forEach(System.out::println);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static Subscriber nextSubscriber() {
        long nextId = id;
//        id = id + rand.nextInt(100);
        id++;
        String firstName = generateFirstName();
        String lastName = generateLastName();
        int age = generateAge();
        String phoneNumber = generatePhoneNumber();
        return new Subscriber(nextId, firstName, lastName, age, phoneNumber);
    }

    public static String generateFirstName(){
        int randomNumber = rand.nextInt(firstNames.length);
        return firstNames [randomNumber];
    }

    public static String generateLastName(){
        int randomNumber = rand.nextInt(lastNames.length);
        return lastNames[randomNumber];
    }

    public static int generateAge(){
        int lowerLimit = 18;
        int upperLimit = 60;
        return rand.nextInt(upperLimit-lowerLimit)+lowerLimit;
    }

    public static String generatePhoneNumber() {
        int firstThreeNumbers = 999;
        int middleDigits = rand.nextInt(1_000_000);

        // 1 способ
        int lastDigit = rand.nextBoolean() ? 0 : 5;

        // 2 способ
//        if (rand.nextBoolean())
//            last = 0;
//        else
//            last = 5;

        long phoneNumber =
                firstThreeNumbers*1_000_0000L + // двигаем влево на 7 разрядов
                        middleDigits*10 + // умножаем на 10, чтобы сдвинуть влево на один разряд
                        lastDigit; // 0 или 5

        return Long.toString(phoneNumber);
    }

    private static <T> Predicate<T> distinctBy(Function<? super T, ?> keyExtractor) {
        final Set<Object> set = new HashSet<>();

        return t -> set.add(keyExtractor.apply(t));
    }
    private static String prepareSubscriber(Subscriber subscriber) {
        return subscriber.getId()+", "+subscriber.getFirstName() + ", " + subscriber.getLastName() + ", " + subscriber.getAge() + subscriber.getPhoneNumber();
    }


}