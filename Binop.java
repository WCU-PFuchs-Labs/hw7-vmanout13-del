public abstract class Binop extends Node {
    public Binop() {}
    public Binop(Node l, Node r) { this.lChild = l; this.rChild = r; }
}
