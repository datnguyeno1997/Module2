package StopWatch;

public class Main {
    public static void main(String[] args) {
        int[] arr = generateRandomArray(100000);

        StopWatch stopWatch = new StopWatch();
        selectionSort(arr);
        stopWatch.stop();

        long elapsedTime = stopWatch.getElapsedTime();
        System.out.println("Thời gian thực thi của thuật toán sắp xếp chọn: " + elapsedTime + " milliseconds");

    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        return arr;
    }
}
