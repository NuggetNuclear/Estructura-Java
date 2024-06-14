

import Implementaciones.listaEnlazada;
import java.util.Random;

public class Reproductor {

    private Playlist[] playlists = new Playlist[10];
    private Cancion[] colaReproduccion = new Cancion[10];
    private int indice;

    Reproductor() {
        indice = 0;
    }

    // Getters, Setters y Otros Métodos

    public Playlist[] getPlaylists() {
        return playlists;
    }

    public Playlist getPlaylist(int index) {
        return playlists[index];
    }

    public int size() {
        return (indice - 1);
    }

    public void anadirPlaylist(Playlist p) {
        if (indice >= playlists.length) {
            Playlist[] arregloAuxiliar = new Playlist[(int) (playlists.length * 1.5)];
            System.arraycopy(playlists, 0, arregloAuxiliar, 0, playlists.length);
            playlists = arregloAuxiliar;

        }
        playlists[indice] = p;
        indice++;
    }

    // Métodos Principales

    public void agregarCancionCola(Cancion c) {
        if (indice >= colaReproduccion.length) {
            Cancion[] arregloAuxiliar = new Cancion[(int) (colaReproduccion.length * 1.5)];
            System.arraycopy(colaReproduccion, 0, arregloAuxiliar, 0, colaReproduccion.length);
            colaReproduccion = arregloAuxiliar;
        }

        colaReproduccion[indice] = c;
        indice++;
    }

    public void eliminarCancionCola(Cancion c) {
        for (int i = 0; i < colaReproduccion.length; i++) {
            if (colaReproduccion[i].equals(c)) {
                colaReproduccion[i] = null;

                for (int j = i; j < colaReproduccion.length - 1; j++) {
                    colaReproduccion[j] = colaReproduccion[j + 1];
                }

                colaReproduccion[colaReproduccion.length - 1] = null;
                indice--;
            }
        }
    }

    public void reproducirColaEnOrden(listaEnlazada<Cancion> lista) {
        while (!lista.isEmpty()) {
            lista.remove().imprimirInformacion();
        }
    }

    public void reproducirPlaylistEnOrden(Playlist p) {
        for (int i = 0; i < p.getCanciones().length; i++) {
            p.getCancion(i).imprimirInformacion();
        }
    }

    public void reproducirPlaylistAleatorio(Playlist p) {
        if (p.getCanciones().length == 0) {
            System.out.println("La playlist está vacía");
        } else {
            Cancion[] colaAleatoria = desordenar(p.getCanciones());

            for (Cancion cancion : colaAleatoria) {
                cancion.imprimirInformacion();
            }
        }
    }

    public void reproducirIntercalandoAleatorio(Playlist p1, Playlist p2) {
        Cancion[] colaIntercalada = new Cancion[p1.getCanciones().length + p2.getCanciones().length];

        Cancion[] colaAleatoriaP1 = desordenar(p1.getCanciones());
        Cancion[] colaAleatoriaP2 = desordenar(p2.getCanciones());

        int menor = Math.min(colaAleatoriaP1.length, colaAleatoriaP2.length);

        for(int i = 0; i < menor; i++) {
            int j = 0;

            colaIntercalada[j] = colaAleatoriaP1[i];
            colaIntercalada[j + 1] = colaAleatoriaP2[i];

            j+= 2;
        }

        for (Cancion cancion : colaIntercalada) {
            cancion.imprimirInformacion();
        }
    }

    // Método auxiliar

    public Cancion[] desordenar(Cancion[] canciones) {
        Cancion[] colaAleatoria = new Cancion[canciones.length];

        System.arraycopy(canciones, 0, colaAleatoria, 0, canciones.length);

        Random random = new Random();

        for (int i = canciones.length - 1; i > 0; i--) {
            int indiceAleatorio = random.nextInt(i + 1);

            // Intercambia las canciones en las posiciones i e indiceAleatorio
            Cancion temp = colaAleatoria[i];
            colaAleatoria[i] = colaAleatoria[indiceAleatorio];
            colaAleatoria[indiceAleatorio] = temp;
        }

        return colaAleatoria;
    }
}