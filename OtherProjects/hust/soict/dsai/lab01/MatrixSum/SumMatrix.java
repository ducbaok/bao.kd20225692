package hust.soict.dsai.lab01.MatrixSum;
import java.util.Scanner;

public class SumMatrix{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows1, columns1, rows2, columns2;

        // Input the size of matrixs
        System.out.print("Enter the number of rows in the first matrix: ");
        rows1 = scanner.nextInt(); 
        System.out.print("Enter the number of columns in the first matrix: ");
        columns1 = scanner.nextInt();


        System.out.print("Enter the number of rows in the second matrix: ");
        rows2 = scanner.nextInt();
        System.out.print("Enter the number of columns in the second matrix: ");
        columns2 = scanner.nextInt();

        // Check if the sizes of both matrices match
        if (rows1 != rows2 || columns1 != columns2) {
            System.out.println("Error: Matrices must have the same size for addition.");
        } else {
            int[][] matrix1 = new int[rows1][columns1];
            int[][] matrix2 = new int[rows1][columns1];
            int[][] resultMatrix = new int[rows1][columns1];

            System.out.println("Enter elements for the first matrix:");
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < columns1; j++) {
                    System.out.print("Element [" + i + "][" + j + "]: ");
                    matrix1[i][j] = scanner.nextInt();
                }
            }


            System.out.println("Enter elements for the second matrix:");
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < columns1; j++) {
                    System.out.print("Element [" + i + "][" + j + "]: ");
                    matrix2[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < columns1; j++) {
                    resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }

            System.out.println("Sum of 2 input matrixs is:");
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < columns1; j++) {
                    System.out.print(resultMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        scanner.close();
    }
}
