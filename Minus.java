public class Minus extends Binop {
    public Minus() {}
    public Minus(Node l, Node r) { super(l, r); }
    public double eval(double[] data) {
        return lChild.eval(data) - rChild.eval(data);
    }
    public String toString() {
        return "(" + lChild + " - " + rChild + ")";
    }
}
