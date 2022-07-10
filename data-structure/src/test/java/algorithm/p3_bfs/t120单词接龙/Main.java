package algorithm.p3_bfs.t120单词接龙;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/120
 * 给出两个单词（start和end）和一个字典，找出从start到end的最短转换序列，输出最短序列的长度。
 * 变换规则如下：
 * 每次只能改变一个字母。
 * 变换过程中的中间单词必须在字典中出现。(起始单词和结束单词不需要出现在字典中)
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * len(dict) <= 5000, len(start) < 5len(dict)<=5000,len(start)<5
 *
 * @author aabo
 * @createTime 2022/6/16 16:08
 */
public class Main {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        dict.add(end);
        Deque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        int result = 1;
        while (!queue.isEmpty()) {
            result++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String poll = queue.poll();
                for (String nextWord : findNextWords(poll, dict)) {
                    if (visited.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return result;
                    }
                    queue.offer(nextWord);
                    visited.add(nextWord);
                }
            }
        }
        return 0;
    }

    private List<String> findNextWords(String curWord, Set<String> dict) {
        List<String> nextWords = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            for (int j = 0; j < curWord.length(); j++) {
                if (i == curWord.charAt(j)) {
                    continue;
                }
                String nextWord = replace(curWord, j, i);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }

    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }

}
