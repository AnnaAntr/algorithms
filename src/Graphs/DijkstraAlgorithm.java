package Graphs;

import java.util.*;

public class DijkstraAlgorithm {
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] graph = new int[][] {
                {0, 2, 1, 4, 0, 0},
                {0, 0, 0, 7, 2, 0},
                {0, 0, 0, 5, 10, 4},
                {0, 0, 0, 0, 0, 5},
                {0, 0, 0, 0, 0, 4},
                {0, 0, 0, 0, 0, 0},
        };

        int[] res = shortestWaysFrom(graph, 1);
        System.out.println(Arrays.toString(res));
    }
    
    public static int[] shortestWaysFrom(int graph[][], int start) {
        int n = graph.length;
        boolean[] visited = new boolean[n];

        int[] distances = new int[n];
        Arrays.fill(distances, INF);
        distances[start] = 0;

        for (int i = 0; i < n; i++) {
            int closestVertex = -1;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && (closestVertex == -1 || distances[v] < distances[closestVertex]))
                    closestVertex = v;
            }

            if (closestVertex == -1 || distances[closestVertex] == INF) break;

            visited[closestVertex] = true;

            for (int v = 0; v < n; v++) {
                int edge = graph[closestVertex][v];

                if (edge != 0 && !visited[v] && distances[closestVertex] != INF && distances[closestVertex] + edge < distances[v])
                    distances[v] = distances[closestVertex] + edge;
            }
        }

        return distances;
    }

}
