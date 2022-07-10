package algorithm.p5_dfs.combination.t425电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

public class Solution {
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

        dfs(0, digits, digitToChar, "", results);
        return results;
    }

    private void dfs(int digit,
                     String digits,
                     String[] digitToChar,
                     String combination,
                     List<String> combinations) {

        if (combination.length() == digits.length()) {
            if (combination.length() != 0) {
                combinations.add(combination);
            }
            return;
        }

        for (int i = 0; i < digitToChar[digits.charAt(digit) - '0'].length(); i++) {
            dfs(digit + 1, digits, digitToChar, combination + digitToChar[digits.charAt(digit) - '0'].charAt(i), combinations);
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations(""));
    }

}