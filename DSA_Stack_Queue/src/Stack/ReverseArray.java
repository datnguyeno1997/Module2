package Stack;

import java.util.Arrays;
import java.util.Stack;

public class ReverseArray {
    public static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String[] args) {
        int[] arr = {5, 7, 9, 6, 1};
        arr = reserveArr(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static int[] reserveArr(int[] arrs) {
        for (int i = 0; i < arrs.length; i++) {
            stack.push(arrs[i]);
        }
        int j = 0;
        while (!stack.isEmpty()){
            arrs[j] = stack.pop();
            j++;
        }
        return arrs;
    }
}
