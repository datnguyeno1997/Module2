package CircleAndCylinder;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(2.5, "blue");
        System.out.println(circle.toString());
        System.out.println("Radius: " + circle.getRadius());
        System.out.println("Color: " + circle.getColor());
        System.out.println("Area: " + circle.getArea());

        Cylinder cylinder = new Cylinder(2.0, 3.0, "green");
        System.out.println(cylinder.toString());
        System.out.println("Radius: " + cylinder.getRadius());
        System.out.println("Color: " + cylinder.getColor());
        System.out.println("Height: " + cylinder.getHeight());
        System.out.println("Area: " + cylinder.getArea());
        System.out.println("Volume: " + cylinder.getVolume());
    }
}
