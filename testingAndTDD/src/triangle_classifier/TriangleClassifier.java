package triangle_classifier;

public class TriangleClassifier {
    public static String classifyTriangle(double side1, double side2, double side3) {
        boolean isSumSide1and2overSide3 = (side1 + side2) > side3;
        boolean isSumSide1and3overSide2 = (side1 + side3) > side2;
        boolean isSumSide2and3overSide1 = (side2 + side3) > side1;
        if (isSumSide1and2overSide3 && isSumSide1and3overSide2 && isSumSide2and3overSide1) {
            boolean isSide1and2Equal = side1 == side2;
            boolean isSide2and3Equal = side2 == side3;
            boolean isSide3and1Equal = side3 == side1;
            if (isSide1and2Equal && isSide2and3Equal)
                return "tam giác đều";
            else if (isSide1and2Equal || isSide2and3Equal || isSide3and1Equal)
                return "tam giác cân";
            else
                return "tam giác thường";
        } else
            return " không phải là tam giác";
    }
}
