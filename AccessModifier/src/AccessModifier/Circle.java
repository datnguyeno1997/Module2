package AccessModifier;

public class Circle {
    private double radius = 1.0;
    private String color = "red";
    public Circle() {}
    public Circle(double a, String colorur) {
        radius = a;
        color = colorur;
    }
     double getRadius() {
        return radius;
    }

    String getColor() {
        return color;
    }

     double getArea() {
        return 2 * Math.PI * Math.pow(radius,2);
    }
}
