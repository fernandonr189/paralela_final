import java.util.concurrent.RecursiveAction;

public class ForkJoinMultiplication extends RecursiveAction {

    private final int[][] matrix;
    private final int factor;

    private final int v_from;
    private final int v_to;

    public ForkJoinMultiplication(int[][] _matrix, int _factor, int v_from, int v_to) {
        this.matrix = _matrix;
        this.factor = _factor;
        this.v_from = v_from;
        this.v_to = v_to;
    }

    @Override
    protected void compute() {
        if((v_to - v_from) <= 1000) {
            multiply(matrix, factor, v_from, v_to);
            return;
        }

        int v_middle = ((v_to - v_from) / 2) + v_from;
        ForkJoinMultiplication taskOne = new ForkJoinMultiplication(matrix, factor, v_from, v_middle);
        ForkJoinMultiplication taskTwo = new ForkJoinMultiplication(matrix, factor, v_middle, v_to);

        taskOne.fork();
        taskTwo.compute();
        taskOne.join();
    }

    public static void multiply(int[][] matrix, int factor, int from, int to) {
        for(int i = from; i < to; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = matrix[i][j] * factor;
            }
        }
    }
}
