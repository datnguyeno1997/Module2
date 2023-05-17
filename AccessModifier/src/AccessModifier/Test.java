package AccessModifier;

public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Circle circle1 = new Circle(2,"Blue");

        System.out.println(circle.getRadius());
        System.out.println(circle1.getRadius());
        System.out.println(circle.getArea());
        System.out.println(circle1.getArea());
    }
}
