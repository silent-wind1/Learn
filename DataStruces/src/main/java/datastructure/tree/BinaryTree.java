package main.java.datastructure.tree;

import main.java.datastructure.queue.LinkQueue;

public class BinaryTree<Key extends Comparable<Key>, Value> {
    private Node root;
    private int N;
    private class Node {
        public Key key;
        private Value value;
        public Node left;
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    // 获取元素个数
    public int length() {
        return N;
    }

    // 向指定的书x中添加key - value，并返回添加元素后新的树
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    // 向指定的树x中添加key-value，并返回添加元素后新的树
    public Node put(Node x, Key key, Value value) {
        // 如果x子数为空
        if (x == null) {
            N++;
            return new Node(key, value, null, null);
        }
        // 如果他不为空
        // 判断x结点的键和key的大小
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            // 如果key大于x结点的键， 则继续找x结点的右子树
            x.right = put(x.right, key, value);
        } else if (cmp < 0) {
            // 如果key小于x结点的键， 则继续找x结点的左子树
            x.left = put(x.left, key, value);
        } else {
            // 如果key等于x结点的键，则直接替换x结点的值为value即可
            x.value = value;
        }
        return x;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        // 如果他不为空
        // 判断x结点的键和key的大小
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            // 如果key大于x结点的键， 则继续找x结点的右子树
            return get(x.right, key);
        } else if (cmp < 0) {
            // 如果key小于x结点的键， 则继续找x结点的左子树
            return get(x.left, key);
        }
        // 如果上面的操作都没有执行说明找到了直接返回x值即可
        return x.value;
    }

    public void delete(Key key) {
        delete(root, key);
    }

    public Node delete(Node x, Key key) {
        // x树为空
        if (x == null) {
            return null;
        }
        // 如果树不为null
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            // 如果key大于x结点的键， 则继续找x结点的右子树
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            // 如果key小于x结点的键， 则继续找x结点的左子树
            x.left = delete(x.left, key);
        } else {
            N--;
            // 得找到右子树中最小的结点
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            // 删除右子树最小结点
            Node node = x.right;
            while (node.left != null) {
                if (node.left.left == null) {
                    node.left = null;
                } else {
                    node = node.left;
                }
            }
            // 让x结点的左子树称为minNode的左子树
            minNode.left = x.left;
            // 让x结点的右子树称为minNode的右子树
            minNode.right = x.right;
            // 让x结点的父结点指向minNode
            x = minNode;
        }
        return x;
    }


    public Key min() {
        return min(root).key;
    }

    public Node min(Node x) {
        if (x.left != null) {
            return min(x.left);
        } else {
            return x;
        }
    }

    public Key max() {
        return max(root).key;
    }

    public Node max(Node x) {
        if (x.right != null) {
            return max(x.right);
        } else {
            return x;
        }
    }

    // 获取整个树所有的键, 前序遍历
    public LinkQueue<Key> preErgodic() {
        LinkQueue<Key> queue = new LinkQueue<>();
        preErgodic(root, queue);
        return queue;
    }

    // 获取指定树x的所有键， 并放到key队列中
    public void preErgodic(Node x, LinkQueue<Key> keys) {
        if (x == null) {
            return;
        }
        // 把x结点的key放到keys中
        keys.addQueue(x.key);
        // 递归遍历x结点的左子树
        if (x.left != null) {
            preErgodic(x.left, keys);
        }
        // 递归遍历x结点的右子树
        if (x.right != null) {
            preErgodic(x.right, keys);
        }
    }

    public LinkQueue<Key> midErgodic() {
        LinkQueue<Key> queue = new LinkQueue<>();
        midErgodic(root, queue);
        return queue;
    }

    public void midErgodic(Node x, LinkQueue<Key> keys) {
        if (x == null) {
            return;
        }
        if (x.left != null) {
            midErgodic(x.left, keys);
        }

        keys.addQueue(x.key);

        if (x.right != null) {
            midErgodic(x.right, keys);
        }
    }

    public LinkQueue<Key> rightErgodic() {
        LinkQueue<Key> queue = new LinkQueue<>();
        rightErgodic(root, queue);
        return queue;
    }

    public void rightErgodic(Node x, LinkQueue<Key> keys) {
        if(x == null) {
            return;
        }

        if(x.left != null) {
            rightErgodic(x.left, keys);
        }

        if(x.right != null) {
            rightErgodic(x.right, keys);
        }

        keys.addQueue(x.key);
    }

    // 层序遍历
    public LinkQueue<Key> layerErgodic() {
        // 定义两个队列，分别存储树中的键和数中的结点
        LinkQueue<Key> keys = new LinkQueue<>();
        LinkQueue<Node> node = new LinkQueue<>();
        // 默认往队列中放入根节点
        node.addQueue(root);

        while (!node.isEmpty()) {
            // 从队列中弹出一个结点
            Node n = node.popQueue();
            // 把key放入到keys中
            keys.addQueue(n.key);
            // 判断当前结点还有没有左子节点
            if(n.left != null) {
                node.addQueue(n.left);
            }
            // 判断当前结点还有没有右子节点
            if(n.right != null) {
                node.addQueue(n.right);
            }
        }
        return keys;
    }
}

