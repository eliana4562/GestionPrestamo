import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class EstudianteIngenieria extends Estudiante{

    private int numeroSemestre;
    private float promedioAcumulado;
    private String serial;
    private static LinkedList<Prestamo> prestamos = new LinkedList<>();

    public void menuEstudiantesIngenieria() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        


        do {
            System.out.println("MENU ESTUDIANTES DE INGENIERIA");
            System.out.println("1 Registrar préstamo de equipo");
            System.out.println("2 Modificar préstamo de equipo");
            System.out.println("3 Devolución de equipo");
            System.out.println("4 Buscar equipo");
            System.out.println("5 Volver al menú principal");
            
            opcion = sc.nextInt();

            EstudianteIngenieria objManejoMenu = new EstudianteIngenieria();

            switch (opcion) {
                case 1:
                    objManejoMenu.resgistrarPrestamoIng();
                    break;
                case 2:
                    objManejoMenu.modificarPrestamo();
                    break;
                case 3:
                    String MensajeDevEq = objManejoMenu.devolverEquipo();
                    System.out.println(MensajeDevEq);
                    break;
                case 4:
                    objManejoMenu.buscarEquipo();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private List<EstudianteIngenieria> solicitarInfoEstudiantes() {
        LinkedList<EstudianteIngenieria> estudianteingenieriaList = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        

        EstudianteIngenieria objInfo = new EstudianteIngenieria();

        

        System.out.print("Ingrese la Cédula del estudiante: ");
        objInfo.setCedula(sc.next());

        System.out.print("Ingrese el Nombre del estudiante: ");
        objInfo.setNombre(sc.next());

        System.out.print("Ingrese el Apellido del estudiante: ");
        objInfo.setApellido(sc.next());

        System.out.print("Ingrese el Teléfono del estudiante: ");
        objInfo.setTelefono(sc.next());

        System.out.print("Ingrese el Número de Semestre actualmente cursado: ");
        objInfo.setNumeroSemestre(sc.nextInt());

        System.out.print("Ingrese el Promedio Acumulado: ");
        objInfo.setPromedioAcumulado(sc.nextFloat());

        System.out.print("Ingrese el Serial del estudiante(carnet): ");
        objInfo.setSerial(sc.next());

        estudianteingenieriaList.add(objInfo);
        return estudianteingenieriaList;
    }

    private void resgistrarPrestamoIng()
    {
        EstudianteIngenieria estudiante = new EstudianteIngenieria();
        List<EstudianteIngenieria> estudiantes = estudiante.solicitarInfoEstudiantes(); 
        
        ComputadorPortatil computador = new ComputadorPortatil();
        List<ComputadorPortatil> computadores = computador.solicitarInfoComputador();
        
        if (!estudiantes.isEmpty() && !computadores.isEmpty()) {
            Prestamo prestamoIng = new Prestamo(estudiantes.get(0), computadores.get(0));
            prestamos.add(prestamoIng);
            System.out.println("Préstamo registrado exitosamente.");
        } else {
            System.out.println("No se pudo registrar el préstamo.");
        }
    }

    private Prestamo buscarPrestamoPorCedulaOSerial() {
        Scanner sc = new Scanner(System.in);
        String cedulaOSerial = sc.nextLine().trim(); //Elimina cualquier espacio
        for (Prestamo prestamo : prestamos) {
            EstudianteIngenieria estudiante = prestamo.getEstudiante();
            ComputadorPortatil computador = prestamo.getComputador();
            
            if (estudiante.getCedula().equalsIgnoreCase(cedulaOSerial) || computador.getSerial().equalsIgnoreCase(cedulaOSerial)) {
                return prestamo;
            }
        }
        return null;
    }

    private void modificarPrestamo() {
        System.out.println("Ingrese la cédula o el serial del equipo a modificar");
        Prestamo prestamo = buscarPrestamoPorCedulaOSerial();
        if (prestamo == null) {
            System.out.println("No se encontró ningún préstamo con la cédula o serial proporcionado.");
            return;
        }

        ComputadorPortatil computador = new ComputadorPortatil();
        List<ComputadorPortatil> computadores = computador.solicitarInfoComputador();
        
        if (!computadores.isEmpty()) {
            prestamo.getComputador().setSerial(computadores.get(0).getSerial());
            prestamo.getComputador().setMarca(computadores.get(0).getMarca());
            prestamo.getComputador().setTamano(computadores.get(0).getTamano());
            prestamo.getComputador().setPrecio(computadores.get(0).getPrecio());
            prestamo.getComputador().setSistemaOperativo(computadores.get(0).getSistemaOperativo());
            prestamo.getComputador().setProcesador(computadores.get(0).getProcesador());
            System.out.println("Préstamo modificado exitosamente.");
        } else {
            System.out.println("No se pudo modificar el préstamo.");
        }
    }

    private String devolverEquipo() 
    {
        System.out.println("Ingrese el serial del equipo o la cédula");
        Prestamo prestamo = buscarPrestamoPorCedulaOSerial();
        if (prestamo == null) {
            return "No se encontró ningún préstamo con la cédula o serial proporcionado.";
        }

        prestamos.remove(prestamo);
        return "Préstamo devuelto y eliminado del registro.";
    }

    private String buscarEquipo() 
    {
        System.out.println("Ingrese el serial del equipo o la cédula");
        Prestamo prestamo = buscarPrestamoPorCedulaOSerial();
        if (prestamo == null) {
            System.out.println("No se encontró ningún préstamo con la cédula o serial proporcionado.");
        } else {
            System.out.println("Prestamo encontrado:");
            System.out.println(prestamo);
        }
        return "Vuelva al menú principal";
    }

    public void mostrarTodosLosPrestamos() {
        if (!prestamos.isEmpty()) {
            System.out.println("Todos los préstamos registrados:");
            for (Prestamo prestamo : prestamos) {
                System.out.println(prestamo);
            }
        } else {
            System.out.println("No hay préstamos registrados para estudiantes de Ingenieria.");
        }
    }

    //------------------------------------------------------------------------------------------------------
    public EstudianteIngenieria() {}

    public EstudianteIngenieria(String cedula, String nombre, String apellido, String telefono, int numeroSemestre, float promedioAcumulado, String serial) {
        super(cedula, nombre, apellido, telefono);
        this.numeroSemestre = numeroSemestre;
        this.promedioAcumulado = promedioAcumulado;
        this.serial = serial;
    }
    
    

    public int getNumeroSemestre() {
        return numeroSemestre;
    }

    public void setNumeroSemestre(int numeroSemestre) {
        this.numeroSemestre = numeroSemestre;
    }

    public float getPromedioAcumulado() {
        return promedioAcumulado;
    }

    public void setPromedioAcumulado(float promedioAcumulado) {
        this.promedioAcumulado = promedioAcumulado;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public static LinkedList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public static void setPrestamos(LinkedList<Prestamo> prestamos) {
        EstudianteIngenieria.prestamos = prestamos;
    }
    
}
