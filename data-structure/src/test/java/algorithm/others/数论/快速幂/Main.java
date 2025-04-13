package algorithm.others.数论.快速幂;

/**
 * @program: java-interview
 * @description:
 * @author: aabo
 * @create: 2024-10-08 22:27
 **/
public class Main {


    public static long pow_mod(long a, long b, long mod) {
        long ans = 1;
        long base = a;
        while(b > 0) {
            if((b & 1) == 1) {
                ans = ans * base % mod;
            }
            base = base * base % mod;
            b >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {

        // logab = log10b / log10a
        long a = 2;
        long b = 12;
        System.out.println(pow_mod(a, b, Long.MAX_VALUE));

    }

}
