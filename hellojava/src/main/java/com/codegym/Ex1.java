package com.codegym;

public class Ex1 {
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 3, 5, 8, 9, 10};
        int total = 0;
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > arr[i - 1]){
                total += arr[i];
            }
        }
        System.out.println(total);
    }
}

