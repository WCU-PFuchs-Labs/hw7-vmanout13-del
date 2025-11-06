import java.util.Random;

public class NodeFactory {
    private Binop[] ops;
    private int numVars;
    public NodeFactory(Binop[] ops, int numVars) {
        this.ops = ops;
        this.numVars = numVars;
    }
    public Binop getOperator(Random rand) {
        int i = rand.nextInt(ops.length);
        try {
            return ops[i].getClass().newInstance();
        } catch (Exception e) {
            return new Plus();
        }
    }
    public int getNumVars() { return numVars; }
}
