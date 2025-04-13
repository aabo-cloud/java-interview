package algorithm.others.数论.快速乘;

/**
 * @program: java-interview
 * @description:
 * @author: aabo
 * @create: 2024-10-09 19:33
 **/
public class Main {

    public static long mul_mod(long a, long b, long mod) {
        long ans = 0;
        long base = a;
        while(b > 0) {
            if((b & 1) == 1) {
                ans = (ans + base) % mod;
            }
            base = (base + base) % mod;
            b >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {

        long a = 1999999999;
        long b = 1999999999;
        System.out.println(mul_mod(a, b, Long.MAX_VALUE));

    }

}
