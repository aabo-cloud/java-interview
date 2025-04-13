package algorithm.others.图论.并查集;

/**
 * @program: java-interview
 * @description:
 * @author: aabo
 * @create: 2024-10-09 20:00
 **/
public class Main {

    public static final int N = 10;
    public static int[] father = new int[N + 1];

    public static void init() {
        for (int i = 1; i <= N; i++) {
            father[i] = i;
        }
    }

    public static int get(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = get(father[x]);    //路径压缩
        //return get(father[x]);
    }

    public static void merge(int x, int y) {
        x = get(x);
        y = get(y);
        if (x != y) {
            father[y] = x;
        }
    }

    public static void main(String[] args) {

        init();
        merge(1, 2);
        merge(4, 5);
        merge(5, 2);
        System.out.println(get(2));
        System.out.println(get(5));

    }

}
