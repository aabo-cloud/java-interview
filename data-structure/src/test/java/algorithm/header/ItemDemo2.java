package algorithm.header;

/**
 * @program: java-interview
 * @description: ItemDemo2
 * @author: aabo
 * @create: 2024-09-10 10:57
 **/
public class ItemDemo2 implements Comparable<ItemDemo2> {

    public int first;
    public int second;
    public int third;

    public ItemDemo2(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public int compareTo(ItemDemo2 o) {
        if (this.first < o.first) {
            return -1;
        } else if (this.first > o.first) {
            return 1;
        } else {
            if (this.second < o.second) {
                return -1;
            } else if (this.second > o.second) {
                return 1;
            } else {
                return this.third - o.third;
            }
        }
    }

    @Override
    public String toString() {
        return "ItemDemo2{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
