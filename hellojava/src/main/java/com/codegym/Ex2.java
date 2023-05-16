package com.codegym;

public class Ex2 {
    public static void main(String[] args) {
        int[] arr = {5, 2, -6, 3, 5, 8, -9, -10};
        double average = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > 0){
                average += arr[i];
                count++;
            }
        }
        if (count != 0){
            average /= count;
        }
        System.out.println(average);
    }
}
