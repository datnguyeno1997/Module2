package com.codegym;

public class Ex8 {
    public static void main(String[] args) {
        int[] arr = {1, 7, 4, -8, 3, 21, 14, 5, -27};
        int count = countPositiveDivisibleBy7(arr);
        System.out.println("Count: " + count);
    }

    public static int countPositiveDivisibleBy7(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0 && array[i] % 7 == 0){
                count++;
            }
        }
       return count;
    }
}

