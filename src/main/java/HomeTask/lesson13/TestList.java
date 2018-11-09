//1) Дан массив имен: {"Peter", "Helen", "Andry", "Abdel", "Kate", "Veronica", "Leonid", "Alex", "max}
//	a) Создать список List из элементов массива и вывести на экран
//	b) Добавить 3 новых имени в список (Philip, Joseph, Leon) и вывести весь список на экран
//	c) Удалить из списка все имена: Veronica, Leonid и вывести на экран
//	d) Поменять имя Helen на Elizabet
//	e) Отсортировать имена по алфавиту и вывести на экран
//	f) Отсортировать имена в обратном порядке и вывести имена на экран
//	g) Перевести все первые символы в верхний регистр
//	h) Вывести все имена, начинающиеся на букву A
//	i) Проверить, содержит ли список имя Andry
//	j) Удалить из списка все имена кроме Kate и Helen
package HomeTask.lesson13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        System.out.print("Original array to List: ");
        String[] array = {"Peter", "Helen", "Andry", "Abdel", "Kate", "Veronica", "Leonid", "Alex", "max"};
        List<String> list = new ArrayList<>();
        list = new ArrayList<>(Arrays.asList(array));
        System.out.println(list);
        System.out.println();
        list.add("Philip");
        list.add("Joseph");
        list.add("Leon");
        System.out.print("Supplemented List: " + list);
        System.out.println();
        list.remove("Veronica");
        list.remove("Leonid");
        System.out.println("Some names removed List: " + list);
        list.set(1, "Elizabet");
        System.out.println("Changed name: " + list);
        list.sort(String::compareTo);
        System.out.println("Sorted List: " + list);
        Collections.sort(list ,Collections.reverseOrder());
        System.out.println("Reversed sort:" + list);
        list.replaceAll(String::toUpperCase);
        System.out.println("First char in upper case" + list);
//Не смог!
    }
}
