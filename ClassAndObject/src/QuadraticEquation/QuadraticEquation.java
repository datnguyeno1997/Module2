package QuadraticEquation;

import java.util.Scanner;

public class QuadraticEquation {
   private double a;
   private double b;
   private double c;
   public QuadraticEquation(double a, double b, double c) {
       this.a = a;
       this.b = b;
       this.c = c;
   }

//   Bước 2

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
//    Bước 3
    public double getDiscriminant() {
       return b * b - 4 * a * c;
    }

//    Bước 4
    public void solveEquation() {
       double delta = getDiscriminant();

       if (delta > 0) {
           double root1 = (-b + Math.sqrt(delta)) / (2 * a);
           double root2 = (-b - Math.sqrt(delta)) / (2 * a);
           System.out.println("The equation has two distinct roots: ");
           System.out.println("Root 1: " + root1);
           System.out.println("Root 2: " + root2);
       } else if (delta == 0) {
           double root = -b / (2 * a);
           System.out.println("The equation has one root: ");
           System.out.println("Root: " + root);
       } else {
           System.out.println("The equation has no roots");
       }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter the value of b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter the value of c: ");
        double c = scanner.nextDouble();
        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        equation.solveEquation();
    }
}
