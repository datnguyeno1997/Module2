package com.codegym;

public class Ex15 {
    public static void main(String[] args) {
        int[][] matrix = {
                {2,5,7},
                {1,4,8},
                {3,6,9}
        };

//        chọn cột cần kiểm tra
        int colIndex = 1;

//        Tạo biến với giá trị ban đầu là true để kiểm tra cột có giảm dần hay ko
        boolean decrease = true;
        for (int i = 1; i < matrix.length; i++) {

//        Kiểm tra phần tử hiện tại và phần tử phía trên nó có cùng cột
//            nếu phần tử hiện tại nhỏ hơn hoặc bằng phần tử phái trên thì cho là false
            if (matrix[i][colIndex] >= matrix[i - 1][colIndex]) {
                decrease = false;
                break;
            }
        }
        if (decrease) {
            System.out.println("Cột giảm dần");
        } else {
            System.out.println(" Cột không giảm dần");
        }
    }
}
