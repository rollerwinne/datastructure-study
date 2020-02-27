package cn.edu.bupt.p146_152_graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 图的数组+链表实现
 * 性能比较差：遍历会多次调用getNodeIndex
 * 没有在结点中存储头结点的数组下标
 */
public class GraphLinkedBad {
    private Node[] vertex;
    private boolean[] isVisited;

    public static void main(String[] args) {

        String[] vertex = {"A", "B", "C", "D", "E", "F", "G", "H"};
        GraphLinkedBad graph = new GraphLinkedBad(vertex);

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

    public GraphLinkedBad(String[] strings) {
        vertex = new Node[strings.length];
        for (int i = 0; i < strings.length; i++) {
            vertex[i] = new Node(strings[i]);
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
        if (node == null || isVisited(node))
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        System.out.print(node + " -> ");
        visit(node);
        while (!queue.isEmpty()) {
            int k = getNodeIndex(queue.poll());
            Node temp = vertex[k];
            while (temp != null) {
                if (!isVisited(temp)) {
                    queue.add(temp);
                    System.out.print(temp + " -> ");
                    visit(temp);
                }
                temp = temp.next;
            }
        }
    }

    private void visit(Node node) {
        int i = getNodeIndex(node);
        isVisited[i] = true;
    }

    private boolean isVisited(Node node) {
        int i = getNodeIndex(node);
        return i != -1 && isVisited[i];
    }

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
        int i = getNodeIndex(node);
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
        temp.next = new Node(vertex[v2].name);
    }

    // private Node getHeadNode(Node node){
    //     int i=getNodeIndex(node);
    //     if (i==-1){
    //         return null;
    //     }
    //     return vertex[i];
    // }

    /**
     * 获取结点对应的头结点
     *
     * @param node
     * @return
     */
    private int getNodeIndex(Node node) {
        if (node == null)
            return -1;
        for (int i = 0; i < vertex.length; i++) {
            if (node.name.equals(vertex[i].name)) {
                return i;
            }
        }
        return -1;
    }

    private static class Node {
        private String name;
        private Node next;

        Node(String name) {
            this.name = name;
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
