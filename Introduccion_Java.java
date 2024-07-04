import java.util.Scanner;

public class Introduccion_Java {

    public static void main(String[] args) {

        System.out.println("Hola Mundo"); 
        System.out.print("Hola Mundo"); 

        /* System.out.Printl() : Output con salto de linea
         * System.out.Print()  : Output sin salto de linea 
         */
        
        // Variables

        int x = 0; // variable de tipo integer
        double y = 0.0; // variable de tipo double
        char z = 'a'; // variable de tipo char
        boolean w = true; // variable de tipo boolean

        System.out.println(x + "" + y + "" + z + "" + w);

        // Operadores

        int a = 5;
        int b = 3;

        System.out.println(a + b); // Suma
        System.out.println(a - b); // Resta
        System.out.println(a * b); // Multiplicacion
        System.out.println(a / b); // Division
        System.out.println(a % b); // Modulo

        // Entrada de datos

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        int num = sc.nextInt();
        System.out.println("El numero ingresado es: " + num);
        sc.close();

        // Condicionales

        if (num > 0) {
            System.out.println("El numero es positivo");
        } else if (num < 0) {
            System.out.println("El numero es negativo");
        } else {
            System.out.println("El numero es cero");
        }

        // Bucles

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        int g = 0;
        while (g < 5) {
            System.out.println(g);
            g++;
        }

        int k = 0;
        do {
            System.out.println(k);
            k++;
        } while (k < 5);

        // Arreglos

        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        // Matrices

        int[][] mat = new int[3][3];
        mat[0][0] = 1;
        mat[0][1] = 2;
        mat[0][2] = 3;
        mat[1][0] = 4;
        mat[1][1] = 5;
        mat[1][2] = 6;
        mat[2][0] = 7;
        mat[2][1] = 8;
        mat[2][2] = 9;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Funciones

    public static int suma(int a, int b) {
        return a + b;
    }
    

    public static void imprimir(int a) {
        System.out.println(a);
    }

    // Clases

    public class Persona {
        private String nombre;
        private int edad;

        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }
    }

    // Herencia

    public class Estudiante extends Persona {

        // Extends: Hereda los atributos y metodos de la clase Persona

        private int matricula;

        public Estudiante(String nombre, int edad, int matricula) {
            super(nombre, edad);
            this.matricula = matricula;
        }

        public int getMatricula() {
            return matricula;
        }

        public void setMatricula(int matricula) {
            this.matricula = matricula;
        }
    }

    // Polimorfismo

    public class Animal {
        public void sonido() {
            System.out.println("Sonido de un animal");
        }
    }

    public class Perro extends Animal {
        @Override

        // @Override: Sobreescribe el metodo sonido de la clase Animal

        public void sonido() {
            System.out.println("Guau guau");
        }
    }
}
