package HomeTask.lesson9;

public interface Time {

    void setTime(int hours, int minutes, int seconds);

    String getTime(TimeFormat timeFormat);
}