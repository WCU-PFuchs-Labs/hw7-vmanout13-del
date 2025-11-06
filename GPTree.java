import java.util.ArrayList;
import java.util.Random;

public class GPTree implements Collector {
    private Node root;
    private ArrayList<Node> crossNodes;

    // Implement Collector method
    public void collect(Node node) {
        if (!node.isLeaf()) {
            crossNodes.add(node);
        }
    }

    // Initialize crossNodes and traverse the tree
    public void traverse() {
        crossNodes = new ArrayList<Node>();
        root.traverse(this);
    }

    // Return all collected binop nodes as a string
    public String getCrossNodes() {
        StringBuilder string = new StringBuilder();
        int lastIndex = crossNodes.size() - 1;
        for (int i = 0; i < lastIndex; ++i) {
            Node node = crossNodes.get(i);
            string.append(node.toString());
            string.append(";");
        }
        string.append(crossNodes.get(lastIndex));
        return string.toString();
    }

    // Basic crossover implementation: left→left, right→right
    public void crossover(GPTree tree, Random rand) {
        this.traverse();
        tree.traverse();
        int thisPoint = rand.nextInt(this.crossNodes.size());
        int treePoint = rand.nextInt(tree.crossNodes.size());
        boolean left = rand.nextBoolean();

        Node thisTrunk = crossNodes.get(thisPoint);
        Node treeTrunk = tree.crossNodes.get(treePoint);

        if (left) {
            thisTrunk.swapLeft(treeTrunk);
        } else {
            thisTrunk.swapRight(treeTrunk);
        }
    }

    GPTree() {
        root = null;
    }

    public GPTree(NodeFactory n, int maxDepth, Random rand) {
        root = n.getOperator(rand);
        root.addRandomKids(n, maxDepth, rand);
    }

    public String toString() {
        return root.toString();
    }

    public double eval(double[] data) {
        return root.eval(data);
    }
}
