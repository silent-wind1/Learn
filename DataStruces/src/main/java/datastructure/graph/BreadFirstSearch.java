package main.java.datastructure.graph;

import main.java.datastructure.queue.LinkQueue;

public class BreadFirstSearch {
    private final boolean[] marked;
    private int count;
    private LinkQueue<Integer> waitSearch;

    public BreadFirstSearch(Graph g, int v) {
        this.marked = new boolean[g.V()];
        this.count = 0;
        this.waitSearch = new LinkQueue<Integer>();
        bfs(g, v);
    }

    private void bfs(Graph g, int v) {
//        让顶点v进入队列，带搜素
        waitSearch.addQueue(v);
//        通过循环，如果队列不为空，则从队列中弹出一个待搜素的顶点进行搜素
        while (!waitSearch.isEmpty()) {
            Integer wait = waitSearch.popQueue();
            if (!marked[wait]) {
                // 把wait里邻接表的下标全部添加添加到队列中
                for (Integer w : g.adj(wait)) {
                    waitSearch.addQueue(w);
                }
                //  把当前顶点v标识为已搜素
                marked[wait] = true;
                count++;
            }
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
}
