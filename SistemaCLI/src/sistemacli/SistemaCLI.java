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
                    + "\n3.- Triángulo de Pascal"
                    + "\n4.- Salir");
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

                case "4":
                    System.exit(0);
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
        int a = 0;
        int b = 1;
        int c;

        System.out.println("ALGORITMO DE FIBONACCI");
        while (!verif) {
            System.out.println("***AVISO: El limite de entrada del sistema es de 2,147,483,647***");
            System.out.print("Introduzca el número limite para la serie de Fibonacci: ");
            String limiteS = scan.nextLine();
            if (comprobarOpcion(limiteS, 1)) {
                verif = true;
                limite = Integer.parseInt(limiteS);
                if (limite <= 0) {
                    System.out.println("El valor debe ser mayor a 0, escoga otro número");
                    verif = false;
                }
            }
        }

        System.out.println("===== Resultado =====");

        System.out.print(a + ", ");
        System.out.print(b);

        int contadorImpresion = 1;
        while (a + b <= limite) {
            c = a;
            a = b;
            b = c + a;
            if (b < 0) {
                break;
            } else {
                if (contadorImpresion > 10) {
                    System.out.print("\n" + b);
                    contadorImpresion = 1;
                } else {
                    System.out.print(", " + b);
                    contadorImpresion++;
                }
            }
        }

    }

    public static void padovan() {
        boolean verif = false;
        int limite = 0;
        while (!verif) {
            System.out.println("ALGORITMO DE PADOVAN");
            System.out.println("***AVISO: El limite de entrada del sistema es de 2,147,483,647***");
            System.out.println("Introduce hasta que número deseas obtener la sucesión de Padovan");
            System.out.println("Fin: ");
            String limiteS = scan.nextLine();
            if (comprobarOpcion(limiteS, 1)) {
                verif = true;
                limite = Integer.parseInt(limiteS);
                if (limite <= 0) {
                    System.out.println("El valor debe ser mayor a 0, escoga otro número");
                    verif = false;
                }
            }
        }
        //1828587033
        System.out.println("===== Resultado =====");
        int contadorImpresion = 1;
        if (limite < 1) {
            System.out.print("1");
        } else if (limite < 2) {
            System.out.print("1, 1");
        } else {
            System.out.print("1, 1, 1");
            int a = 1, b = 1, c = 1, d = 1;
            while (a + b <= limite) {
                d = a + b;
                a = b;
                b = c;
                c = d;
                if (d < 0) {
                    break;
                } else {
                    if (contadorImpresion > 10) {
                        System.out.print("\n" + d);
                        contadorImpresion = 1;
                    } else {
                        System.out.print(", " + d);
                        contadorImpresion++;
                    }
                }
            }
        }
    }

    public static void trianguloPascal() {

        boolean verif = false;
        long limite = 0;
        while (!verif) {
            System.out.println("ALGORITMO DE TRIÁNGULO DE PASCAL");
            System.out.println("Introduce hasta que número deseas obtener el triángulo de Pascal: ");
            String limiteS = scan.nextLine();
            if (comprobarOpcion(limiteS, 2)) {
                verif = true;
                limite = Long.parseLong(limiteS);
                if (limite <= 0 || limite > 150) {
                    System.out.println("El valor debe ser mayor a 0 y como límite de 150, escoga otro número");
                    verif = false;
                }
            }
        }

        System.out.println("===== Resultado =====");
        long[] aux = new long[1];

        for (long i = 1; i <= limite; i++) {
            long[] pascal = new long[(int) i];

            for (long k = limite; k > i; k--) {
                System.out.print(" ");
            }

            for (long j = 0; j < i; j++) {
                if (j == 0 || j == (i - 1)) {
                    pascal[(int) j] = 1;
                } else {
                    pascal[(int) j] = aux[(int) j] + aux[(int) j - 1];
                }
                System.out.print(pascal[(int) j] + " ");
            }

            aux = pascal;
            System.out.println();

        }

    }

    public static boolean comprobarOpcion(String num, int tipo) {
        int numE;
        long numEDos;
        boolean esEntero;
        if (tipo == 1) {
            try {
                numE = Integer.parseInt(num);
                esEntero = true;
            } catch (NumberFormatException e) {
                System.out.println("Error!!! El valor debe ser númerico entero. Es posible que tambien este insertando un valor mayor a 2,147,483,647");
                esEntero = false;
            }
        } else {
            try {
                numEDos = Long.parseLong(num);
                esEntero = true;
            } catch (NumberFormatException e) {
                System.out.println("Error!!! El valor debe ser númerico entero.");
                esEntero = false;
            }
        }
        return esEntero;
    }

}
