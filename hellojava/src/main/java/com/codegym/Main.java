package com.codegym;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

//    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//    console.log("aaaaa");
        System.out.printf("Hello and welcome!");          // sout
         int avg = 8;
         if (avg >=8){
             System.out.println("Học sinh giỏi");
         }

//        promt("Nhập a");
         Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập vào tên bạn :");
        String ten = scanner.nextLine();
        System.out.println("Tên bạn là " + ten);

        System.out.println("Nhập số b :");
        int b = scanner.nextInt();
        System.out.println("Giá trị b là :" + b);
    }
}