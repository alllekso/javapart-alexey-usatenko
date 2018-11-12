package HomeTask.HomeTask7;

public class DateTest {
    public static void main(String[] args) {
        Date testDate = new Date(31, 12, 1980);
        //Изменить установленный день
        testDate.setDay(30);
        //Изменить установленный год
//        testDate.setYear(1970);
        System.out.println("Set date: " + testDate);
        int a = 1, b = 12, c = 1988;
        //Проверить дату на валиднность
        Date falseDate = new Date(a, b, c);
        System.out.print("Check date: " + falseDate + " - ");
        System.out.println(falseDate.CheckDate(a, b, c));
        //Вытащить день из даты
        System.out.print("Get Day: ");
        System.out.println(testDate.getDay());
        //Отобразить завтрашний день
        System.out.print("Next day: ");
        System.out.println(testDate.nextDay());
        System.out.print("Next Month: ");
        System.out.println(testDate.nextMonth());
        //Отобразить след год
        System.out.print("Next Year: ");
        System.out.println(testDate.nextYear());
        //Добавить дни к текущему дню
        System.out.print("Add days to current day: ");
        System.out.println(testDate);
        testDate.addDays(370);

        testDate.printDatе(testDate);
//        System.out.println(300%31);

    }


}