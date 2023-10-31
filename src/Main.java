import java.text.DecimalFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        int[][] matrix = MatrixUtilities.createRandomMatrix(1000, 5000);
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        ExecutorService executorService = Executors.newWorkStealingPool();

        long start = System.nanoTime();
        ExecutorMultiplication.multiplyMatrix(matrix, 2, executorService);
        long finish = System.nanoTime();
        long elapsed_time = finish - start;

        //MatrixUtilities.printMatrix(matrix);

        System.out.println("Executor: " + formatter.format(elapsed_time / 1000) + " Microseconds");

        int[][] forkMatrix = matrix;
        ForkJoinMultiplication forkJoinMultiplication = new ForkJoinMultiplication(forkMatrix, 2, 0, matrix.length);
        start = System.nanoTime();
        forkJoinPool.invoke(forkJoinMultiplication);
        finish = System.nanoTime();
        elapsed_time = finish - start;

        System.out.println("ForkJoin: " + formatter.format(elapsed_time / 1000) + " Microseconds");
        start = System.nanoTime();
        int[][] newMatrix = SequentialMultiplication.multiplyMatrix(matrix, 2);
        finish = System.nanoTime();
        elapsed_time = finish - start;

        System.out.println("Sequential: " + formatter.format(elapsed_time / 1000) + " Microseconds");
        //MatrixUtilities.printMatrix(newMatrix);

    }
}