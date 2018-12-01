package diff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestKPoints {
    public static void main(String[] args) {

        List<List<Integer>> l = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(1, -1));

        List<List<Integer>> r = nearestXsteakHouses(3, l, 2);
        for (List<Integer> s : r) {
            System.out.println(s.get(0) + ", " + s.get(1));
        }
    }

    static List<List<Integer>> nearestXsteakHouses(int totalSteakhouses,
                                            List<List<Integer>> allLocations,
                                            int numSteakhouses)
    {
        if (numSteakhouses < 1) {
            return new ArrayList<>();
        }

        PriorityQueue<List<Integer>> closest = new PriorityQueue<>(numSteakhouses, pointsComparator().reversed());

        for (int i = 0; i < totalSteakhouses; i++) {
            List<Integer> steakPoint = allLocations.get(i);
            if (closest.size() < numSteakhouses) {
                closest.add(steakPoint);
            } else {
                List<Integer> closestTop = closest.peek();
                double topDistance = distanceTo(closestTop.get(0), closestTop.get(1));
                double currentDistance = distanceTo(steakPoint.get(0), steakPoint.get(1));
                if (topDistance > currentDistance) {
                    closest.poll();
                    closest.add(steakPoint);
                }
            }
        }

        return new ArrayList<>(closest);
    }

    private static Comparator<List<Integer>> pointsComparator() {
        return new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                double firstDistance = distanceTo(o1.get(0), o1.get(1));
                double secondDistance = distanceTo(o2.get(0), o2.get(1));
                if (firstDistance < secondDistance) {
                    return -1;
                } else if (firstDistance > secondDistance) {
                    return 1;
                }
                return 0;
            }
        };
    }

    private static double distanceTo(int x, int y) {
        return Math.sqrt(x*x + y*y);
    }
}
