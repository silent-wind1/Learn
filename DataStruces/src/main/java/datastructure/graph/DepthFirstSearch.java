package main.java.datastructure.graph;

public class DepthFirstSearch {
    // 索引代表顶点,值表示当前顶点是否已经被搜素
    private boolean[] marked;
    // 记录有多少个顶点与s顶点相桶
    private int count;

    public DepthFirstSearch(Graph G, int s) {
        this.marked = new boolean[G.V()];
        // 初始化跟顶点s想通的顶点的数量
        this.count = 0;
        dfs(G, s);
    }

    // 使用深度优先搜素找出G图中v顶点所有相通顶点
    private void dfs(Graph G, int v) {
        // 把v顶点标识标记为已搜素
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            // 判断w顶点有没有被搜素过，如果没有被搜素过，则递归调用dfs方法进行深度搜素
            if (!marked[w]) {
                dfs(G, w);
            }
        }
//        相同顶点数量+1
        count++;
    }

    //  判断w顶点与s顶点是否相通
    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
}
