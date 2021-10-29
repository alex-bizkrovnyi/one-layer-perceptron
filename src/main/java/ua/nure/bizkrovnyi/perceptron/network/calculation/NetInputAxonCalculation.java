package ua.nure.bizkrovnyi.perceptron.network.calculation;

import ua.nure.bizkrovnyi.perceptron.network.Node;
import ua.nure.bizkrovnyi.perceptron.network.Perceptron;

import java.util.List;
import java.util.stream.IntStream;

public class NetInputAxonCalculation implements AxonCalculationFunction {

    public double calculate(Node node, List<Double> weights) {
        return IntStream
                .range(0, weights.size())
                .mapToDouble(i -> (i == weights.size() - 1 ? Perceptron.BIAS_WEIGHT : node.getInputs()[i]) * weights.get(i))
                .sum();
    }
}
