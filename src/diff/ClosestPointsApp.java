package diff;

import java.util.*;

public class ClosestPointsApp {
    public static void main(String[] args) {
        List<Point> points = new ArrayList<Point>(
            Arrays.asList(
//            new Point(20, 15),
//            new Point(10, 10),
//            new Point(20, 10)
            new Point(2, 3),
            new Point(12, 30),
            new Point(40, 50),
            new Point(5, 1),
            new Point(12, 10),
            new Point(3, 4)
            )
        );

        displayPoints(points);

        System.out.printf("min distance: %.2f%n", new ClosestPoints().getClosest(points));
    }

    static void displayPoints(List<Point> points) {
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

        double distanceTo(Point p) {
            return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
        }
    }

    private static class CompareByX implements Comparator<Point> {
        @Override
        public int compare(Point p1, Point p2) {
            return p1.x.compareTo(p2.x);
        }
    }

    private static class CompareByY implements Comparator<Point> {
        @Override
        public int compare(Point p1, Point p2) {
            return p1.y.compareTo(p2.y);
        }
    }

    private static class ClosestPoints {
        double getClosest(List<Point> points) {
            List<Point> px = new ArrayList<>();
            List<Point> py = new ArrayList<>();

            px.addAll(points);
            py.addAll(points);

            Collections.sort(px, new CompareByX());
            Collections.sort(py, new CompareByY());

            return getClosestUtil(px, py);
        }

        private double getClosestUtil(List<Point> px, List<Point> py) {
            // Few points, use brute force
            if (px.size() <= 3) {
                return getClosestBruceForce(px, Double.MAX_VALUE);
            }

            int mid = px.size() / 2;
            Point midPoint = px.get(mid);

            // Divide py around the vertical line
            List<Point> pyl = new ArrayList<>();
            List<Point> pyr = new ArrayList<>();

            for (Point point : px) {
                if (point.x <= midPoint.x)
                    pyl.add(point);
                else
                    pyr.add(point);
            }

            // Calculate the smallest distance in both halves
            List<Point> pxl = px.subList(0, mid + 1);
            List<Point> pxr = px.subList(mid, px.size());

            double dl = getClosestUtil(pxl, pyl);
            double dr = getClosestUtil(pxr, pyr);

            // Smaller of two distances
            double min = Math.min(dl, dr);

            // todo: use py
            List<Point> strip = new ArrayList<>();
            for (Point point : pyr) {
                if (point.x - midPoint.x < min)
                    strip.add(point);
            }

            return Math.min(min, getClosestBruceForce(strip, min));
        }

        private double getClosestBruceForce(List<Point> points, double currentMin) {
            double min = currentMin;

            for (int i = 0; i < points.size(); ++i) {
                for (int j = i + 1; j < points.size() && points.get(j).y - points.get(i).y < min; ++j) {
                    min = Math.min(min, points.get(i).distanceTo(points.get(j)));
                }
            }

            return min;
        }
    }
}
