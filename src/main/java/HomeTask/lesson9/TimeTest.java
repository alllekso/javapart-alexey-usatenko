package HomeTask.lesson9;

public class TimeTest {
    public static void main(String[] args) {
//        TimeImpl time = new TimeImpl();
//        time.setTime(13, 23, 21);
//        System.out.println(time.getTime(TIME_FORMAT_24));
//        System.out.println(time.getTime(TIME_FORMAT_12));
//
//        Time timeSimple = new TimeImpl();
//        timeSimple.setTime(12, 14, 33);
//        System.out.println(timeSimple.getTime(TIME_FORMAT_24));
//        System.out.println(timeSimple.getTime(TIME_FORMAT_12));

//        Time timeSeconds = new TimeImplSeconds();
//        timeSeconds.setTime(14, 17, 30);
//        System.out.println(timeSeconds.getTime(TIME_FORMAT_24));
//        System.out.println(timeSeconds.getTime(TIME_FORMAT_12));
//        System.out.println("Test exeptions: ");
//        //TEST exeptions
//        try{
//            time.setHours(24);
//        }catch (InvalidTimeCheck invalidTimeCheck){
//            System.out.println("Invalid hours format. ");
//        }
        try {
            TimeImpl time1 = new TimeImpl(64, 60, 60);
            System.out.println(time1);
        } catch (InvalidTimeCheck constructorCheck) {
            System.out.println("invalid constructor");
        }


    }

}