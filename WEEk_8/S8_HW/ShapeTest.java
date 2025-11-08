public class ShapeTest {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        circle.displayInfo();
        System.out.println("Circle Area: " + circle.area());
        System.out.println("Circle Perimeter: " + circle.perimeter());

        Shape rectangle = new Rectangle(4, 6);
        rectangle.displayInfo();
        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Rectangle Perimeter: " + rectangle.perimeter());
    }
}
