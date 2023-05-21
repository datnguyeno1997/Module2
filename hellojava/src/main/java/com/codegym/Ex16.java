package com.codegym;

public class Ex16 {
    public static void main(String[] args) {
        int[][] matrix = {
                {2, 4, 6},
                {1, 8, 10},
                {3, 5, 7}
        };
//        Tạo biến và cho giá trị ban đầu = false để kiểm tra có tồn tại số lẽ ko
        boolean oddNumber = false;
        for (int i = 0; i < matrix.length; i++ ) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] % 2 !=0) {
                    oddNumber = true;
                    break;
                }
            }
        }
        if (oddNumber) {
            System.out.println("Ma trận tồn tại số lẻ");
        }else {
            System.out.println("Ma trận không tồn tại số lẻ");
        }
    }
}
