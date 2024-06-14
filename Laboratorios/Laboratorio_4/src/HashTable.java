public class HashTable {
    private static final int SIZE = 1_000_000;
    private static final int Potencia = 31;
    Par[] tabla;

    private static class Par {
        String song1;
        String song2;

        Par(String song1, String song2) {
            this.song1 = song1;
            this.song2 = song2;
        }
    }

    public HashTable() {
        tabla = new Par[SIZE];
    }

    private int hash(String s) {
        if(s == null) return 0;

        long valorHash = 0;
        long potenciaELPRIMO = 1;

        for(char c: s.toCharArray()){
            valorHash = (valorHash + (c - 'a' + 1) * potenciaELPRIMO) % SIZE;
            potenciaELPRIMO = (potenciaELPRIMO * Potencia) % SIZE;
        }

        return (int) valorHash;
    }

    public void insert(String song1, String song2, String path) {
        int indice = hash(path);
        if(indice < 0) {
            indice = -indice;
        }
        if(tabla[indice] == null) {
            tabla[indice] = new Par(song1, song2);
        } else {
            System.out.println("Colisión, no se insertará en el índice: " + indice);
            System.out.println("Canciones: " + song1 + " y " + song2 + ". ");
        }
    }

    public void printTable() {
        for(int i = 0; i < SIZE; i++) {
            if(tabla[i] != null) {
                System.out.println("Index " + i + ": (" + tabla[i].song1 + ", " + tabla[i].song2 + ")");
            }
        }
    }
}