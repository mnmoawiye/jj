// Circle2D class models a circle in 2D space
public class Circle2D {
    // Private data fields
    private double x;
    private double y;
    private double radius;

    // No-arg constructor: default circle at (0,0) with radius 1
    public Circle2D() {
        this.x = 0;
        this.y = 0;
        this.radius = 1;
    }

    // Parameterized constructor
    public Circle2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    // Getter methods
    public double getX() { return x; }
    public double getY() { return y; }
    public double getRadius() { return radius; }

    // Method to calculate area
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate perimeter
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // Check if a point is inside the circle
    public boolean contains(double px, double py) {
        double distance = Math.sqrt((px - x)*(px - x) + (py - y)*(py - y));
        return distance <= radius;
    }

    // Check if another circle is completely inside this circle
    public boolean contains(Circle2D circle) {
        double distance = Math.sqrt((circle.getX() - x)*(circle.getX() - x) + 
                                    (circle.getY() - y)*(circle.getY() - y));
        return distance + circle.getRadius() <= radius;
    }

    // Check if this circle overlaps with another circle
    public boolean overlaps(Circle2D circle) {
        double distance = Math.sqrt((circle.getX() - x)*(circle.getX() - x) + 
                                    (circle.getY() - y)*(circle.getY() - y));
        return distance < (radius + circle.getRadius()) && 
               !this.contains(circle) && !circle.contains(this);
    }

    // Main method for testing the class
    public static void main(String[] args) {
        Circle2D c1 = new Circle2D(2, 3, 5);
        System.out.println("Circle c1 center: (" + c1.getX() + ", " + c1.getY() + ")");
        System.out.println("Radius: " + c1.getRadius());
        System.out.println("Area: " + c1.getArea());
        System.out.println("Perimeter: " + c1.getPerimeter());
        System.out.println("Contains point (3,4)? " + c1.contains(3, 4));

        Circle2D c2 = new Circle2D(4, 5, 2);
        System.out.println("Contains circle c2? " + c1.contains(c2));
        System.out.println("Overlaps circle c2? " + c1.overlaps(c2));
    }
}
