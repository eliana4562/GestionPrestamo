import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

public class EstudianteDiseno extends Estudiante {
    
    private String modalidadEstudio;
    private int cantidadAsignaturas;
    private String serial;

    private static LinkedList<PrestamoDis> prestamosdis = new LinkedList<>();


    public void menuEstudiantesDiseno() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("MENU ESTUDIANTES DE DISEÑO");
            System.out.println("1 Registrar préstamo de equipo");
            System.out.println("2 Modificar préstamo de equipo");
            System.out.println("3 Devolución de equipo");
            System.out.println("4 Buscar equipo");
            System.out.println("5 Volver al menú principal");

            opcion = sc.nextInt();

            EstudianteDiseno objManejoMenu = new EstudianteDiseno();

            switch (opcion) {
                case 1:
                    objManejoMenu.resgistrarPrestamoDis();
                    break;
                case 2:
                    objManejoMenu.modificarPrestamo();
                    break;
                case 3:
                    String MensajeDevEq = objManejoMenu.devolverEquipo();
                    System.out.println(MensajeDevEq);
                    break;
                case 4:
                    String MensajeBuscEq = objManejoMenu.buscarEquipo();
                    System.out.println(MensajeBuscEq);
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private List<EstudianteDiseno> solicitarInfoEstudiantes() {
        LinkedList<EstudianteDiseno> estudianteDisenoList = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        

        EstudianteDiseno objInfo = new EstudianteDiseno();

        

        System.out.print("Ingrese la Cédula del estudiante: ");
        objInfo.setCedula(sc.next());

        System.out.print("Ingrese el Nombre del estudiante: ");
        objInfo.setNombre(sc.next());

        System.out.print("Ingrese el Apellido del estudiante: ");
        objInfo.setApellido(sc.next());

        System.out.print("Ingrese el Teléfono del estudiante: ");
        objInfo.setTelefono(sc.next());

        System.out.print("Ingrese la modalidad de estudio: ");
        objInfo.setModalidadEstudio(sc.next());

        System.out.print("Ingrese el cantidad de asignaturas: ");
        objInfo.setCantidadAsignaturas(sc.nextInt());

        System.out.print("Ingrese el Serial del estudiante(carnet): ");
        objInfo.setSerial(sc.next());

        estudianteDisenoList.add(objInfo);
        return estudianteDisenoList;
    }

    private void resgistrarPrestamoDis()
    {
        EstudianteDiseno estudiante = new EstudianteDiseno();
        List<EstudianteDiseno> estudiantes = estudiante.solicitarInfoEstudiantes(); //Se instancian las listas
        
        TabletaGrafica tableta = new TabletaGrafica();
        List<TabletaGrafica> tabletas = tableta.solicitarInfotTabletaGraficas();
        
        if (!estudiantes.isEmpty() && !tabletas.isEmpty()) {
            PrestamoDis prestamodis = new PrestamoDis(estudiantes.get(0), tabletas.get(0));
            prestamosdis.add(prestamodis);
            System.out.println("Préstamo registrado exitosamente.");
        } else {
            System.out.println("No se pudo registrar el préstamo.");
        }
    }

    private PrestamoDis buscarPrestamoPorCedulaOSerialDis() {
        Scanner sc = new Scanner(System.in);
        String cedulaOSerial = sc.nextLine().trim();
        for (PrestamoDis prestamodis : prestamosdis) {
            EstudianteDiseno estudianteDis = prestamodis.getEstudianteDis();
            TabletaGrafica tableta = prestamodis.getTableta();
            
            if (estudianteDis.getCedula().equalsIgnoreCase(cedulaOSerial) || 
                tableta.getSerial().equalsIgnoreCase(cedulaOSerial)) 
                {
                return prestamodis;
                }
        }
        
        return null;
    }

    private void modificarPrestamo() {
        System.out.println("Ingrese la cédula o el serial del equipo a modificar");
        PrestamoDis prestamodis = buscarPrestamoPorCedulaOSerialDis();
        if (prestamodis == null) {
            System.out.println("No se encontró ningún préstamo con la cédula o serial proporcionado.");
            return;
        }

        TabletaGrafica tableta = new TabletaGrafica();
        List<TabletaGrafica> tabletas = tableta.solicitarInfotTabletaGraficas();
        
        if (!tabletas.isEmpty()) {
            prestamodis.getTableta().setSerial(tabletas.get(0).getSerial());
            prestamodis.getTableta().setMarca(tabletas.get(0).getMarca());
            prestamodis.getTableta().setTamano(tabletas.get(0).getTamano());
            prestamodis.getTableta().setPrecio(tabletas.get(0).getPrecio());
            prestamodis.getTableta().setAlmacenamiento(tabletas.get(0).getAlmacenamiento());
            prestamodis.getTableta().setPeso(tabletas.get(0).getPeso());
            System.out.println("Préstamo modificado exitosamente.");
        } else {
            System.out.println("No se pudo modificar el préstamo porque no existe");
        }
    }

    private String devolverEquipo() 
    {
        System.out.println("Ingrese la cedula o serial del equipo");
        PrestamoDis prestamodis = buscarPrestamoPorCedulaOSerialDis();
        if (prestamodis == null) {
            return "No se encontró ningún préstamo con la cédula o serial proporcionado.";
        }

        prestamosdis.remove(prestamodis);
        return "Préstamo devuelto y eliminado del registro.";
    }

    private String buscarEquipo() 
    {
        System.out.println("Ingrese el serial del equipo o la cédula");
        PrestamoDis prestamodis = buscarPrestamoPorCedulaOSerialDis();
        if (prestamodis == null) {
            System.out.println("No se encontró ningún préstamo con la cédula o serial proporcionado.");
        } else {
            System.out.println("Prestamo encontrado:");
            System.out.println(prestamodis);
        }
        return "Vuelva al menú principal";
    }

    public void mostrarTodosLosPrestamosDis() {
        if (!prestamosdis.isEmpty()) {
            System.out.println("Todos los préstamos registrados:");
            for (PrestamoDis prestamodis : prestamosdis) {
                System.out.println(prestamodis);
            }
        } else {
            System.out.println("No hay préstamos registrados para estudiantes de Diseño.");
        }
    }


//-----------------------------------------------------------------------------------------------------------------------

    public EstudianteDiseno(String cedula, String nombre, String apellido, String telefono, String modalidadEstudio, int cantidadAsignaturas, String serial) {
        super(cedula, nombre, apellido, telefono);
        this.modalidadEstudio = modalidadEstudio;
        this.cantidadAsignaturas = cantidadAsignaturas;
        this.serial = serial;
    }

    public EstudianteDiseno(){}

    public String getModalidadEstudio() {
        return modalidadEstudio;
    }

    public void setModalidadEstudio(String modalidadEstudio) {
        this.modalidadEstudio = modalidadEstudio;
    }

    public int getCantidadAsignaturas() {
        return cantidadAsignaturas;
    }

    public void setCantidadAsignaturas(int cantidadAsignaturas) {
        this.cantidadAsignaturas = cantidadAsignaturas;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    
}
