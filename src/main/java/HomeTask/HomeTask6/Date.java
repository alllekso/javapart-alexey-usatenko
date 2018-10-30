//5)* Создать класс Date, который имеет следующие поля:
//		- день
//		- месяц
//		- год
//
//		Все поля должны быть помечены модификатором private
//		- реализовать доступ к полям через методы set и get
//		-* реализовать статический метод checkData(int day, int month, int year), который проверяет существование введенной даты
//		-* использовать проверку checkData, при попытке изменить поле метод set, в случае ошибки не проводить изменение,
//			а вывести сообщение об ошибке на консоль
//		-** реализовать метод differenceIdDays(int day, int month, int year), который принимает другую дату и вычисляет разницу в
//			днях между датами
//		- протестировать работу методов
package HomeTask.HomeTask6;

public class Date {
    private int day;
    private int month;
    private int year;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public void printDate(){
        System.out.println(String.format("Дата: " +
                "день " + day + ", месяц " + month + ", год " + year));
    }
    public void differenceIdDays(Date compare){
        int range = (this.day+(this.year/4) + this.month*30 + this.year*365) - (compare.day+(compare.year/4) + compare.month*30 + compare.year*365);
        System.out.printf("Разница между %d.%d.%d и %d.%d.%d составляет: %d дней.\n", compare.day,compare.month,compare.year,this.day,this.month,this.year,range);

    }

}
