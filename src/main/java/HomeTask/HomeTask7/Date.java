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

        if (CheckDate(day, month, year)) {
            this.Day = day;
            this.Month = month;
            this.Year = year;
        } else System.out.println("You created Date in wrong format: ");
        this.Day = day;
        this.Month = month;
        this.Year = year;
    }

    public int getDay() {
        return Day;
    }

    public void setDay(int day) {

        if (CheckDate(day, Month, Year)){
        this.Day = day;
    } else {
        System.out.printf("You set wrong day: %d\n" +
                "Please, change back Day to valid range:\n", day);
        this.Day = day;
    }
}

    public int getMonth() {
        return Month;
    }

    public void setMonth(int month) {
        if (CheckDate(Day, month, Year)){
            this.Month = month;
        } else {
            System.out.printf("You set wrong month: %d\n" +
                    "Please, change back Month to valid range:\n", month);
            this.Month = month;
        }
    }

    public int getYear() {
        return Year;
    }
//ЕСЛИ Я УСТАНАВЛИВАЮ НЕВЕРНЫЙ ГОД - МНЕ ВЫСВЕЧИВАЕТСЯ ОШИБКА:
    //"You set wrong year: %d\n" + "Please, change back Year to valid range:\n", year
    // И МНЕ НЕ ВЫСВЕЧИВАЕТСЯ ОШИБКА О НЕВЕРНОМ ДНЕ, Т.К. ДЕНЬ ВЕРНЫЙ.
    // НО ЕСЛИ Я УСТАНАВЛИВАЮ НЕВЕРНЫЙ ДЕНЬ, ТО МНЕ ПРИХОДИТ ОШИБКА И О НЕВЕРНОМ ДНЕ, И О НЕВЕРНОМ ГОДЕ

    public void setYear(int year) {
        if (CheckDate(Day, Month, year)){
            this.Year = year;
        } else {
            System.out.printf("You set wrong year: %d\n" +
                    "Please, change back Year to valid range:\n", year);
            this.Year = year;
        }
    }

    @Override
    public String toString() {
        return "Date{" + Day + "." + Month + "." + Year +
                '}';
    }

    public boolean CheckDate(int day, int month, int year) {
        if (day > 0 && day <= 31) {
            this.Day = day;
        } else return false;
        if (month > 0 && month < 13) {
            this.Month = month;
        } else return false;

        if (year >= 1970 && year <= 2020) {
                this.Year = year;
        } else return false;

        return true;
    }
    public int nextDay() {
        int nextDay = Day + 1;
        nextDay = nextDay % 31;
        if (nextDay == 0){
            nextDay = 1;
        }
        return nextDay;
    }

    public int nextMonth() {
        int nextMonth = Month + 1;
        nextMonth = nextMonth % 12;
        if (nextMonth == 0){
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
        if (Day + daysAmount > 31) {
            for (int d = 0; d < daysAmount; d++){
                Day = nextDay();
                if ((Day == 31) && (d < (daysAmount - 1))) {
                    Month = nextMonth();
                    if ((Month == 12)){
                        Year = nextYear();
                    }
                }
            }
        } else Day = Day + daysAmount;
        return new Date(Day, Month, Year);
    }


    public void printDatе(Date date){
        System.out.println(date.toString());
    }
}