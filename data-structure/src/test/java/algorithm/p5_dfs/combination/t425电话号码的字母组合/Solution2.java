package algorithm.p5_dfs.combination.t425电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {

        String[] digitToChar = {
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        List<String> results = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(0, digits, digitToChar, sb, results);
        return results;
    }

    private void dfs(int digit,
                     String digits,
                     String[] digitToChar,
                     StringBuilder combination,
                     List<String> combinations) {

        if (combination.length() == digits.length()) {
            if (combination.length() != 0) {
                combinations.add(combination.toString());
            }
            return;
        }

        for (int i = 0; i < digitToChar[digits.charAt(digit) - '0'].length(); i++) {
            combination.append(digitToChar[digits.charAt(digit) - '0'].charAt(i));
            dfs(digit + 1, digits, digitToChar, combination, combinations);
            combination.delete(combination.length() - 1, combination.length());
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution2().letterCombinations("33"));
    }

}
