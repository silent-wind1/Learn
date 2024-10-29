package main.java.datastructure.graph;

import main.java.datastructure.queue.LinkQueue;

public class Graph {
    // 项目数目
    private final int v;
    // 边的数目
    private int E;
    // 邻接表
    private LinkQueue<Integer>[] adj;

    public Graph(int v) {
        // 初始化顶点数量
        this.v = v;
        // 初始化边的数量
        this.E = 0;
        // 初始化邻接表
        this.adj = new LinkQueue[v];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkQueue<Integer>();
        }
    }

    // 获取顶点数目
    public int V() {
        return v;
    }

    // 获取边的数目
    public int e() {
        return E;
    }

    public void addEdge(int v, int w) {
        /*
           在无向图中，边是没有方向的，所以该边既可以说是v到w的边，
           也可以说是w到v的边，因此需要让w出现在v的邻接表中，让v出现在w的邻接表中
         */
        adj[v].addQueue(w);
        adj[w].addQueue(v);
        // 边的数量+1
        E++;
    }

    // 获取和顶点v相领的所有顶点
    public LinkQueue<Integer> adj(int v) {
        return adj[v];
    }
}
