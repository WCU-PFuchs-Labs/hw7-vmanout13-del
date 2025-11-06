public class Mult extends Binop {
    public Mult() {}
    public Mult(Node l, Node r) { super(l, r); }

    public double eval(double[] data) {
        return lChild.eval(data) * rChild.eval(data);
    }
    public String toString() {
        return "(" + lChild + " * " + rChild + ")";
    }
}
