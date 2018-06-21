package com.eniso.acm.Geometry.BasicGeometryObjectswithLibraries;

import static java.lang.Math.*;

public class GeometryObjects {

    static class Point implements Comparable<Point> {

        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 97 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
            hash = 97 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Point other = (Point) obj;
            if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
                return false;
            }
            if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "Point{" + "x=" + x + ", y=" + y + '}';
        }

        @Override
        public int compareTo(Point o) {
            if (Double.compare(x, o.x) == 0) {
                return Double.compare(y, o.y);
            }
            return Double.compare(x, o.x);
        }

        public static double dist(Point p1, Point p2) {
            return hypot(p1.x - p2.x, p1.y - p2.y);
        }

        public static Point rotate(Point p, double theta) {
            double rad = toRadians(theta);
            return new Point(p.x * cos(rad) - p.y * sin(rad),
                    p.x * sin(rad) + p.y * cos(rad));
        }

    }

    static class Line {

        double a;
        double b;
        double c;

        public Line(Point p1, Point p2) {
            if (Double.compare(p1.x, p2.x) == 0) {
                a = 1.0;
                b = 0.0;
                c = -p1.x;
            } else {
                a = -(p1.y - p2.y) / (p1.x - p2.x);
                b = 1.0;
                c = -(a * p1.x) - p1.y;
            }
        }

        @Override
        public String toString() {
            return "Line{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
        }

        public static boolean areParallel(Line l1, Line l2) {
            return Double.compare(l1.a, l2.a) == 0 && Double.compare(l1.b, l2.b) == 0;
        }

        public static boolean areSame(Line l1, Line l2) {
            return areParallel(l1, l2) && Double.compare(l1.c, l2.c) == 0;
        }

        public static Point areIntersect(Line l1, Line l2) {
            if (areParallel(l1, l2)) {
                return null;
            }
            Point p = new Point(0.0, 0.0);
            p.x = (l2.b * l1.c - l1.b * l2.c) / (l2.a * l1.b - l1.a * l2.b);
            if (abs(l1.b) > 1e-9) {
                p.y = -(l1.a * p.x + l1.c);
            } else {
                p.y = -(l2.a * p.x + l2.c);
            }
            return p;
        }
    }

}
