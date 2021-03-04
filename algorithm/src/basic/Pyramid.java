package basic;

/**
 * 피라미드 출력
 */
public class Pyramid {

    public static void main(String[] args) {

        int num = 100;

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < (num-1) - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < ((i * 2) + 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
