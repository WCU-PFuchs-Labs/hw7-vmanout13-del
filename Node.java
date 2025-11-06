public abstract class Node {
    protected Node lChild, rChild;

    /**
     * Preorder traversal for collecting nodes.
     */
    public void traverse(Collector c) {
        c.collect(this);
        if (lChild != null) lChild.traverse(c);
        if (rChild != null) rChild.traverse(c);
    }

    /**
     * Swap left child node with trunk left child.
     */
    public void swapLeft(Node trunk) {
        Node temp = this.lChild;
        this.lChild = trunk.lChild;
        trunk.lChild = temp;
    }

    /**
     * Swap right child node with trunk right child.
     */
    public void swapRight(Node trunk) {
        Node temp = this.rChild;
        this.rChild = trunk.rChild;
        trunk.rChild = temp;
    }

    /**
     * Return true if node is a Unop (leaf).
     */
    public boolean isLeaf() {
        // Suppose Unop is a subclass representing leaf nodes
        return this instanceof Unop;
    }

    public abstract double eval(double[] data);
    public abstract String toString();
}

