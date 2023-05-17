package com.codegym;

public class Ex9 {

//    kiêm tra xem 1 số có phải số nguyên tố hay không

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i ==0) {
                return false;
            }
        }
        return true;
    }
//    đếm số lượng số nguyên tố duyệt qua từng phần tử

    public static int countPrimes(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (isPrime(array[i])) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 4, 5, 6, 7, 8, 9, 10};
        int primeCount = countPrimes(array);
        System.out.println("Số lượng số nguyên tố trong mảng: " + primeCount);
    }
}
