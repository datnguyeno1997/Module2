package com.codegym;

//xác định số lượng phần tử kề nhau mà cả 2 đều chẵn

public class Ex10 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 3, 8, 10, 12, 7, 9, 11};
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
//            Kiểm tra cả hai phần tử liền kề có chẵn hay không
            if (arr[i - 1] % 2 == 0 && arr[i] % 2 == 0) {
                count++;
            }
        }
        System.out.println("Số lượng phần tử kề nhau chẵn: " + count);
    }

}
