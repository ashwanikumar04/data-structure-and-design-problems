package in.ashwanik.programming.coding.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuadTree {

    private Rectangle boundary;
    private int capacity;
    private List<Point> points;
    private boolean isDivided;
    private QuadTree northEast;
    private QuadTree northWest;
    private QuadTree southWest;
    private QuadTree southEast;

    public QuadTree(Rectangle boundary, int capacity) {
        this.boundary = boundary;
        this.capacity = capacity;
        points = new ArrayList<>();
    }


    public boolean insert(Point point) {
        if (!this.boundary.contains(point)) {
            return false;
        }
        if (points.size() < capacity) {
            this.points.add(point);
            return true;
        } else {
            if (!isDivided) {
                this.subDivide();
            }
            return this.northEast.insert(point) ||
                    this.northWest.insert(point) ||
                    this.southEast.insert(point) ||
                    this.southWest.insert(point);
        }
    }

    public void query(Rectangle range, List<Point> pointsInTheRange) {
        if (this.boundary.intersect(range)) {
            for (Point p : this.points) {
                if (range.contains(p)) {
                    pointsInTheRange.add(p);
                }
            }
            if (isDivided) {
                this.northEast.query(range, pointsInTheRange);
                this.northWest.query(range, pointsInTheRange);
                this.southEast.query(range, pointsInTheRange);
                this.southWest.query(range, pointsInTheRange);
            }
        }
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    private void subDivide() {
        double x = this.boundary.x;
        double y = this.boundary.y;
        double w = this.boundary.w;
        double h = this.boundary.h;

        Rectangle ne = new Rectangle(x + w / 2, y + h / 2, w / 2, h / 2);
        this.northEast = new QuadTree(ne, this.capacity);
        Rectangle nw = new Rectangle(x - w / 2, y + h / 2, w / 2, h / 2);
        this.northWest = new QuadTree(nw, this.capacity);

        Rectangle se = new Rectangle(x + w / 2, y - h / 2, w / 2, h / 2);
        this.southEast = new QuadTree(se, this.capacity);
        Rectangle sw = new Rectangle(x - w / 2, y - h / 2, w / 2, h / 2);
        this.southWest = new QuadTree(sw, this.capacity);
        this.isDivided = true;
    }


    public static class Point {
        private double x;
        private double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Rectangle {
        private double x;
        private double y;
        private double w;
        private double h;

        public Rectangle(double x, double y, double w, double h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }

        public boolean contains(Point point) {
            return point.x >= (this.x - this.w) &&
                    point.x <= (this.x + this.w) &&
                    point.y <= (this.y + this.h) &&
                    point.y >= (this.y - this.h);
        }

        public boolean intersect(Rectangle range) {
            return !((range.x - range.w) > (this.x + this.w) ||
                    (range.x + range.w) < (this.x - this.w) ||
                    (range.y - range.h) > (this.y + this.h) ||
                    (range.y + range.h) < (this.y - this.h));
        }
    }
}
