package RemoveElement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số phần tử trong mảng: ");
        int N = scanner.nextInt();
        int[] array = new int[N];
        System.out.println("Nhập các phần tử của mảng: ");
        for (int i = 0; i < N; i++) {
            System.out.println("Phần tử thứ " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        System.out.println("Nhập phần tử cần xóa: ");
//        Tìm vị trí của X trong mảng
        int X = scanner.nextInt();
        int index_del = -1;
        for (int i = 0; i < N; i++) {
            if (array[i] == X){
                index_del = i;
                break;
            }
        }
        if (index_del == -1) {
            System.out.println(X + " không xuất hiện trong mảng.");
        }else {
            for (int i = index_del; i < N - 1; i++){
                array[i] = array[i + 1];
            }
            N--;
            System.out.println("Mảng sau khi xóa " + X + ":");
            for (int i = 0; i < N; i++) {
                System.out.print(array[i] + " ");
            }
        }
    }
}
