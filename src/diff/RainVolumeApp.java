package diff;

/**
 *               _ _
 *              |7 7|_
 *   _          |    6|
 *  |5|         |     |
 *  | |  _      |     |
 * _| | |3|  _  |     |
 * 2  |_| |_|2|_|     |
 * ____1___1___1______|
 * 0 1 2 3 4 5 6 7 8 9
 *
 * volume == 17: between 5(1-index) and 7(7-index)
 */
public class RainVolumeApp {
    public static void main(String[] args) {
        int[] surface = {2,5,1,3,1,2,1,7,7,6};
        //int[] surface = {0,1,4,6,6,5,3}; // volume == 0, one peak
        System.out.println(volume(surface));
    }

    public static int volume(int[] surface) {
        int volume = 0;
        int leftMax = 0, rightMax = 0;
        int left = 0;
        int right = surface.length - 1;

        while (left < right) {
            if (surface[left] > leftMax) {
                leftMax = surface[left];
            }
            if (surface[right] > rightMax) {
                rightMax = surface[right];
            }

            if (leftMax >= rightMax) {
                volume += rightMax - surface[right];
                right--;
            } else {
                volume += leftMax - surface[left];
                left++;
            }
        }

        return volume;
    }
}
