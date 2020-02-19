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

    }

    public static void padovan() {
        boolean verif = false;
        int limite = 0;
        while (!verif) {
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
