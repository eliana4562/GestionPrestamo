public class PrestamoDis {
    private EstudianteDiseno estudianteDis;
    private TabletaGrafica tableta;

    public PrestamoDis(EstudianteDiseno estudianteDis, TabletaGrafica tableta) {
        this.estudianteDis = estudianteDis;
        this.tableta= tableta;
    }

    @Override
    public String toString() {
        return "Prestamo " +
                "\nEstudiante: " + estudianteDis.getNombre() + " " + estudianteDis.getApellido() +
                "\nCédula: " + estudianteDis.getCedula() +
                "\nTeléfono: " + estudianteDis.getTelefono() +
                "\nNúmero de Semestre: " + estudianteDis.getModalidadEstudio() +
                "\nPromedio Acumulado: " + estudianteDis.getCantidadAsignaturas() +
                "\nSerial del Estudiante: " + estudianteDis.getSerial() +
                "\nComputador: " +
                "\nSerial: " + tableta.getSerial() +
                "\nMarca: " + tableta.getMarca() +
                "\nTamaño: " + tableta.getTamano() +
                "\nProcesador: " + tableta.getPrecio() +
                "\nPrecio: " + tableta.getAlmacenamiento() +
                "\nSistema Operativo: " + tableta.getPeso() +
                
                "\n";
    }

    public PrestamoDis(){}

    public EstudianteDiseno getEstudianteDis() {
        return estudianteDis;
    }

    public void setEstudianteDis(EstudianteDiseno estudianteDis) {
        this.estudianteDis = estudianteDis;
    }

    public TabletaGrafica getTableta() {
        return tableta;
    }

    public void setTableta(TabletaGrafica tableta) {
        this.tableta = tableta;
    }

    
}
