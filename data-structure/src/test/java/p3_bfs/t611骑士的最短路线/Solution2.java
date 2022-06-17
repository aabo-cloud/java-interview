package p3_bfs.t611骑士的最短路线;

// 双向宽度优先搜索

import header.Point;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

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

        if (grid[destination.x][destination.y]) {
            return -1;
        }

        if (source.x == destination.x && source.y == destination.y) {
            return 0;
        }

        Queue<Point> forwardQueue = new LinkedList<>();
        Queue<Point> backwardQueue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] forwardSet = new boolean[n][m];
        boolean[][] backwardSet = new boolean[n][m];
        forwardQueue.offer(new Point(source.x, source.y));
        forwardSet[source.x][source.y] = true;
        backwardQueue.offer(new Point(destination.x, destination.y));
        backwardSet[destination.x][destination.y] = true;

        int distance = 0;
        while (!forwardQueue.isEmpty() && !backwardQueue.isEmpty()) {
            distance++;
            if (extendQueue(forwardQueue, forwardSet, backwardSet, grid)) {
                return distance;
            }
            distance++;
            if (extendQueue(backwardQueue, backwardSet, forwardSet, grid)) {
                return distance;
            }
        }
        return -1;

    }

    private boolean extendQueue(Queue<Point> queue, boolean[][] visited, boolean[][] oppositeVisited, boolean[][] grid) {

        int[] deltaX = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] deltaY = {2, -2, 2, -2, 1, -1, 1, -1};

        int queueLength = queue.size();

        for (int i = 0; i < queueLength; i++) {
            Point poll = queue.poll();
            for (int j = 0; j < 8; j++) {
                int newX = deltaX[j] + poll.x;
                int newY = deltaY[j] + poll.y;
                if (!isValid(newX, newY, grid, visited)) {
                    continue;
                }
                if (oppositeVisited[newX][newY]) {
                    return true;
                }
                queue.offer(new Point(newX, newY));
                visited[newX][newY] = true;
            }

        }

        return false;
    }

    private boolean isValid(int x, int y, boolean[][] grid, boolean[][] visited) {

        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        if (grid[x][y]) {
            return false;
        }

        return true;
    }


}
