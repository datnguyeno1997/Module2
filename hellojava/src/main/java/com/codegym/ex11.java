package com.codegym;

public class ex11 {
    public static int symmetric(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] != arr[right]) {   // Nếu phần tử khác nhau thì mảng sẽ không đối xứng
                return 0;
            }
            left++;
            right--;
        }
        return 1;
//        vòng lặp kết thúc mà không có phần tử nào khác nhau, tức là mảng đối xứng
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 2, 1};
        System.out.println("Mảng có đối xứng: " + symmetric(arr));
    }
}