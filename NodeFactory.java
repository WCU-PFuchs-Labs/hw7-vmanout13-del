import java.util.Random;

public class NodeFactory {
    private Binop[] ops;
    private int numVars;

    public NodeFactory(Binop[] ops, int numVars) {
        this.ops = ops;
        this.numVars = numVars;
    public int getNumVars() { return numVars; }

    }

    public Binop getOperator(Random rand) {
        // Returns a random Binop (Plus, Minus, Mult, Divide)
        int i = rand.nextInt(ops.length);
        try {
            return ops[i].getClass().newInstance();
        } catch (Exception e) {
            return new Plus(); // fallback
        }
    }

    public void addRandomKids(Node parent, int depth, Random rand) {
        if (depth <= 1) {
            parent.lChild = new Unop(rand.nextInt(numVars));
            parent.rChild = new Unop(rand.nextInt(numVars));
        } else {
            parent.lChild = rand.nextBoolean() ?
                new Unop(rand.nextInt(numVars)) :
                getOperator(rand);
            parent.rChild = rand.nextBoolean() ?
                new Unop(rand.nextInt(numVars)) :
                getOperator(rand);

            if (!(parent.lChild instanceof Unop)) {
                addRandomKids(parent.lChild, depth - 1, rand);
            }
            if (!(parent.rChild instanceof Unop)) {
                addRandomKids(parent.rChild, depth - 1, rand);
            }
        }
    }
}
