package diff;

/**
 * The minute hand moves 360 degree in 60 minute (or 6 degree in one minute)
 * and hour hand moves 360 degree in 12 hours (or 0.5 degree in 1 minute).
 *
 * In h hours and m minutes, the minute hand would move (h*60 + m)*6 and hour hand would move (h*60 + m)*0.5.
 */

public class HourMinuteAngle {
    public static void main(String[] args) {
        System.out.printf("%d \n", calcAngle(9, 60));
        System.out.printf("%d \n", calcAngle(3, 30));
    }

    static int calcAngle(int h, int m) {
        if (h < 0 || h > 12 || m < 0 || m > 60)
            throw new IllegalArgumentException();

        if (h == 12) h = 0;
        if (m == 60) m = 0;

        double hourAngle = (h * 60 + m) * 0.5;
        double minuteAngle = 6 * m;

        int angle = (int) Math.abs(hourAngle - minuteAngle);
        angle = Math.min(360 - angle, angle);

        return angle;
    }
}
