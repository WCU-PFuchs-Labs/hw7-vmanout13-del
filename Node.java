public abstract class Node {
    protected Node lChild, rChild;

    public void traverse(Collector c) {
        c.collect(this);
        if (lChild != null) lChild.traverse(c);
        if (rChild != null) rChild.traverse(c);
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
        return this instanceof Unop;
    }
    public abstract double eval(double[] data);
    public abstract String toString();
    public void addRandomKids(NodeFactory n, int maxDepth, java.util.Random rand) {
        if (maxDepth <= 1) {
            lChild = new Unop(rand.nextInt(n.getNumVars()));
            rChild = new Unop(rand.nextInt(n.getNumVars()));
        } else {
            lChild = rand.nextBoolean()
                ? new Unop(rand.nextInt(n.getNumVars()))
                : n.getOperator(rand);
            rChild = rand.nextBoolean()
                ? new Unop(rand.nextInt(n.getNumVars()))
                : n.getOperator(rand);
            if (!(lChild instanceof Unop)) {
                lChild.addRandomKids(n, maxDepth - 1, rand);
            }
            if (!(rChild instanceof Unop)) {
                rChild.addRandomKids(n, maxDepth - 1, rand);
            }
        }
    }
}

