package Graphs;

import java.util.ArrayDeque;
import java.util.Deque;

public class Graph {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 1, 0, 0},
                {1, 1, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 1, 0},
        };

        int[][] graph2 = {
                {0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0},
                {1, 1, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0},
        };

        System.out.print("Iterative DFS: ");
        iterativeDFS(graph, 0);
        System.out.print("\nRecursive DFS: ");
        recursiveDFS(graph, 0, new boolean[graph[0].length]);
    }

    public static void recursiveDFS(int[][] graph, int from, boolean[] visited) {
        visited[from] = true;
        System.out.print(from + 1 + " ");

        for (int to = 0; to < graph[0].length; to++) {
            if (graph[from][to] == 1 && !visited[to])
                recursiveDFS(graph, to, visited);
        }
    }

    public static void iterativeDFS(int[][] graph, int start) {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[graph[0].length];

        visited[start] = true;
        stack.push(start);

        while (!stack.isEmpty()) {
            int from = stack.pop();
            visited[from] = true;

            System.out.print(from + 1 + " ");

            for (int to = 0; to < graph[from].length; to++) {
                if (graph[from][to] == 1 && !visited[to]) {
                    visited[to] = true;
                    stack.push(to);
                }
            }
        }
    }
}
