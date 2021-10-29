package ua.nure.bizkrovnyi.perceptron.network.activation;

public class UnitStepActivationFunction implements ActivationFunction {
    public int tryActivate(double calculationResult) {
        return calculationResult >= 0 ? 1 : -1;
    }
}
