package Laboratorios.Laboratorio_1;

import java.util.Scanner;
import java.util.Arrays;

public class Laboratorio_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = 0, n = 0;

        do {
            System.out.println("Ingrese dos numeros separados por un espacio: ");
            m = scanner.nextInt();
            n = scanner.nextInt();

            System.out.println("Numeros ingresados: " + m + " " + n);

        } while (m < 0 || m > 10000 || n < 0 || n > 10000);

        int[][] matriz = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int valorrr;
                do {
                    System.out.println("Ingrese el valor perteneciente a " + "[" + i + "][" + j + "]");
                    valorrr = scanner.nextInt();
                } while (valorrr < 0 || valorrr > Math.pow(10, 8));
                matriz[i][j] = valorrr;
            }
        }

        System.out.println("Matriz creada con éxito");

        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(matriz[i]));
        }


        System.out.println("Ingrese las filas para formar los pares (1-" + m + ") y (1-" + n + "): " );

        int f1 = scanner.nextInt() - 1;
        int f2 = scanner.nextInt() - 1;

        if (f1 >= m || f2 >= m) {
            System.out.println("Ingrese un numero valido");
        } else {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print("{" + matriz[f1][i] + "," + matriz[f2][j] + "} ");
                }
            }
            System.out.println(" ");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print("{" + matriz[f2][i] + "," + matriz[f1][j] + "} ");
                }
            }
        }
        scanner.close();
    }
}