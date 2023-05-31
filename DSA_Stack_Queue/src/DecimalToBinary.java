import java.util.Stack;

public class DecimalToBinary {
    public static String decimalToBinary(int decimal) {
        Stack<Integer> stack = new Stack<>();

        while (decimal != 0) { // chuyển đổi từ số thập phân sang nhị phân
            int remainder = decimal % 2;
            stack.push(remainder);
            decimal /= 2;
        }
        StringBuilder binary = new StringBuilder();
        while (!stack.isEmpty()) { // tạo chuỗi nhị phân từ stack
            binary.append(stack.pop());
        }

        return binary.toString();
    }

    public static void main(String[] args) {
        int decimal = 14;
        String binary = decimalToBinary(decimal);
        System.out.println("Decimal: " + decimal);
        System.out.println("Binary: " + binary);
    }
}
