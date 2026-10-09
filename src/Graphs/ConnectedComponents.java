package Graphs;

import java.util.*;

public class ConnectedComponents {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0, 0, 1, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
        };

        System.out.println("Connected components:");
        findComponents(graph);
    }

    public static void findComponents(int[][] graph) {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[graph[0].length];
        List<List<Integer>> components = new ArrayList<>();

        for (int i = 0; i < graph[0].length; i++) {
            if (!visited[i]) {
                stack.push(i);
                List<Integer> oneComponent = new ArrayList<>();

                while (!stack.isEmpty()) {
                    int from = stack.pop();
                    visited[from] = true;

                    oneComponent.add(from + 1);

                    for (int to = 0; to < graph[0].length; to++) {
                        if (graph[from][to] == 1 && !visited[to]) {
                            stack.push(to);
                            visited[to] = true;
                        }
                    }
                }

                components.add(oneComponent);
            }
        }

        System.out.println(components);
    }
}
