package triangle_classifier;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;



public class TriangleClassifierTest {
    @Test
    @DisplayName("Phân loại tam giác 3 cạnh 2, 2, 2")
    public void classifySides222(){
        int side1 = 2;
        int side2 = 2;
        int side3 = 2;
        String expected = "tam giác đều";
        String actual = TriangleClassifier.classifyTriangle(side1,side2,side3);
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("Phân loại tam giác 3 cạnh 2, 2, 3")
    public void classifySides223(){
        int side1 = 2;
        int side2 = 2;
        int side3 = 3;
        String expected = "tam giác cân";
        String actual = TriangleClassifier.classifyTriangle(side1,side2,side3);
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("Phân loại tam giác 3 cạnh 3, 4, 5")
    public void classifySides345(){
        int side1 = 3;
        int side2 = 4;
        int side3 = 5;
        String expected = "tam giác thường";
        String actual = TriangleClassifier.classifyTriangle(side1,side2,side3);
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("Phân loại tam giác 3 cạnh 8, 2, 3")
    public void classifySides823(){
        int side1 = 8;
        int side2 = 2;
        int side3 = 3;
        String expected = "không phải là tam giác";
        String actual = TriangleClassifier.classifyTriangle(side1,side2,side3);
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("Phân loại tam giác 3 cạnh -1, 2, 1")
    public void classifySidesMinus121(){
        int side1 = -1;
        int side2 = 2;
        int side3 = 1;
        String expected = "không phải là tam giác";
        String actual = TriangleClassifier.classifyTriangle(side1,side2,side3);
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("Phân loại tam giác 3 cạnh 0, 1, 1")
    public void classifySides011(){
        int side1 = 0;
        int side2 = 1;
        int side3 = 1;
        String expected = "không phải là tam giác";
        String actual = TriangleClassifier.classifyTriangle(side1,side2,side3);
        assertEquals(expected,actual);
    }
}