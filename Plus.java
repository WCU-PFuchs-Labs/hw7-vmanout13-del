public class Plus extends Binop {
    public Plus() {}
    public Plus(Node l, Node r) { super(l, r); }
    public double eval(double[] data) {
        return lChild.eval(data) + rChild.eval(data);
    }
    public String toString() {
        return "(" + lChild + " + " + rChild + ")";
    }
}
