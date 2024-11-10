package overloadChallenge;

public class secondsAndMinutesChallenge {
    public static void main(String[] args) {
        System.out.println(getDurationString(65, 1));
        System.out.println(getDurationString(50));
    }

    public static String getDurationString(int seconds) {
        String result = "";
        if (seconds >= 0) {
            result = getDurationString(0, seconds);
        }
        return result;
    }

    public static String getDurationString(int minutes, int seconds) {
        String sendBack = "";
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