package cn.edu.bupt.p146_152_graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 图的数组+链表实现
 */
public class GraphLinked {
    private Node[] vertex;
    private boolean[] isVisited;

    public static void main(String[] args) {

        String[] vertex = {"A", "B", "C", "D", "E", "F", "G", "H"};
        GraphLinked graph = new GraphLinked(vertex);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 7);
        graph.addEdge(4, 7);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(5, 6);

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

    public GraphLinked(String[] strings) {
        vertex = new Node[strings.length];
        for (int i = 0; i < strings.length; i++) {
            vertex[i] = new Node(strings[i], i);
        }
    }

    /**
     * 广度优先遍历
     */
    public void bfs() {
        isVisited = new boolean[vertex.length];
        System.out.print("BFS: ");
        for (Node node : vertex) {
            bfs(node);
        }
        System.out.println();
    }

    private void bfs(Node node) {
        if (node == null || isVisited[node.headIndex])
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        System.out.print(node + " -> ");
        isVisited[node.headIndex] = true;
        while (!queue.isEmpty()) {
            Node temp = vertex[queue.poll().headIndex];
            while (temp != null) {
                if (!isVisited[temp.headIndex]) {
                    queue.add(temp);
                    System.out.print(temp + " -> ");
                    isVisited[temp.headIndex] = true;
                }
                temp = temp.next;
            }
        }
    }

    // /**
    //  * 这个遍历有问题(结果只是凑巧)
    //  * 好像递归进行广度不行
    //  *
    //  * @param node
    //  */
    // private void bfs2(Node node) {
    //     if (node == null)
    //         return;
    //     if (!isVisited[node.headIndex]) {
    //         System.out.print(node + " -> ");
    //         isVisited[node.headIndex] = true;
    //     }
    //     node = vertex[node.headIndex];
    //     Node temp = node;
    //     boolean flag = false;
    //     while (temp != null) {
    //         if (!isVisited[temp.headIndex]) {
    //             System.out.print(temp + " -> ");
    //             isVisited[temp.headIndex] = true;
    //             flag = true;
    //         }
    //         temp = temp.next;
    //     }
    //     if (flag) {
    //         temp = node.next;
    //         while (temp != null) {
    //             if (!isVisited[temp.headIndex])
    //                 bfs2(temp);
    //             temp = temp.next;
    //         }
    //     }
    // }

    /**
     * 深度优先遍历
     */
    public void dfs() {
        isVisited = new boolean[vertex.length];
        System.out.print("DFS: ");
        for (Node node : vertex) {
            dfs(node);
        }
        System.out.println();
    }

    private void dfs(Node node) {
        if (node == null)
            return;
        int i = node.headIndex;
        if (i == -1 || isVisited[i])
            return;
        node = vertex[i];
        System.out.print(node + " -> ");
        isVisited[i] = true;
        while (node != null) {
            dfs(node);
            node = node.next;
        }
    }

    public void showGraph() {
        for (Node start : vertex) {
            while (start != null) {
                System.out.print(start + " -> ");
                start = start.next;
            }
            System.out.println();
        }
    }

    public void addEdge(int v1, int v2) {
        //无向图
        addEdgeOnce(v1, v2);
        addEdgeOnce(v2, v1);
    }

    private void addEdgeOnce(int v1, int v2) {
        Node temp = vertex[v1];
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(vertex[v2].name, v2);
    }

    private static class Node {
        private String name;
        private Node next;
        private int headIndex;

        Node(String name, int headIndex) {
            this.name = name;
            this.headIndex = headIndex;
        }

        @Override
        public String toString() {
            // return "Node{" +
            //         "name='" + name + '\'' +
            //         '}';
            return name;
        }
    }
}
