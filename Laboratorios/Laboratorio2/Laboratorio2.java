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

    public class Reproductor {
        private Queue<Song> playlist;
        private Stack<Song> history;

        public Reproductor() {
            this.playlist = new LinkedList<>();
            this.history = new Stack<>();
        }

        public void addSongToPlaylist(Song song) {
            playlist.add(song);
        }

        public void playNextSong() {
            if (!playlist.isEmpty()) {
                Song nextSong = playlist.poll();
                System.out.println("Now playing: " + nextSong.getNombre());
                history.push(nextSong);
            } else {
                System.out.println("Playlist is empty");
            }
        }

        public void playPreviousSong() {
            if (!history.isEmpty()) {
                Song previousSong = history.pop();
                System.out.println("Now playing: " + previousSong.getNombre());
                playlist.add(previousSong);
            } else {
                System.out.println("No previous songs in history");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Hola Mundo");
    }
}