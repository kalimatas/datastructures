package diff;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPointsApp {
    public static void main(String[] args) {
        Point[] points = {
            new Point(3, 3),
            new Point(2, 1),
            new Point(1, 2),
            new Point(1, 1),
        };

        displayPoints(points);
        Arrays.sort(points, new CompareByX());
        displayPoints(points);
    }

    static void displayPoints(Point[] points) {
        for (Point p : points) {
            System.out.printf("(%d, %d) ", p.x, p.y);
        }
        System.out.println();
    }

    private static class Point {
        Integer x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class CompareByX implements Comparator<Point> {
        @Override
        public int compare(Point p1, Point p2) {
            int cmpX = p1.x.compareTo(p2.x);
            int cmpY = p1.y.compareTo(p2.y);

            if (cmpX < 0 || cmpX == 0 && cmpY < 0)
                return -1;
            else if (cmpX == 0 && cmpY == 0)
                return 0;
            else
                return 1;
        }
    }

    private static class ClosestPoints {
        private Point[] points;
        private double solution = Double.MAX_VALUE;

        ClosestPoints(Point[] points) {
            this.points = points;
        }

        double getClosestPointsDistance() {
            // reset solution
            solution = Double.MAX_VALUE;

            // sort points by x coordinate
            Arrays.sort(points, new CompareByX());

            calculateMinDistance(0, points.length - 1);

            return solution;

        }

        private void calculateMinDistance(int l, int r) {

        }

        private double getDistance(Point p1, Point p2) {
            return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
        }
    }
}
