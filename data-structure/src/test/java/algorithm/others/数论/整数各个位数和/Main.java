package algorithm.others.数论.整数各个位数和;

/**
 * @program: java-interview
 * @description:
 * @author: aabo
 * @create: 2024-10-08 22:17
 **/
public class Main {

    public static int sum(int i) {
        if(i > 9)
            return i % 10 + sum(i / 10);
        return i;
    }

    public static void main(String[] args) {

        System.out.println(sum(999));

    }

}
