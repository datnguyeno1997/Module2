package com.codegym;

import java.util.Arrays;

public class Ex7 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.ceil(Math.random() * (-20) + Math.random() * 30);
        }
        System.out.println(Arrays.toString(arr));
        sqrtIndex(arr);
    }

    public static void sqrtIndex(int[] array) {
        for (int i = 0; i < array.length; i++){
            double sqrt = Math.sqrt(array[i]);
             if (Math.floor(sqrt) == sqrt) {
                 System.out.println(i);
             }
        }
    }
}
