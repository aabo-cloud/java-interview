package p3_bfs.t611骑士的最短路线;

import header.Point;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/611
 * 给定骑士在棋盘上的 初始 位置(一个2进制矩阵 0 表示空 1 表示有障碍物)，找到到达 终点 的最短路线，返回路线的长度。
 * 如果骑士不能到达则返回 -1 。
 * 起点跟终点必定为空.
 * 骑士不能碰到障碍物.
 * 路径长度指骑士走的步数.
 * 如果骑士的位置为 (x,y)，他下一步可以到达以下这些位置:
 * <p>
 * (x + 1, y + 2)
 * (x + 1, y - 2)
 * (x - 1, y + 2)
 * (x - 1, y - 2)
 * (x + 2, y + 1)
 * (x + 2, y - 1)
 * (x - 2, y + 1)
 * (x - 2, y - 1)
 *
 * @author aabo
 * @createTime 2022/6/16 17:05
 */
public class Solution {
    /**
     * @param grid:        a chessboard included 0 (false) and 1 (true)
     * @param source:      a point
     * @param destination: a point
     * @return: the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {

        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }

        int[] deltaX = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] deltaY = {2, -2, 2, -2, 1, -1, 1, -1};
        int colCnt = grid[0].length;

        Queue<Point> queue = new ArrayDeque<>();
        Map<Integer, Integer> disToSrcMap = new HashMap<>();
        queue.offer(source);
        disToSrcMap.put(source.x * colCnt + source.y, 0);

        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            int cutPointKey = poll.x * colCnt + poll.y;
            if (poll.x == destination.x && poll.y == destination.y) {
                return disToSrcMap.get(cutPointKey);
            }
            for (int i = 0; i < 8; i++) {
                int x = poll.x + deltaX[i];
                int y = poll.y + deltaY[i];
                if (!isValid(x, y, grid, disToSrcMap)) {
                    continue;
                }
                queue.offer(new Point(x, y));
                disToSrcMap.put(x * colCnt + y, disToSrcMap.get(cutPointKey) + 1);
            }
        }
        return -1;

    }

    private boolean isValid(int x, int y, boolean[][] grid, Map<Integer, Integer> disToSrcMap) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }
        if (disToSrcMap.containsKey(x * grid[0].length + y)) {
            return false;
        }
        return !grid[x][y];
    }

}