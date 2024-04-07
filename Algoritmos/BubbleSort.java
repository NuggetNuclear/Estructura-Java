package Algoritmos;
import java.util.Scanner;

/*
* Bubble sort es un algoritmo de ordenamiento simple. Este algoritmo es ineficiente en listas 
* grandes y es por eso que se utiliza en listas pequeñas.
*/



public class BubbleSort {

    public static void sort(int[] arreglo) {

        int n = arreglo.length; // Obtiene el tamaño del arreglo
    
        for (int i = 0; i < n - 1; i++) { 
            for (int j = 0; j < n - i - 1; j++) {
    
                if (arreglo[j] > arreglo[j + 1]) {  // Si el elemento actual es mayor que el siguiente
                    int temp = arreglo[j];          // Almacena temporalmente el mayor
                    arreglo[j] = arreglo[j + 1];    // Reemplaza el mayor por el menor
                    arreglo[j + 1] = temp;          // Devuelve el elemento mayor a la posición que tenía el menor
                }
            }
        }
    }
    public static void main(String[] args) {

        // Ingreso de datos

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

        sort(arr); // Llama a la función sort, que es la encargada de ordenar los datos usando Bubble Sort

        // Imprime el arreglo ordenado

        System.out.println("\nArreglo ordenado:\n");

        for (int i = 0; i < size; i++) {
            System.out.println(arr[i] + " Posición: " + i);
        }

        scanner.close(); // Cierra el scanner
    }
}
