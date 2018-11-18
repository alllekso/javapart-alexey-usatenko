package HomeTask.lesson9;


public class TimeImpl implements Time {

    private int hours;
    private int minutes;
    private int seconds;

    public TimeImpl() {
    }

    @Override
    public void setTime(int hours, int minutes, int seconds) {

        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public TimeImpl(int hours, int minutes, int seconds) throws InvalidTimeCheck {
        if (hours > 24 || minutes > 60 || seconds > 60) {
            throw new InvalidTimeCheck();
        }
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public String getTime(TimeFormat timeFormat) {
        String formattedTime = hours + ":" + minutes + ":" + seconds;
        switch (timeFormat) {
            case TIME_FORMAT_24:
                formattedTime = hours + ":" + minutes + ":" + seconds;
                break;
            case TIME_FORMAT_12:
                if (hours > 11 && hours != 12 && hours != 24) {
                    formattedTime = hours % 12 + ":" + minutes + ":" + seconds + " pm";
                } else if (hours == 12) {
                    formattedTime = hours + ":" + minutes + ":" + seconds + " pm";
                } else if (hours == 24) {
                    formattedTime = 00 + ":" + minutes + ":" + seconds + " am";
                } else {
                    formattedTime = hours + ":" + minutes + ":" + seconds + " am";
                }
                break;
        }
        return formattedTime;
    }

    public void setHours(int hours) throws InvalidTimeCheck {
        if (hours > 24) {
            throw new InvalidTimeCheck();
        }
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}