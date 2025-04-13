package algorithm.others.求星期公式;

/**
 * @program: java-interview
 * @description:
 * @author: aabo
 * @create: 2024-10-08 22:07
 **/
public class Main {

    public static int whatday(int y, int m, int d) {
        if(m == 1 || m == 2) {
            m += 12;
            y--;
        }
        return (d + 2 * m + 3 * (m + 1) / 5 + y + y / 4 - y / 100 + y / 400) % 7;
    }

    public static void main(String[] args) {

        String[] weekday = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        System.out.println(weekday[whatday(2024, 10, 8)]);

    }

}
