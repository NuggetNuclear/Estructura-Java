import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        Graph graph = new Graph("D:\\Code\\Stopify-4\\resources\\graph.csv");

        HashTable hashTable = new HashTable();
        Dijkstra dj = new Dijkstra();

        try(BufferedReader br = new BufferedReader(new FileReader("D:\\Code\\Stopify-4\\resources\\pairs.csv"))){
            String lineaActual;
            while((lineaActual = br.readLine()) != null){
                String[] partes = lineaActual.split(",");
                String song1 = partes[0];
                String song2 = partes[1];
                String camino = dj.caminoMasCorto(graph, song1, song2);
                if(camino != null) {
                    hashTable.insert(song1, song2, camino);
                } else {
                    System.out.println("No se encontró camino");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //graph.imprimirGrafo();

        hashTable.printTable();

    }
}
