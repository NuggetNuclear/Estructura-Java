package Algoritmos;

import Implementacion.Cancion;

public class Sorts {

    public static Cancion[] mergeSort(Cancion[] Arreglo){
        if (Arreglo.length <= 1) return Arreglo;
        Cancion[] izquierda = new Cancion[Arreglo.length / 2];
        Cancion[] derecha = new Cancion[Arreglo.length - izquierda.length];

        System.arraycopy(Arreglo, 0, izquierda, 0, izquierda.length);
        System.arraycopy(Arreglo, izquierda.length, derecha, 0, derecha.length);

        mergeSort(izquierda);
        mergeSort(derecha);

        merge(Arreglo, izquierda, derecha);
        return Arreglo;
    }

    private static void merge(Cancion[] resultado, Cancion[] izquierda, Cancion[] derecha){
        int i = 0; int j = 0; int k = 0;

        while (i < izquierda.length && j < derecha.length){
            if (izquierda[i].getNombre().compareTo(derecha[j].getNombre()) < 0){
                resultado[k] = izquierda[i];
                i++;
            } else {
                resultado[k] = derecha[j];
                j++;
            }
            k++;
        }

        while (i < izquierda.length){
            resultado[k] = izquierda[i];
            i++;
            k++;
        }

        while (j < derecha.length){
            resultado[k] = derecha[j];
            j++;
            k++;
        }
    }

    public static Cancion[] quickSort(Cancion[] Arreglo){
        quickSort(Arreglo, 0, Arreglo.length - 1);
        return Arreglo;
    }

    private static void quickSort(Cancion[] Arreglo, int izquierda, int derecha){
        if (izquierda < derecha){
            int indiceParticion = particion(Arreglo, izquierda, derecha);
            quickSort(Arreglo, izquierda, indiceParticion - 1);
            quickSort(Arreglo, indiceParticion + 1, derecha);
        }
    }

    private static int particion(Cancion[] Arreglo, int izquierda, int derecha){
        Cancion pivote = Arreglo[derecha];
        int i = (izquierda - 1);
        for (int j = izquierda; j < derecha; j++){
            if (Arreglo[j].getNombre().compareTo(pivote.getNombre()) < 0){
                i++;
                Cancion temp = Arreglo[i];
                Arreglo[i] = Arreglo[j];
                Arreglo[j] = temp;
            }
        }
        Cancion temp = Arreglo[i + 1];
        Arreglo[i + 1] = Arreglo[derecha];
        Arreglo[derecha] = temp;
        return i + 1;
    }

    public static Cancion[] insertionSort(Cancion[] Arreglo){
        for (int i = 1; i < Arreglo.length; i++){
            Cancion actual = Arreglo[i];
            int j = i - 1;
            while (j >= 0 && Arreglo[j].getNombre().compareTo(actual.getNombre()) > 0){
                Arreglo[j + 1] = Arreglo[j];
                j--;
            }
            Arreglo[j + 1] = actual;
        }
        return Arreglo;
    }

    public static Cancion[] bubbleSort(Cancion[] Arreglo){
        int n = Arreglo.length;
        boolean intercambiado;

        for (int i = 0; i < n - 1; i++){
            intercambiado = false;
            for (int j = 0; j < n - i - 1; j++){
                if (Arreglo[j].getNombre().compareTo(Arreglo[j + 1].getNombre()) > 0){
                    // Realizar intercambio
                    Cancion temp = Arreglo[j];
                    Arreglo[j] = Arreglo[j + 1];
                    Arreglo[j + 1] = temp;
                    intercambiado = true;
                }
            }
            // Si no se realizó ningún intercambio, el arreglo está ordenado
            if (!intercambiado) {
                break;
            }
        }
        return Arreglo;
    }
}