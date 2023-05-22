package geometricObject;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangl = new Rectangle();
        System.out.println(rectangl);

        rectangl = new Rectangle(2.3, 5.8);
        System.out.println(rectangl);

        rectangl = new Rectangle(2.5, 3.8, "orange", true);
        System.out.println(rectangl);
    }
}
