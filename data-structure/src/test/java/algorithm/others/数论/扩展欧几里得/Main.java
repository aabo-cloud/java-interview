package algorithm.others.数论.扩展欧几里得;

/**
 * @program: java-interview
 * @description:
 * @author: aabo
 * @create: 2024-10-09 19:40
 **/
public class Main {

    //求二元一次不定方程的整数解Ax + By = gcd(A, B)
    public static int[] extendedEuclid(int a, int b) {
        if (b == 0) {
            return new int[]{a, 1, 0};  // 返回 gcd(a, b), x, y
        }

        int[] values = extendedEuclid(b, a % b);
        int gcd = values[0];
        int x = values[2];
        int y = values[1] - (a / b) * values[2];
        return new int[]{gcd, x, y};
    }

    public static void main(String[] args) {

        int a = 35;
        int b = 15;
        int[] results = extendedEuclid(a, b);
        System.out.println("The GCD of " + a + " and " + b + " is " + results[0]);
        System.out.println("Coefficients x and y are: " + results[1] + " and " + results[2]);

    }

}
