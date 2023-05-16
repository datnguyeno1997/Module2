package com.codegym;

public class Ex5 {
    public static void main(String[] args) {
        double[] arr = {1.5, 2.8, 3.2, 4.7, 5.1, 6.9};
        double x = 3.0;
        double y = 6.0;

        System.out.println("Các số trong đoạn [" + x + ", " + y + "] :" );
        for (double num : arr) {
            if (num >= x && num >= y) {
                System.out.println(num);
            }
        }
    }
}
