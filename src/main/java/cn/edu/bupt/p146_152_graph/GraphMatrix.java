package cn.edu.bupt.p146_152_graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 图的邻接矩阵实现
 */
public class GraphMatrix {
    private ArrayList<String> vertexList = new ArrayList<>();
    private int[][] edges;
    private int numOfEdges;
    private boolean[] isVisited;

    public static void main(String[] args) {
        String[] vertex = {"A", "B", "C", "D", "E", "F", "G", "H"};
        GraphMatrix graph = new GraphMatrix(vertex);

        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(3, 7, 1);
        graph.addEdge(4, 7, 1);
        graph.addEdge(2, 5, 1);
        graph.addEdge(2, 6, 1);
        graph.addEdge(5, 6, 1);

        /*
          A B C D E F G H
        A 0 1 1 0 0 0 0 0
        B 1 0 0 1 1 0 0 0
        C 1 0 0 0 0 1 1 0
        D 0 1 0 0 0 0 0 1
        E 0 1 0 0 0 0 0 1
        F 0 0 1 0 0 0 1 0
        G 0 0 1 0 0 1 0 0
        H 0 0 0 1 1 0 0 0
         */
        graph.showGraph();
        graph.dfs();//A->B->D->H->E->C->F->G->
        graph.bfs();//A->B->C->D->E->F->G->H->
    }

    public GraphMatrix(String[] strings) {
        edges = new int[strings.length][strings.length];
        Collections.addAll(vertexList, strings);
    }

    public GraphMatrix(int[][] arr, String[] strings) {
        if (arr.length != strings.length)
            throw new RuntimeException("size not match.");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    numOfEdges++;
                }
            }
        }
        edges = arr;
        Collections.addAll(vertexList, strings);
    }

    /**
     * 图的广度优先遍历
     */
    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        System.out.print("BFS: ");
        for (int i = 0; i < vertexList.size(); i++) {
            bfs(i);
        }
        System.out.println();
    }

    /**
     * 结点的广度优先遍历
     * 入队列时访问并输出
     *
     * @param i
     */
    private void bfs(int i) {
        if (isVisited[i])
            return;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        System.out.print(vertexList.get(i) + " -> ");
        isVisited[i] = true;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int j = 0; j < vertexList.size(); j++) {
                if (edges[temp][j] != 0 && !isVisited[j]) {
                    queue.add(j);
                    System.out.print(vertexList.get(j) + " -> ");
                    isVisited[j] = true;
                }
            }
        }
    }

    /**
     * 结点的广度优先遍历2
     * 入队列时访问，出队列时输出
     *
     * @param i
     */
    private void bfs2(int i) {
        if (isVisited[i])
            return;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        isVisited[i] = true;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(vertexList.get(temp) + " -> ");
            for (int j = 0; j < vertexList.size(); j++) {
                if (edges[temp][j] != 0 && !isVisited[j]) {
                    queue.add(j);
                    isVisited[j] = true;
                }
            }
        }
    }

    /**
     * 图的深度优先遍历
     */
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        System.out.print("DFS: ");
        for (int i = 0; i < vertexList.size(); i++) {
            dfs(i);
        }
        System.out.println();
    }

    /**
     * 结点的深度优先遍历
     * 递归
     *
     * @param i
     */
    private void dfs(int i) {
        if (isVisited[i])
            return;
        System.out.print(vertexList.get(i) + " -> ");
        isVisited[i] = true;
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[i][j] != 0)
                dfs(j);
        }
    }

    private void showGraph() {
        System.out.print("  ");
        for (String s : vertexList) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (int i = 0; i < vertexList.size(); i++) {
            System.out.print(vertexList.get(i) + " ");
            for (int value : edges[i]) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public void addEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
