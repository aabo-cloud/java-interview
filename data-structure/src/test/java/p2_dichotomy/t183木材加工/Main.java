package p2_dichotomy.t183木材加工;

import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/183
 * 有一些原木，现在想把这些木头切割成一些长度相同的小段木头，需要得到的小段的数目至少为 k。
 * 给定L和k，你需要计算能够得到的小段木头的最大长度。
 * 木头长度的单位是厘米。原木的长度都是正整数，我们要求切割得到的小段木头的长度也要求是整数。
 * 无法切出要求至少 k 段的,则返回 0 即可。
 *
 * @author aabo
 * @createTime 2022/6/15 22:49
 */
public class Main {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0) {
            return 0;
        }
        int start = 1;
        int end = getMaxCutWoodLength(L, k);
        if (end < 1) {
            return 0;
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // 等于k的时候还是可以继续加长度
            // 因为木头可能还有更大的富裕
            if (getCount(L, mid) >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return getCount(L, end) >= k ? end : start;
    }

    private int getCount(int[] L, int length) {
        int cnt = 0;
        for (int item : L) {
            cnt += item / length;
        }
        return cnt;
    }

    private int getMaxCutWoodLength(int[] L, int k) {
        int maxWoodLength = Integer.MIN_VALUE;
        long totalWoodLength = 0;
        for (int wl : L) {
            maxWoodLength = Math.max(wl, maxWoodLength);
            totalWoodLength += wl;
        }
        return (int) Math.min(totalWoodLength / k, maxWoodLength);
    }

    @Test
    public void test() {
        int[] L = {2147483644, 2147483645, 2147483646, 2147483647};
        int k = 4;
        System.out.println(woodCut(L, k));
    }

}