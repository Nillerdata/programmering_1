package overloadChallenge;

public class secondsAndMinutesChallenge {
    public static void main(String[] args) {
        System.out.println(getDurationString(65, 1));
        System.out.println(getDurationString(50));
    }

    public static String getDurationString(int seconds) {
        int minutes = seconds/60;
        String result = "";
        if (seconds >= 0) {
            result = getDurationString(seconds / 60, seconds % 60);
        }else System.out.println("indtast valid int");
        return result;
    }

    public static String getDurationString(int minutes, int seconds) {
        String sendBack;
        if (minutes >= 0 && seconds >= 0 && seconds <= 59) {
            int hours = minutes / 60;
            if (hours > 0) {
                minutes = minutes % 60;
            }
            sendBack = hours + " h " + minutes + " m " + seconds + " s";
        } else sendBack = "indtast validt tal";
        return sendBack;
    }
}
/*
int minutes  = seconds /60;
int hours = minutes / 60;
int remainingMinutes = minutes % 60;
int remainingSeconds = seconds % 60;
return hours + " h " + remainingMinutes + " m " + remainingSeconds + " s "
*/