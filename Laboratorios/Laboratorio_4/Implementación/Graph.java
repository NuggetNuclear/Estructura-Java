import java.io.BufferedReader;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    public record Arista(String destino, int costoArista, char letra) {
    }

    private HashMap<String, ArrayList<Arista>> listaAdyacencia;

    public Graph(String rutaCSV) throws Exception {
        listaAdyacencia = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader(rutaCSV));

        String lineaActual = br.readLine();
        while ((lineaActual = br.readLine()) != null) {
            String[] datos = lineaActual.split(",");
            String song1 = datos[0];
            String song2 = datos[1];
            int costoArista = Integer.parseInt(datos[2]);
            char letra = datos[3].charAt(0);
            agregarConexion(song1, song2, costoArista, letra);
        }

        br.close();
    }

    public void agregarConexion(String origen, String destino, int costoArista, char letra) {
        listaAdyacencia.computeIfAbsent(origen, k -> new ArrayList<>()).add(new Arista(destino, costoArista, letra));
        listaAdyacencia.computeIfAbsent(destino, k -> new ArrayList<>()).add(new Arista(origen, costoArista, letra));
    }

    public ArrayList<Arista> obtenerConexiones(String vertice) {
        return listaAdyacencia.getOrDefault(vertice, new ArrayList<>());
    }

    public void imprimirGrafo() {
        System.out.println("Grafo:");
        for (String vertice : listaAdyacencia.keySet()) {
            System.out.print(vertice + " -> ");
            ArrayList<Arista> conexiones = listaAdyacencia.get(vertice);
            for (Arista conexion : conexiones) {
                System.out.print(conexion.destino + " ");
            }
            System.out.println();

        }
    }
}