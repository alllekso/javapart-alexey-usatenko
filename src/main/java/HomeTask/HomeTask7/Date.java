package HomeTask.HomeTask7;
//1) a) Создать класс Date, который имеет следующие поля:
//		- день
//		- месяц
//		- год
//
//		Все поля должны быть помечены модификатором private
//		- реализовать конструкторы:
//			по умолчанию public Date() // инициировать 1 января 1970
//			который инициализирует все поля public Date(int day, int month, int year)
//			конструктор копирования public Date(Date date)
//
//		- реализовать возможность установки нового значения времени с помощью методов:
//			set(int day, int month, int year);
//			set(Date date);
//			в первом случае проверять корректность полей: day, month, year
//
//		- реализовать методы:
//			int getDay();
//			int getMonth();
//			int getYear();
//				которые возвращают день, месяц и год, соответственно
//
//		-* реализовать методы:
//			String getDayOfWeek();
//				который возвращает день недели: пн, вт, ср и тд.
//			int getWeekOfYear();
//				которые вычисляет номер недели в году
//
//		- реализовать методы:
//			nextDay();
//			nextMonth();
//			nextYear();
//			которые увеличивают на единицу значение дня, месяца и года соответственно
//
//		-* реализовать метод addDays(int days);
//			который добавляет кол-во дней 'days' к текущей дате
//
//		-* реализовать метод checkData(int day, int month, int year), который проверяет существование введенной даты
//		-* использовать проверку checkData в конструкторах при создании класса и при попытке изменить поле методом set,
//		в случае ошибки не проводить изменение, а вывести сообщение на консоль
//		-** реализовать метод differenceInDays(int day, int month, int year), который принимает другую дату и вычисляет в
//			днях между датами
//
//		- переопределить метод toString();
//			который возвратит строковое представление даты: 25.01.2017
//		- переопределить метод equals(Object obj) и hashCode() // использовать автогенерацию
//		- реализовать метод printData();
//			который выводит дату в форматированном виде, напр. 25.01.2017
public class Date {
    private int Day;
    private int Month;
    private int Year;

    public Date(int day, int month, int year) {
        this.Day = day;
        this.Month = month;
        this.Year = year;
    }

    public int getDay() {
        return Day;
    }

    public void setDay(int day) {
        Day = day;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int month) {
        Month = month;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;

    }

    @Override
    public String toString() {
        return "Date{" +
                "Day: " + Day +
                ", Month: " + Month +
                ", Year: " + Year +
                '}';
    }

    public boolean CheckDate(int day, int month, int year) {
        if (day > 0 && day < 31) {
            this.setDay(day);
        } else return false;
        if (month > 0 && month < 13) {
            this.setDay(month);
        } else return false;

        if (year > 1970 && year < 2020) {
            this.setDay(year);
        } else return false;

        return true;
    }
    public int nextDay() {
        int nextDay;
        if (Day <= 31){
            nextDay = Day + 1;
        }
        else {
            nextDay = 1;
        }
        return nextDay;
    }

    public int nextMonth() {
        int nextMonth;
        if (Month <= 12){
            nextMonth = Month + 1;
        }
        else {
            nextMonth = 1;
        }
        return nextMonth;
    }

    public int nextYear() {
        int nextYear;
        nextYear = Year + 1;
        return nextYear;
    }
    public Date addDays(int daysAmount) {
        Date date = new Date(Day, Month, Year);
        int newDay = Day + daysAmount;
        if (newDay > 31){
            Day = (Day + daysAmount) - 31;
            Month = nextMonth();
            if (Month > 12){
                Year = nextYear();
            }
        }
        return date;
    }
}