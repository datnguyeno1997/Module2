package com.codegym;

import java.util.Arrays;

public class Ex6 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.ceil(Math.random() * (-20) + Math.random() * 30);
        }
        System.out.println(Arrays.toString(arr));
        numAbs(arr);
    }

    public static void numAbs(int[] array) {
        for (int i = 0; i < array.length -1; i++) {
            if (Math.abs(array[i]) > Math.abs(array[i + 1])) {
                System.out.println(array[i]);
            }
        }
    }
}
