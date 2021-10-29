package ua.nure.bizkrovnyi.perceptron.network.calculation;

import ua.nure.bizkrovnyi.perceptron.Tuple;
import ua.nure.bizkrovnyi.perceptron.network.Node;

import java.util.List;

public interface AxonCalculationFunction {
    double calculate(Node node, List<Double> weights);
}
