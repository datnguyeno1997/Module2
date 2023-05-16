package com.codegym;

public class Ex3 {
    public static void main(String[] args) {
        int[] list = {1, 5, 6, 8, 9, 2, 12};

        for (int i = 0; i < list.length; i++) {
            if (list[i] % 3 == 0) {
                int temp = list[i];

                for (int j = i; j > 0; j--) {
                    list[j] = list[j - 1];
                }
                list[0] = temp;

            }
        }
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }
}
