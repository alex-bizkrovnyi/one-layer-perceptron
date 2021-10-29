package ua.nure.bizkrovnyi.perceptron;

import ua.nure.bizkrovnyi.perceptron.network.Node;
import ua.nure.bizkrovnyi.perceptron.network.Perceptron;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Perceptron perceptron = new Perceptron(100);
        Node node = new Node();
        node.setLabel(1);
        node.setInputs(new double[]{1., 1.});

        Node node1 = new Node();
        node1.setLabel(1);
        node1.setInputs(new double[]{0., 1.});

        Node node2 = new Node();
        node2.setLabel(1);
        node2.setInputs(new double[]{1., 0.});

        Node node3 = new Node();
        node3.setLabel(-1);
        node3.setInputs(new double[]{0., 0.});

        List<Node> nodes = new ArrayList<>();
        nodes.add(node);
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);

        System.out.println("Model fit: " +  perceptron.fitModel(nodes));
        Node node4 = new Node();
        node4.setInputs(new double[] {1., 1.});
        System.out.println(perceptron.predict(node4));

        Node node5 = new Node();
        node5.setInputs(new double[] {0., 0.});
        System.out.println(perceptron.predict(node5));
    }
}
