public class Prestamo {
    private EstudianteIngenieria estudianteIng;
    private ComputadorPortatil computador;
    

    public Prestamo(EstudianteIngenieria estudianteIng, ComputadorPortatil computador) {
        this.estudianteIng = estudianteIng;
        this.computador = computador;
    }
   

    @Override
    public String toString() {
        return "Prestamo " +
                "\nEstudiante: " + estudianteIng.getNombre() + " " + estudianteIng.getApellido() +
                "\nCédula: " + estudianteIng.getCedula() +
                "\nTeléfono: " + estudianteIng.getTelefono() +
                "\nNúmero de Semestre: " + estudianteIng.getNumeroSemestre() +
                "\nPromedio Acumulado: " + estudianteIng.getPromedioAcumulado() +
                "\nSerial del Estudiante: " + estudianteIng.getSerial() +
                "\nComputador: " +
                "\nSerial: " + computador.getSerial() +
                "\nMarca: " + computador.getMarca() +
                "\nTamaño: " + computador.getTamano() +
                "\nPrecio: " + computador.getPrecio() +
                "\nSistema Operativo: " + computador.getSistemaOperativo() +
                "\nProcesador: " + computador.getProcesador() +
                "\n";
    }

    public Prestamo(){}

    

    public EstudianteIngenieria getEstudiante() {
        return estudianteIng;
    }

    public void setEstudiante(EstudianteIngenieria estudianteIng) {
        this.estudianteIng = estudianteIng;
    }

    public ComputadorPortatil getComputador() {
        return computador;
    }

    public void setComputador(ComputadorPortatil computador) {
        this.computador = computador;
    }
}
