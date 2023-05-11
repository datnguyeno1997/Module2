package ShowPrimesLessThan100;

public class Main {
    public static boolean main(int number) {
       if (number < 2) {
           return false;
       }
       for (int i = 2; i <= Math.sqrt(number); i++) {
           if (number % i == 0){
               return false;
           }
       }
        return true;
    }
    public static void main(String[] args) {
        for (int number = 2; number <= 100; number++) {
            if (main(number)) {
                System.out.println(number);
            }
        }
    }
}

