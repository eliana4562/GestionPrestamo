import java.util.Scanner;
public class App {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int option;

        System.out.println("---------------------------------------------");
        System.out.println("Sistema de Gestión de Préstamo");
        System.out.println("---------------------------------------------");

        do {
            System.out.println("MENÚ");
            System.out.println("1. ESTUDIANTES DE INGENIERIA");
            System.out.println("2. ESTUDIANTES DE DISEÑO");
            System.out.println("3. IMPRIMIR INVENTARIO TOTAL");
            System.out.println("4. SALIR DEL PROGRAMA");

            option = scanner.nextInt();

            EstudianteIngenieria estudianteIngenieria = new EstudianteIngenieria();

            EstudianteDiseno estudianteDiseno = new EstudianteDiseno();

            switch (option) {
                case 1:
                    estudianteIngenieria.menuEstudiantesIngenieria();
                    break;

                case 2:
                    estudianteDiseno.menuEstudiantesDiseno();
                    break;

                case 3:
                    System.out.println("Inventario Estudiantes de Ingeniería");
                    estudianteIngenieria.mostrarTodosLosPrestamos();
                    System.out.println("-----------------------------------");
                    System.out.println("Inventario Estudiantes de Diseño");
                    estudianteDiseno.mostrarTodosLosPrestamosDis();
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 4);
    }
}
