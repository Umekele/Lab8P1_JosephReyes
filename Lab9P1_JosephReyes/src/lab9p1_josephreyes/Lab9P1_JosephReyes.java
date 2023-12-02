package lab9p1_josephreyes;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lab9P1_JosephReyes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int continuar = 0;

        do {
            System.out.println(" < - Game of Life - >");
            System.out.println("1. Jugar");
            System.out.println("0. Salir");
            continuar = scanner.nextInt();

            switch (continuar) {
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                case 1:
                    System.out.println("Ingresar el numero de rondas: ");
                    int rondas = scanner.nextInt();

                    int[][] tablero = new int[10][10];

                    for (int ronda = 1; ronda <= rondas; ronda++) {
                        generarTablero(tablero);
                        ArrayList<String> coordenadas = obtenerCoordenadas(tablero);
                        System.out.println("Ronda " + ronda + ":");
                        System.out.println("Coordenadas de las celdas vivas: ");
                        System.out.println(coordenadas);
                        mostrarTablero(tablero);
                    }
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (continuar != 0);
    }

    public static int[][] generarTablero(int[][] tablero) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i < 1 || i > 8 || j < 1 || j > 8) {
                    tablero[i][j] = 0;
                } else {
                    tablero[i][j] = random.nextInt(2);
                }
            }
        }
        return tablero;
    }

    public static void mostrarTablero(int[][] tablero) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("[");
                System.out.print(tablero[i][j]);
                if (j < 10) {
                    System.out.print("]");
                }
            }
            System.out.println("");
        }
    }
    
    public static ArrayList<String> obtenerCoordenadas(int[][] tablero) {
        ArrayList<String> coordenadas = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (tablero[i][j] == 1) {
                    coordenadas.add("(" + i + "," + j + ")");
                }
            }
        }
        return coordenadas;
    }

}
