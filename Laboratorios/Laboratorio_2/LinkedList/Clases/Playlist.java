import Implementaciones.ListaEnlazada;

public class Playlist {
    private String Nombre;
    private ListaEnlazada<Cancion> canciones;

    Playlist(String Nombre) {
        this.Nombre = Nombre;
        canciones = new ListaEnlazada<>();
    }

    // Getters

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public ListaEnlazada<Cancion> getCanciones() {
        return canciones;
    }

    public Cancion getCancion(int index) {
        return canciones.get(index);
    }

    // Métodos

    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    public void eliminarCancion(Cancion cancion) {
        canciones.remove(cancion);
    }

    public void editarPlaylist(int i, int j) {
        Cancion cancion1 = canciones.get(i);
        Cancion cancion2 = canciones.get(j);

        canciones.set(i, cancion2);
        canciones.set(j, cancion1);
    }
}