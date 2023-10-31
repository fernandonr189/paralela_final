

public class MatrixUtilities {
    public static int[][] createRandomMatrix(int cols, int rows) {
        int[][] randomMatrix = new int[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                randomMatrix[i][j] = (int)(Math.random() * 89 + 10);
            }
        }

        return randomMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            printArray(matrix[i]);
        }
    }

    public static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print("[" + arr[i] + "]");
        }
        System.out.println();
    }

    public static int getMatrixCount(int[][] matrix) {
        int count = matrix.length * matrix[0].length;

        return count;
    }
}