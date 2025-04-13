package algorithm.header;

/**
 * @program: java-interview
 * @description: ItemDemo
 * @author: aabo
 * @create: 2024-09-09 16:07
 **/
public class ItemDemo implements Comparable<ItemDemo> {

    public int a;
    public int b;

    public ItemDemo(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(ItemDemo o) {

        return this.a - o.a;
    }

    @Override
    public String toString() {
        return "ItemDemo{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
