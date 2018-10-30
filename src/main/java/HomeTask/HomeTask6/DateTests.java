//5)*
//		-* реализовать статический метод checkData(int day, int month, int year), который проверяет существование введенной даты
//		-* использовать проверку checkData, при попытке изменить поле метод set, в случае ошибки не проводить изменение,
//			а вывести сообщение об ошибке на консоль
//		-** реализовать метод differenceIdDays(int day, int month, int year), который принимает другую дату и вычисляет разницу в
//			днях между датами
//		- протестировать работу методов
package HomeTask.HomeTask6;

import java.util.Scanner;

public class DateTests {
    Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Date someDay = new Date(29,10,2018);
        Date myBirthday = new Date(25,05,1988);
        Date animeClubFoundation = new Date(19,05,2007);
        myBirthday.printDate();
        animeClubFoundation.printDate();
        someDay.printDate();
        someDay.differenceIdDays(myBirthday);
        checkData();
    }
    private static void checkData(){
        Date date = new Date(20, 20, 30);
        int day = date.getDay();
        int month = date.getMonth();
        int year = date.getYear();

        System.out.println(day >= 9);
        System.out.println(month <= 30);
        System.out.println(year <= 9999);
        assert day <= 10;
        assert month == 20;
        assert year == 30;
    }


}

