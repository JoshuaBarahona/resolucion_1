/*registrar 2 estudiantes, registrar 6 asignaturas, notas y calcular el promedio 
y mostrar un mensaje que diga si el promedio es satisfactorio. */

import java.util.Scanner;

public class App {
    public static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) {
        

        System.out.print("Ingrese la cantidad de estudiantes a registrar: ");
        int numEstudiantes = leer.nextInt();
        leer.nextLine(); // Limpiar el buffer

        String[] nombresEstudiantes = new String[numEstudiantes];
        double[][] calificaciones = new double[numEstudiantes][6];

        for (int i = 0; i < numEstudiantes; i++) {
            System.out.println("Estudiante " + (i + 1));
            System.out.print("Ingrese el nombre del estudiante: ");
            nombresEstudiantes[i] = leer.nextLine();

            for (int j = 0; j < 6; j++) {
                try {
                    System.out.print("Ingrese la calificación de la asignatura " + (j + 1) + ": ");
                    calificaciones[i][j] = leer.nextDouble();
                } catch (Exception e) {
                    System.out.println("Error al ingresar la calificación. Intente nuevamente.");
                    j--; // Reintentar la misma asignatura
                    leer.nextLine(); // Limpiar el buffer
                }
            }
            leer.nextLine(); // Limpiar el buffer después de ingresar las calificaciones
        }

        // Calcular promedios individuales y mostrar mensaje
        for (int i = 0; i < numEstudiantes; i++) {
            double promedioEstudiante = calcularPromedio(calificaciones[i]);
            System.out.println("Estudiante: " + nombresEstudiantes[i]);
            System.out.println("Promedio: " + promedioEstudiante);
            if (promedioEstudiante >= 70.0) {
                System.out.println("Promedio satisfactorio.");
            } else {
                System.out.println("Promedio no satisfactorio.");
            }
        }
    }

    // Método para calcular el promedio de un estudiante
    public static double calcularPromedio(double[] calificaciones) {
        double sumaCalificaciones = 0;
        for (double calificacion : calificaciones) {
            sumaCalificaciones += calificacion;
        }
        return sumaCalificaciones / calificaciones.length;
    }
}
