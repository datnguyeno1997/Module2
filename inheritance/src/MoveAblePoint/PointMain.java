package MoveAblePoint;

public class PointMain {
    public static void main(String[] args) {
        Point unknownPoint = new Point(20, 30);
        System.out.println(unknownPoint.toString());
        unknownPoint.setXY(10, 20);
        System.out.println(unknownPoint.toString());
        unknownPoint = new MovablePoint(unknownPoint.getX(), unknownPoint.getY(), 10, 20);
        System.out.println(unknownPoint.toString());;
        ((MovablePoint) unknownPoint).move();
        System.out.println(unknownPoint.toString());
        MovablePoint anotherPoint = new MovablePoint(20, 20);
        System.out.println(anotherPoint.toString());
        anotherPoint.move();
        System.out.println(anotherPoint.toString());
    }
}
