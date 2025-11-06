public class Unop extends Node {
    private int varIndex;

    public Unop(int varIndex) {
        this.varIndex = varIndex;
    }

    public double eval(double[] data) {
        return data[varIndex];
    }

    public String toString() {
        return "x" + varIndex;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
