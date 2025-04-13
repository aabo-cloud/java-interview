package algorithm.others.数论.质数;

/**
 * @program: java-interview
 * @description:
 * @author: aabo
 * @create: 2024-10-09 19:37
 **/
public class Main {

    public static Boolean is_prime(int n) {
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {



    }

}
