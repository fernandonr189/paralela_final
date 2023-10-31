public class SequentialMultiplication {
    public static int[][] multiplyMatrix(int[][] matrix, int factor) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            int[] newArr = multiplyRow(matrix[i], factor);
            newMatrix[i] = newArr;
        }
        return newMatrix;
    }

    public static int[] multiplyRow(int[] arr, int factor) {
        int[] newArr = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            int value = arr[i] * factor;
            newArr[i] = value;
        }
        return newArr;
    }
}
