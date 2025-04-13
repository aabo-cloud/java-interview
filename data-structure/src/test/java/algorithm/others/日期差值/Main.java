package algorithm.others.日期差值;

/**
 * @program: java-interview
 * @description:
 * @author: aabo
 * @create: 2024-10-08 22:10
 **/
public class Main {

    public static int day_dif(int y1, int m1, int d1, int y2, int m2, int d2) {
        return get_days(y2, m2, d2) - get_days(y1, m1, d1);
    }
    public static int is_leap_year(int y) {
        if(y % 400 == 0 || (y % 4 == 0 && y % 100 != 0))
            return 1;
        return 0;
    }
    public static int get_days(int y, int m, int d) {
        int M[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(is_leap_year(y) == 1)
            M[2]++;
        int sum = 0;
        for(int i = 1; i < y; i++) {
            sum += 365;
            if(is_leap_year(i) == 1)
                sum++;
        }
        for(int i = 1; i < m; i++)
            sum += M[i];
        sum += d;
        return sum;
    }

    public static void main(String[] args) {

        System.out.println(day_dif(2022, 10, 8, 2023, 10, 8));

    }

}
