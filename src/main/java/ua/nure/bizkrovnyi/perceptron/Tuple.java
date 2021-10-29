package ua.nure.bizkrovnyi.perceptron;

public class Tuple<R, L> {
    R right;
    L left;

    public R getRight() {
        return right;
    }

    public L getLeft() {
        return left;
    }

    public Tuple(R right, L left) {
        this.right = right;
        this.left = left;
    }
}
