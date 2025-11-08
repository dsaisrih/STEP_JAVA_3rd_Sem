// Shape.java
abstract class Shape {
    protected double area;
    protected double perimeter;

    abstract void calculateArea();
    abstract void calculatePerimeter();
}

// Interface
interface Drawable {
    void draw();
}

// Circle class
class Circle extends Shape implements Drawable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void calculateArea() {
        area = Math.PI * radius * radius;
        System.out.println("Area of Circle: " + area);
    }

    @Override
    void calculatePerimeter() {
        perimeter = 2 * Math.PI * radius;
        System.out.println("Perimeter of Circle: " + perimeter);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle...");
    }

    public static void main(String[] args) {
        Circle c = new Circle(5);
        c.calculateArea();
        c.calculatePerimeter();
        c.draw();
    }
}
