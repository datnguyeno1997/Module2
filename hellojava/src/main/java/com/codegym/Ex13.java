package com.codegym;
// Hãy cho biết tất cả các phần tử trong mảng a có nằm trong mảng b không
public class Ex13 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {3, 2, 1, 4, 5};

//        Kiểm tra các phần tử trong mảng có nằm trong a và b hay ko
        boolean elementsArray = true;
        for (int i = 0; i < a.length; i++){
            boolean found = false;
            for (int j = 0; j < b.length; j++){
                if (a[i] == b[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                elementsArray = false;
                break;
            }
        }
        if (elementsArray) {
            System.out.println("Tất cả các phần tử nằm trong mảng a và b.");
        } else {
            System.out.println(("Tất cả các phần tử không nằm trong mảng a và b"));
        }
    }
}
