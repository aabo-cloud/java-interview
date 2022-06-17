package p1_two_pointers.same.t1870全零子串的数量;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/1870/
 * 给出一个只包含0或1的字符串str,请返回这个字符串中全为0的子字符串的个数
 *
 * @author aabo
 * @createTime 2022/6/12 15:17
 */
public class Main {

    /**
     * @param str: the string
     * @return: the number of substrings
     */
    public int stringCount(String str) {

        if (str == null || str.isEmpty()) {
            return 0;
        }
        int left = 0, right = 1, n = str.length();
        int result = 0;
        for (; left < n; left++) {
            if (str.charAt(left) != '0') {
                continue;
            }
            right = Math.max(right, left + 1);
            while (right < n && str.charAt(right) == '0') {
                right++;
            }
            result += (right - left);
        }
        return result;

    }

}
