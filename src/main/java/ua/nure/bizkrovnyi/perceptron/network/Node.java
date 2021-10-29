package ua.nure.bizkrovnyi.perceptron.network;

/**
 * This class represents a pair of input
 */
public class Node {
    private double[] inputs;
    private int label;

    public Node() {
        super();
    }

    public Node(double[] inputs, int label) {
        super();
        this.inputs = inputs;
        this.label = label;
    }

    public double[] getInputs() {
        return inputs;
    }

    public void setInputs(double[] inputs) {
        this.inputs = inputs;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }
}
