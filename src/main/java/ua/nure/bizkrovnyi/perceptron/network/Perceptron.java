package ua.nure.bizkrovnyi.perceptron.network;

import ua.nure.bizkrovnyi.perceptron.network.activation.UnitStepActivationFunction;
import ua.nure.bizkrovnyi.perceptron.network.calculation.NetInputAxonCalculation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Perceptron {
    private int iteration;
    public static final double BIAS_WEIGHT = 1;
    private static final double WEIGHT_UPDATE_VALUE = 1;
    private List<Double> weights;

    public Perceptron(int iteration) {
        this.iteration = iteration;
    }

    private List<Double> initWeights(int countOfAxonsNode) {
        List<Double> weights = new ArrayList<>();
        for (int i = 0; i < countOfAxonsNode; i++) {
            weights.add(0.);
        }
        weights.add(BIAS_WEIGHT);
        return weights;
    }

    private void updateWeight(int activationFunctionResult, Node node, List<Double> weights) {
        IntStream
                .range(0, weights.size())
                .forEach(i -> {
                    double updatedWeight = weights.get(i) + WEIGHT_UPDATE_VALUE
                            * (node.getLabel() - activationFunctionResult)
                            * (i == weights.size() - 1 ? BIAS_WEIGHT : node.getInputs()[i]);
                    weights.set(i, updatedWeight);
                });
    }

    private boolean isModelFit(int activationFunctionResult, Node node, List<Double> weights) {
        if (activationFunctionResult == node.getLabel()) {
            System.out.println("Node matches: result: "+ activationFunctionResult + ". Node Label:" +node.getLabel());
            return true;
        } else {
            updateWeight(activationFunctionResult, node, weights);
            System.out.println("Weights updated: " + weights);
            return false;
        }
    }

    public boolean fitModel(List<Node> nodes) {
        weights = initWeights(nodes.get(0).getInputs().length);

        boolean isFit = IntStream.range(0, iteration)
                .anyMatch(iterationCount -> {
                    System.out.println("Iteration: " + iterationCount);
                    return nodes.stream().allMatch(node -> {
                        double netInputCalculationResult = new NetInputAxonCalculation().calculate(node, weights);
                        int activationFunctionResult = new UnitStepActivationFunction().tryActivate(netInputCalculationResult);
                        return isModelFit(activationFunctionResult, node, weights);
                    });
                });
        if (!isFit) {
            throw new IllegalArgumentException("Can not be fit");
        }
        return true;
    }

    public int predict(Node node) {
        double netInputCalculationResult = new NetInputAxonCalculation().calculate(node, weights);
        return new UnitStepActivationFunction().tryActivate(netInputCalculationResult);
    }
}
