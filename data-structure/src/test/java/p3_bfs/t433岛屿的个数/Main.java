package p3_bfs.t433岛屿的个数;

import header.Point;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/433
 * 给一个 01 矩阵，求不同的岛屿的个数。
 * 0 代表海，1 代表岛，如果两个 1 相邻，那么这两个 1 属于同一个岛。我们只考虑上下左右为相邻。
 *
 * @author aabo
 * @createTime 2022/6/16 16:13
 */
public class Main {

    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {

        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] && !visited[i][j]) {
                    bfs(new Point(i, j), grid, visited);
                    result++;
                }
            }
        }
        return result;

    }

    private void bfs(Point start, boolean[][] grid, boolean[][] visited) {

        int[] deltaX = {0, 1, 0, -1};
        int[] deltaY = {1, 0, -1, 0};

        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            for (int i = 0; i < 4; i++) {

                int x = poll.x + deltaX[i];
                int y = poll.y + deltaY[i];
                if (!isValid(x, y, grid, visited)) {
                    continue;
                }
                queue.offer(new Point(x, y));
                visited[x][y] = true;

            }
        }

    }

    private boolean isValid(int x, int y, boolean[][] grid, boolean[][] visited) {
        int n = grid.length, m = grid[0].length;
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        return grid[x][y];
    }


}