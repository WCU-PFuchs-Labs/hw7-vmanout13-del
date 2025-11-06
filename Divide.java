public class Divide extends Binop {
    public Divide() {
        super();
    }

    public Divide(Node lChild, Node rChild) {
        super(lChild, rChild);
    }

    public double eval(double[] data) {
        double divisor = rChild.eval(data);
        if (Math.abs(divisor) < 0.0001) {
            return 1.0; // avoid infinity
        }
        return lChild.eval(data) / divisor;
    }

    public String toString() {
        return "(" + lChild + " / " + rChild + ")";
    }
}
