package tugas8;

import java.util.Scanner;
import java.util.HashMap;

// Abstract Class: Shape
abstract class Shape {
    abstract void draw();
    abstract void erase();
    abstract void move();
    abstract void resize();
}

// Entity Class: Point
class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// Entity Class: Circle
class Circle extends Shape {
    private double radius;
    private Point center;

    public Circle(double radius, Point center) {
        this.radius = radius;
        this.center = center;
    }

    @Override
    void draw() {
        System.out.println("Drawing Circle at (" + center.x + ", " + center.y + ") with radius " + radius);
    }

    @Override
    void erase() {
        System.out.println("Erasing Circle");
    }

    @Override
    void move() {
        System.out.println("Moving Circle");
    }

    @Override
    void resize() {
        System.out.println("Resizing Circle");
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double circum() {
        return 2 * Math.PI * radius;
    }

    public void setCenter(int x, int y) {
        this.center = new Point(x, y);
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

// Entity Class: Rectangle
class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Rectangle");
    }

    @Override
    void erase() {
        System.out.println("Erasing Rectangle");
    }

    @Override
    void move() {
        System.out.println("Moving Rectangle");
    }

    @Override
    void resize() {
        System.out.println("Resizing Rectangle");
    }
}

// Entity Class: Polygon
class Polygon extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Polygon");
    }

    @Override
    void erase() {
        System.out.println("Erasing Polygon");
    }

    @Override
    void move() {
        System.out.println("Moving Polygon");
    }

    @Override
    void resize() {
        System.out.println("Resizing Polygon");
    }
}

// Boundary Class: Window
class Window {
    public void open() {
        System.out.println("Window Opened");
    }

    public void close() {
        System.out.println("Window Closed");
    }

    public void move() {
        System.out.println("Window Moved");
    }

    public void display() {
        System.out.println("Window Displayed");
    }

    public void handleEvent(String event) {
        System.out.println("Handling Event: " + event);
    }
}

// Control Class: DrawingContext
class DrawingContext {
    public Point setPoint(int x, int y) {
        return new Point(x, y);
    }

    public void clearScreen() {
        System.out.println("Screen Cleared");
    }

    public int getVerticalSize() {
        System.out.println("Getting Vertical Size");
        return 800;
    }

    public int getHorizontalSize() {
        System.out.println("Getting Horizontal Size");
        return 600;
    }
}

// Control Class: DataController
class DataController {
    private HashMap<String, Object> data;

    public DataController() {
        data = new HashMap<>();
    }

    public void addData(String key, Object value) {
        data.put(key, value);
    }

    public Object getData(String key) {
        return data.get(key);
    }
}

// Testing the Classes
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a Point
        System.out.println("Enter the center coordinates for the Circle (x y):");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        Point center = new Point(x, y);

        // Create a Circle
        System.out.println("Enter the radius of the Circle:");
        double radius = scanner.nextDouble();
        Circle circle = new Circle(radius, center);
        circle.draw();
        System.out.println("Area: " + circle.area());
        System.out.println("Circumference: " + circle.circum());

        // Move and resize Circle
        System.out.println("Enter new center coordinates for the Circle (x y):");
        x = scanner.nextInt();
        y = scanner.nextInt();
        circle.setCenter(x, y);

        System.out.println("Enter new radius for the Circle:");
        radius = scanner.nextDouble();
        circle.setRadius(radius);

        circle.draw();

        // Drawing other shapes
        Rectangle rect = new Rectangle();
        rect.draw();

        Polygon poly = new Polygon();
        poly.draw();

        // Using Window
        Window window = new Window();
        window.open();
        window.display();
        window.handleEvent("Click");

        // Using DrawingContext
        DrawingContext context = new DrawingContext();
        System.out.println("Enter point coordinates (x y):");
        x = scanner.nextInt();
        y = scanner.nextInt();
        Point point = context.setPoint(x, y);
        System.out.println("Point created at (" + point.x + ", " + point.y + ")");
        context.clearScreen();

        scanner.close();
    }
}
