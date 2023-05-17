package com.codegym;

public class Ex12 {
    public static boolean checkArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
//                Nếu phần tử không tăng thì mảng sẽ không tăng
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

//        Gọi phương thức kiểm tra mảng tăng dần và lưu vào biến
        boolean isIncreasing = checkArray(arr);
        if (isIncreasing) {
            System.out.println("Mảng tăng dần");
        } else {
            System.out.println("Mảng không tăng dần");
        }
    }
}
