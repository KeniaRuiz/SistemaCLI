package sistemacli;

import java.util.Scanner;

public class SistemaCLI {

    static boolean continuar = true;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String option;
        String optionTwo;
        System.out.println("Bienvenido!");
        while (continuar) {
            System.out.println("Seleccione una opción para comenzar:"
                    + "\n1.- Fibonacci"
                    + "\n2.- Padovan"
                    + "\n3.- Triángulo de Pascal");
            option = scan.nextLine();
            switch (option) {
                case "1":
                    fibonacci();
                    break;

                case "2":
                    padovan();
                    break;

                case "3":
                    trianguloPascal();
                    break;

                default:
                    System.out.println("ERROR!!! Seleccione una opción correcta");
            }
            boolean continuarDos = true;
            while (continuarDos) {
                System.out.println("\n** ¿Desea continuar? **"
                        + "\n1.- Si"
                        + "\n2.- No");
                optionTwo = scan.nextLine();
                switch (optionTwo) {
                    case "1":
                        continuarDos = false;
                        break;

                    case "2":
                        continuarDos = false;
                        continuar = false;
                        break;

                    default:
                        System.out.println("opción inválida");
                        break;
                }
            }
        }
    }

    public static void fibonacci() {
        boolean verif = false;
        int limite = 0;
        int n1 = 0;
        int n2 = 1;

        while (!verif) {
            System.out.println("ALGORITMO DE FIBONACCI");
            System.out.print("Introduzca el número de términos para la serie de Fibonacci: ");
            String limiteS = scan.nextLine();
            if (comprobarOpcion(limiteS)) {
                verif = true;
                limite = Integer.parseInt(limiteS);
            }
        }

        while (limite == 0) {
            System.out.println("No puede introducir el número 0, escoga otro número");
            System.out.println("Introduzca un número mayor que 1: ");
            limite = scan.nextInt();
        }

        System.out.println("===== Resultado =====");

        System.out.print(n1 + " ");
        for (int i = 2; i <= limite; i++) {
            System.out.print(n2 + " ");
            n2 = n1 + n2;
            n1 = n2 - n1;
        }
    }

    public static void padovan() {
        boolean verif = false;
        int limite = 0;
        while (!verif) {
            System.out.println("ALGORITMO DE PADOVAN");
            System.out.println("Introduce hasta que número deseas obtener la sucesión de Padovan");
            System.out.println("Fin: ");
            String limiteS = scan.nextLine();
            if (comprobarOpcion(limiteS)) {
                verif = true;
                limite = Integer.parseInt(limiteS);
            }
        }
        System.out.println("===== Resultado =====");
        if (limite < 1) {
            System.out.print("1");
        } else if (limite < 2) {
            System.out.print("1, 1");
        } else if (limite < 3) {
            System.out.print("1, 1, 1");
        } else {
            System.out.print("1, 1, 1");
            int a = 1, b = 1, c = 1, d = 1;
            for (int i = 3; i <= limite; i++) {
                d = a + b;
                a = b;
                b = c;
                c = d;
                System.out.print(", " + d);
            }
        }
    }

    public static void trianguloPascal() {

        boolean verif = false;
        int limite = 0;
        while (!verif) {
            System.out.println("ALGORITMO DE TRIÁNGULO DE PASCAL");
            System.out.println("Introduce hasta que número deseas obtener el triángulo de Pascal: ");
            String limiteS = scan.nextLine();
            if (comprobarOpcion(limiteS)) {
                verif = true;
                limite = Integer.parseInt(limiteS);
            }
        }

        while (limite == 0) {
            System.out.println("No puede introducir el número 0, escoga otro número");
            System.out.println("Introduzca un número mayor que 1: ");
            limite = scan.nextInt();
        }

        if (limite > 150) {
            System.out.println("El limite de columnas es de 150");
            System.out.println("Introduzca un número menor: ");
            limite = scan.nextInt();

        } else {

            System.out.println("===== Resultado =====");
            int[] aux = new int[1];

            for (int i = 1; i <= limite; i++) {
                int[] pascal = new int[i];

                for (int k = limite; k > i; k--) {
                    System.out.print(" ");
                }

                for (int j = 0; j < i; j++) {
                    if (j == 0 || j == (i - 1)) {
                        pascal[j] = 1;
                    } else {
                        pascal[j] = aux[j] + aux[j - 1];
                    }
                    System.out.print(pascal[j] + " ");
                }

                aux = pascal;
                System.out.println();

            }

        }

    }

    public static boolean comprobarOpcion(String num) {
        int numE;
        boolean esEntero;
        try {
            numE = Integer.parseInt(num);
            esEntero = true;
        } catch (NumberFormatException e) {
            System.out.println("Error!!! El valor debe ser númerico entero");
            esEntero = false;
        }
        return esEntero;
    }

}
