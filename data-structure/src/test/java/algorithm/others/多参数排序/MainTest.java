package algorithm.others.多参数排序;

import algorithm.header.ItemDemo;
import algorithm.header.ItemDemo2;

import java.util.*;

/**
 * @program: java-interview
 * @description: maintest
 * @author: aabo
 * @create: 2024-09-09 16:10
 **/
public class MainTest {

    public static void main(String[] args) {

        ItemDemo[] items = new ItemDemo[3];
        items[0] = new ItemDemo(1, 0);
        items[1] = new ItemDemo(-1, 1);
        items[2] = new ItemDemo(2, 3);

        Arrays.sort(items);

        System.out.println(Arrays.toString(items));

        List<ItemDemo> itemArray = new ArrayList<>();

        itemArray.add(new ItemDemo(1, 0));
        itemArray.add(new ItemDemo(-1, 1));
        itemArray.add(new ItemDemo(2, 2));

        Collections.sort(itemArray, new Comparator<ItemDemo>() {
            @Override
            public int compare(ItemDemo o1, ItemDemo o2) {
                return o1.a - o2.a;
            }
        });

        System.out.println(itemArray);


        ItemDemo2[] items2 = new ItemDemo2[3];
        items2[0] = new ItemDemo2(1, 0, 10);
        items2[1] = new ItemDemo2(-1, 1, 100000);
        items2[2] = new ItemDemo2(2, 1, 10000);

        Arrays.sort(items2);

        System.out.println(Arrays.toString(items2));

    }

}
