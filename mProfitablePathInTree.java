package challenge_6Company_30Days;


import java.util.*;

public class mProfitablePathInTree {
    // BFS + DFS

    public static int mostProfitablePath_1(int[][] edges, int bob, int[] amount) {
        //Time: O(E); Space: O(N + E)
        //build graph
        List<Integer>[] graph = new ArrayList[amount.length];
        for (int i = 0; i < amount.length; i++) graph[i] = new ArrayList<>();
        for (int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        //update amount
        helper_bfs(graph, bob, amount);
        return helper_dfs(graph, 0, amount, new boolean[amount.length]);
    }

    //Time: O(N); Space: O(N)
    private static void helper_bfs(List<Integer>[] graph, int bob, int[] amount) {
        int[] preList = new int[amount.length];
        boolean[] seen = new boolean[amount.length];
        seen[bob] = true;

        //Time: O(N); Space: O(N)
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(bob);
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            for (int nextNode : graph[currNode]) {
                if (seen[nextNode] == true) continue;
                preList[nextNode] = currNode;
                if (nextNode == 0) break;

                queue.add(nextNode);
                seen[nextNode] = true;
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(0);
        int p = 0;
        while (p != bob) {
            p = preList[p]; list.add(p);
        }

        int resListSize = list.size();
        for (int i = 0; i < resListSize / 2; i++) amount[list.get(list.size() - 1 - i)] = 0;

        if (resListSize % 2 != 0) {
            int midIdx = resListSize / 2;
            amount[list.get(midIdx)] =  amount[list.get(midIdx)] / 2;
        }
    }

    //Time: O(N); Space: O(N)
    private static int helper_dfs(List<Integer>[] graph, int node, int[] amount, boolean[] seen) {
        int res = Integer.MIN_VALUE;
        seen[node] = true;
        for (int nextNode : graph[node]) {
            if (seen[nextNode] == true) continue;
            res = Math.max(res, helper_dfs(graph, nextNode, amount, seen));
        }
        return res == Integer.MIN_VALUE ? amount[node] : amount[node] + res;
    }
    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{1,3},{3,4}};
        int bob = 3;
        int [] amount = {-2,4,2,-4,6};
        System.out.println(mostProfitablePath_1(edges,bob,amount));
    }
}
