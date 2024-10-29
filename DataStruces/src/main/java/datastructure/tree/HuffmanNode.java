package main.java.datastructure.tree;

public class HuffmanNode<T> {
    private T data; // 数据元素
    public double weight; // 权重
    public int parent;
    public int leftChild;
    public int rightChild;
    // 创建不带数据值的离散结点，即叶子结点，无左右孩子结点
    public HuffmanNode() {
        data = null;
        weight = 0.0;
        parent = 0;
        leftChild = rightChild = -1;
    }

    public HuffmanNode(T data, double weight) {
        this.data = data;
        this.weight = weight;
        parent = 0;
        leftChild = rightChild = -1;
    }

    public T getData() {
        return data;
    }
}
