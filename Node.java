public void traverse(Collector c) {
    c.collect(this); // collect this node
    if (lChild != null) {
        lChild.traverse(c);
    }
    if (rChild != null) {
        rChild.traverse(c);
    }
}

public void swapLeft(Node trunk) {
    Node temp = this.lChild;
    this.lChild = trunk.lChild;
    trunk.lChild = temp;
}

public void swapRight(Node trunk) {
    Node temp = this.rChild;
    this.rChild = trunk.rChild;
    trunk.rChild = temp;
}

public boolean isLeaf() {
    // A leaf is typically a Unop (unary operator) or terminal node
    return this instanceof Unop || (lChild == null && rChild == null);
}
