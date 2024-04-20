package Laboratorios.Laboratorio2;

public class Laboratorio2 {
    
    public class Song {
        private
        
        String nombre;
        String artista;
        String album;
        int duracion;

        public 
        
        Song(String nombre, String artista, String album, int duracion) {
            this.nombre = nombre;
            this.artista = artista;
            this.album = album;
            this.duracion = duracion;
        }

        String getNombre() {
            return this.nombre;
        }

        String getArtista() {
            return this.artista;
        }

        String getAlbum() {
            return this.album;
        }

        int getDuracion() {
            return this.duracion;
        }
    }
}