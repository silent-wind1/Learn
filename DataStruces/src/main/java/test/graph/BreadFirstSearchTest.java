package main.java.test.graph;

import main.java.datastructure.graph.BreadFirstSearch;
import main.java.datastructure.graph.Graph;

public class BreadFirstSearchTest {
    public static void main(String[] args) {
        Graph graph = new Graph(13);
        graph.addEdge(0, 5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 11);
        graph.addEdge(9, 10);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);

        BreadFirstSearch search = new BreadFirstSearch(graph, 0);
        System.out.println(search.count());

        System.out.println("顶点5和顶点0是否相通:" + search.marked(5));
        System.out.println("顶点9和顶点0是否相通:" + search.marked(9));

    }
}
