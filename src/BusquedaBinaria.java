import java.io.*;
import java.util.*;

public class BusquedaBinaria {

    public static int binarySearch(int arr[], int x) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == x) {
                return mid;
            }

            if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nombre del archivo de entrada: ");
            String archivoEntrada = sc.nextLine();

            File file = new File(archivoEntrada);
            Scanner lector = new Scanner(file);

            System.out.println("\n--- CONTENIDO DEL ARCHIVO (NÚMEROS ORDENADOS) ---");

            ArrayList<Integer> lista = new ArrayList<>();

            while (lector.hasNextLine()) {
                int num = Integer.parseInt(lector.nextLine());
                System.out.println(num);
                lista.add(num);
            }
            lector.close();

            int[] numeros = lista.stream().mapToInt(i -> i).toArray();

            System.out.print("\nNúmero a buscar: ");
            int x = sc.nextInt();

            int resultado = binarySearch(numeros, x);

            if (resultado == -1) {
                System.out.println("\nEl número " + x + " NO se encontró.");
            } else {
                System.out.println("\nEl número " + x + " se encontró en la posición: " + resultado);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
