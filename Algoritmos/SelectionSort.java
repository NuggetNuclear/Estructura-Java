package Algoritmos;
import java.util.Scanner;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length; // Tamaño del arreglo
        
        for (int i = 0; i < n - 1; i++) {
            int IndiceMenor = i; // Almacena el índice del elemento mas pequeño
            
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[IndiceMenor]) { // Si el elemento actual es menor que el elemento mas pequeño
                    IndiceMenor = j; // Actualiza el índice del elemento mas pequeño
                }
            }
            
            int temp = arr[IndiceMenor]; // Intercambia el elemento actual con el elemento mas pequeño
            arr[IndiceMenor] = arr[i];
            arr[i] = temp;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tamaño del arreglo: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.println("\nIngrese el dato N°: " + (i + 1));
            arr[i] = scanner.nextInt();
        }

        // Imprime el arreglo en el orden ingresado

        System.out.println("Arreglo desordenado:\n");

        for (int i = 0; i < size; i++) {
            System.out.println(arr[i] + " Posición: " + i);
        }

        selectionSort(arr); // Llama a la función selectionSort, que es la encargada de ordenar los datos usando Selection Sort

        // Imprime el arreglo ordenado

        System.out.println("\nArreglo ordenado:\n");

        for (int i = 0; i < size; i++) {
            System.out.println(arr[i] + " Posición: " + i);
        }

        scanner.close(); // Cierra el scanner
    }
}