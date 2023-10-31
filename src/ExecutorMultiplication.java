import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ExecutorMultiplication {
    public static void multiplyMatrix(int[][] matrix, int factor, ExecutorService executor) {
        Future<?> futureOne = executor.submit(() -> {
            multiply(matrix, factor, 0, matrix.length / 2);
        });

        Future<?> futureTwo = executor.submit(() -> {
           multiply(matrix, factor, matrix.length / 2, matrix.length);
        });

        try {
            futureOne.get();
            futureTwo.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public static void multiply(int[][] matrix, int factor, int from, int to) {
        for(int i = from; i < to; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = matrix[i][j] * factor;
            }
        }
    }
}
