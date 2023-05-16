package AddElement;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int N = scanner.nextInt();
        int[] array = new int[N];
        System.out.println("Nhập các phần tử của mảng : ");
        for (int i = 0; i < N; i++){
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        System.out.print("Nhập số cần chèn: ");
        int X = scanner.nextInt();
        System.out.print("Nhập vị trí index cần chèn: ");
        int index = scanner.nextInt();
        if (index < 0 || index > array.length - 1) {
            System.out.println("Không chèn được phần tử vào mảng.");
        } else {
          int[] newArray = new int[array.length + 1];
          for (int i = 0; i < index; i++){
              newArray[i] = array[i];
          }
          newArray[index] = X;
          for (int i = index + 1; i < newArray.length; i++) {
              newArray[i] = array[i - 1];
          }
            System.out.println("Mảng sau khi chèn vào phần tử: ");
            System.out.println(Arrays.toString(newArray));
        }
        scanner.close();
    }

}
