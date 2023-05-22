package Point;

public class PointMain {
    public static void main(String[] args) {
        Point2D testPoint2D = new Point2D(3, 4);
        Point3D testPoint3D = new Point3D(4, 5, 7);

        System.out.println(testPoint2D.toString());
        System.out.println(testPoint3D.toString());
    }
}
