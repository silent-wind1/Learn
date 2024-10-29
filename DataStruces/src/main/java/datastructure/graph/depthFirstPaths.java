package main.java.datastructure.graph;

import main.java.datastructure.stack.StackLink;

public class depthFirstPaths {
    private boolean[] makers;
    private int s;
    private int[] edgeTo;

    public depthFirstPaths(Graph G, int s) {
        this.makers = new boolean[G.V()];
        this.s = s;
        this.edgeTo = new int[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        // 把v表示为已搜素
        makers[v] = true;
//        遍历顶点v的领接表， 拿到每一个相领的顶点，继续递归搜素
        for (Integer w : G.adj(v)) {
//          如果顶点w没有被搜素，则继续递归调用
            if (!makers[w]) {
//              到达顶点w的路径上的最后一个顶点是v
                edgeTo[w] = w;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return makers[v];
    }

    public StackLink<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
//        创建栈对象，保存路径中的所有顶点
        StackLink<Integer> stack = new StackLink<>();
//        通过循环，从顶点v开始，一直往前找，找到起点为止
        for (int x = v; x != s; x = edgeTo[x]) {
            stack.push(x);
        }
//        把起点s放入栈中
        return stack;
    }
}
