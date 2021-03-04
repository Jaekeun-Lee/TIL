package basic;

import java.util.Scanner;

/**
 * 직각 이등변 삼각형 출력
 */
public class Triangle {

    private static void triangleLT(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void triangleRT(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    private static void triangleLB(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void triangleRB(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > 0; j--) {
                if (i >= j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("이등변 삼각형을 출력합니다. 선택해주세요.");

        int type = 0;
        int num = 0;

        while (true) {
            System.out.println("=================================================");
            System.out.println("1)왼쪽 위 직각\t2)오른쪽 위 직각\t3) 왼쪽 아래 직각 \t4)오른쪽 아래 직각 \t5)프로그램 종료");
            System.out.println("=================================================");
            System.out.print("어느쪽이 직각인 삼각형을 출력할까요? : ");
            type = sc.nextInt();

            if (type == 5) {
                sc.close();
                break;
            }

            System.out.print("몇단으로 출력할까요? : ");
            num = sc.nextInt();

            switch (type) {
                case 1:
                    triangleLT(num);
                    break;
                case 2:
                    triangleRT(num);
                    break;
                case 3:
                    triangleLB(num);
                    break;
                case 4:
                    triangleRB(num);
                    break;
                default:
                    System.out.println("1~4번 사이로 다시 선택해주세요. 종료=5번");
            }

        }


    }
}
