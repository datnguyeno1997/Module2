package com.codegym;

//Kiểm tra ma trận 2 chiều có toàn dương hay không
public class Ex14 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

//        Khai báo biến checkMatrix và gán giá trị ban đầu = true
        boolean checkMatrix = true;
        for ( int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] <= 0) {
                    checkMatrix = false;
                    break;
                }
            }
        }

//        Xét điều kiện nếu bi checkMatrix vẫn là true thì in ra Ma trận toàn dương và ngược lại
        if (checkMatrix) {
            System.out.println("Ma trận hai chiều toàn số dương.");
        } else {
            System.out.println("Ma trận hai chiều không hoàn toàn số dương");
        }
    }
}
