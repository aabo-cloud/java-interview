package algorithm.others.图论.多源最短路;

/**
 * @program: java-interview
 * @description:
 * @author: aabo
 * @create: 2024-10-09 20:23
 **/
public class Main {

    public static void floydWarshall(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];
        int[][] path = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
                if (i != j && graph[i][j] != Integer.MAX_VALUE) {
                    path[i][j] = i;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE &&
                            (dist[i][k] + dist[k][j] < dist[i][j] || dist[i][j] == Integer.MAX_VALUE)) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }

        // Print the distance and path matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("(" + i + ", " + j + "): ");
                if (dist[i][j] == Integer.MAX_VALUE) {
                    System.out.println("No path exists");
                } else {
                    System.out.println("Distance: " + dist[i][j] + ", Path: " + i);
                    int u = i;
                    while (path[u][j] != u) {
                        System.out.print(" -> " + path[u][j]);
                        u = path[u][j];
                    }
                    System.out.println(" -> " + j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 5; // Number of vertices in the graph
        int[][] graph = {
                {0, INF, 5, INF, INF},
                {INF, 0, INF, 10, INF},
                {INF, INF, 0, INF, 3},
                {INF, INF, INF, 0, INF},
                {INF, INF, INF, INF, 0}
        };

        floydWarshall(graph);
    }

    private static final int INF = Integer.MAX_VALUE;

}
