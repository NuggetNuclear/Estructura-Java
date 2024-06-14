package Implementacion;

import java.util.*;
import java.io.*;

public class Stopify {
    private static List<Cancion> canciones;

    public Stopify() {
        canciones = new ArrayList<>();
    }

    // Metodo para añadir canciones
    public static void insertar(Cancion cancion) { canciones.add(cancion); }

    // Método para leer las canciones del csv
    public static void cargarCanciones(String nombreArchivo) throws IOException {
        String rutaArchivo = "D:\\Stopify-2\\" + nombreArchivo;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 3) {
                    int id = Integer.parseInt(datos[0]);
                    String titulo = datos[1];
                    int duracion = Integer.parseInt(datos[2]);
                    Cancion cancion = new Cancion(titulo, duracion);
                    cancion.setId(id);
                    insertar(cancion);
                } else {
                    System.out.println("Error en la linea");
                }
            }
            System.out.println("Archivos cargados desde: " + rutaArchivo + " | N° de canciones: " + canciones.size() + "\n");
        }
    }

    // Método para llamar al generador de archivos

    public static void llamarGenerador(int numeroDeArchivos) {
        int cantidadArchivos = numeroDeArchivos;

        String javaBin = System.getProperty("java.home") + "/bin/java";
        String classpath = System.getProperty("java.class.path");
        String className = "Auxiliares.TestGenerator";

        System.out.println("\nGenerando Archivos...");
        ProcessBuilder processBuilder = new ProcessBuilder(javaBin, "-cp", classpath, className, String.valueOf(cantidadArchivos));

        try {
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            if(exitCode == 0) {
                System.out.println("\nArchivos generados correctamente.");
            } else {
                System.out.println("\nEl generador de archivos falló.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Método para leer las duraciones de canciones del archivo csv
    public static void cargarDuraciones(String nombreArchivo) throws IOException {
        String rutaArchivo = "D:\\Stopify-2\\" + nombreArchivo;
        List<Integer> duraciones = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                int duracion = Integer.parseInt(linea.trim()); // Lee la duración como un número entero
                duraciones.add(duracion); // Agrega la duración a la lista
            }
            System.out.println("\nDuraciones cargadas desde: " + rutaArchivo + " | N° de duraciones: " + duraciones.size());
        }
    }

    public static void vaciarCanciones() { canciones.clear(); }

    public static void main(String[] args) {
        Stopify stopify = new Stopify();

        Cancion[] arregloMerge = null;
        Cancion[] arregloDesordenado = null;

        for (int a = 10; a <= 100000; a *= 10) {
            llamarGenerador(a);

            try {
                Stopify.cargarCanciones("songs.csv");
            } catch (IOException e) {
                e.printStackTrace();
            }

            arregloDesordenado = new Cancion[canciones.size()];
            arregloMerge = new Cancion[canciones.size()];
            Cancion arregloQuick[] = new Cancion[canciones.size()];
            Cancion arregloInsertion[] = new Cancion[canciones.size()];
            Cancion arregloBubble[] = new Cancion[canciones.size()];

            for (int i = 0; i < canciones.size(); i++) {
                arregloDesordenado[i] = canciones.get(i);
                arregloMerge[i] = canciones.get(i);
                arregloQuick[i] = canciones.get(i);
                arregloInsertion[i] = canciones.get(i);
                arregloBubble[i] = canciones.get(i);
            }

            System.out.println("Ordenando arreglos...\n");

            // Bubble Sort

            long startTime = System.nanoTime();
            Algoritmos.Sorts.bubbleSort(arregloBubble);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println("Bubble Sort: " + duration + " nanosegundos (" + ((double) duration / 1000000000.0) + " segundos.)");

            // Insertion Sort

            startTime = System.nanoTime();
            Algoritmos.Sorts.insertionSort(arregloInsertion);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            System.out.println("Insertion Sort: " + duration + " nanosegundos (" + ((double) duration / 1000000000.0) + " segundos.)");

            // Quick Sort

            startTime = System.nanoTime();
            Algoritmos.Sorts.quickSort(arregloQuick);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            System.out.println("Quick Sort: " + duration + " nanosegundos (" + ((double) duration / 1000000000.0) + " segundos.)");

            // Merge Sort

            startTime = System.nanoTime();
            Algoritmos.Sorts.mergeSort(arregloMerge);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            System.out.println("Merge Sort: " + duration + " nanosegundos (" + ((double) duration / 1000000000.0) + " segundos.)");

            vaciarCanciones();
        }

        // Construccion del arbol desbalanceado

        long unbalancedTreeStart = System.nanoTime();
        Tree unbalancedTree = new Tree();
        for (Cancion cancion : arregloDesordenado) {
            unbalancedTree.insertar(unbalancedTree.getRoot(), cancion);
        }
        long unbalancedTreeEnd = System.nanoTime();
        System.out.println("\nTiempo para construir el Árbol Desbalanceado: " + (unbalancedTreeEnd - unbalancedTreeStart) + " ns (" + (unbalancedTreeEnd - unbalancedTreeStart) / 1000000000.0 + " segundos.)");

        // Construcción del Árbol Balanceado

        long balancedTreeStart = System.nanoTime();
        Tree balancedTree = new Tree();
        for (Cancion cancion : arregloMerge) {
            balancedTree.insertar(balancedTree.getRoot(), cancion);
        }
        long balancedTreeEnd = System.nanoTime();
        System.out.println("Tiempo para construir el Árbol Balanceado: " + (balancedTreeEnd - balancedTreeStart) + " ns (" + (balancedTreeEnd - balancedTreeStart) / 1000000000.0 + " segundos.)");

        // Búsqueda de canciones por nombre

        try {
            Stopify.cargarCanciones("queriesPerName.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        long searchByNameStart = System.nanoTime();
        for (Cancion cancion : canciones) {
            unbalancedTree.buscarPorNombre(unbalancedTree.getRoot(), cancion.getNombre());
        }
        long searchByNameEnd = System.nanoTime();
        System.out.println("Tiempo para buscar canciones por nombre en el Árbol Desbalanceado: " + (searchByNameEnd - searchByNameStart) + " ns (" + (searchByNameEnd - searchByNameStart) / 1000000000.0 + " segundos.)");

        searchByNameStart = System.nanoTime();
        for (Cancion cancion : canciones) {
            balancedTree.buscarPorNombre(balancedTree.getRoot(), cancion.getNombre());
        }
        searchByNameEnd = System.nanoTime();
        System.out.println("Tiempo para buscar canciones por nombre en el Árbol Balanceado: " + (searchByNameEnd - searchByNameStart) + " ns (" + (searchByNameEnd - searchByNameStart) / 1000000000.0 + " segundos.)");

        // Búsqueda de canciones por duración

        try {
            Stopify.cargarDuraciones("queriesPerDuration.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        long searchByDurationStart = System.nanoTime();
        for (Cancion cancion : canciones) {
            unbalancedTree.buscarPorDuracion(unbalancedTree.getRoot(), cancion.getDuracion());
        }
        long searchByDurationEnd = System.nanoTime();
        System.out.println("Tiempo para buscar canciones por duración en el Árbol Desbalanceado: " + (searchByDurationEnd - searchByDurationStart) + " ns (" + (searchByDurationEnd - searchByDurationStart) / 1000000000.0 + " segundos.)");

        searchByDurationStart = System.nanoTime();
        for (Cancion cancion : canciones) {
            balancedTree.buscarPorDuracion(balancedTree.getRoot(), cancion.getDuracion());
        }
        searchByDurationEnd = System.nanoTime();
        System.out.println("Tiempo para buscar canciones por duración en el Árbol Balanceado: " + (searchByDurationEnd - searchByDurationStart) + " ns (" + (searchByDurationEnd - searchByDurationStart) / 1000000000.0 + " segundos.)");
    }
}