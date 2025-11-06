public class Divide extends Binop {
    public Divide() {}
    public Divide(Node l, Node r) { super(l, r); }
    public double eval(double[] data) {
        double num = lChild.eval(data);
        double den = rChild.eval(data);
        if (Math.abs(den) < 0.0001) return 1.0;
        return num / den;
    }
    public String toString() {
        return "(" + lChild + " / " + rChild + ")";
    }
}
