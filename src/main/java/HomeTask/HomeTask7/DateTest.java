package HomeTask.HomeTask7;

public class DateTest {
    public static void main(String[] args) {
        Date testDate = new Date(1, 1, 1970);

        testDate.setDay(25);
        testDate.setYear(1988);
        System.out.println("Set date: " + testDate);
        int a = 1, b = 12, c = 1925;
        Date falseDate = new Date(a, b, c);
        System.out.print("Check date: " + falseDate + " - ");
        System.out.println(falseDate.CheckDate(a, b, c));
        System.out.print("Get Day: ");
        System.out.println(testDate.getDay());
        System.out.print("Next day: ");
        System.out.println(testDate.nextDay());
        System.out.print("Next Year: ");
        System.out.println(testDate.nextYear());
        System.out.print("Add days to current day: ");
        System.out.println(testDate.addDays(9));

    }
}