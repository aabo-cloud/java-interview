package algorithm.others.数论.GCDLCM;

/**
 * @program: java-interview
 * @description:
 * @author: aabo
 * @create: 2024-10-09 19:38
 **/
public class Main {

    public static int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }
    public static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    public static void main(String[] args) {

        int gcd = gcd(10, 5);
        int lcm = lcm(11, 5);
        System.out.println(gcd);
        System.out.println(lcm);

    }

}
