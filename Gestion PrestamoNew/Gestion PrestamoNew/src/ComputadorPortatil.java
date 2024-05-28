import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ComputadorPortatil {
    private String serial;
    private String marca;
    private float tamano;
    private float precio;
    private String sistemaOperativo;
    private String procesador;

    public List<ComputadorPortatil> solicitarInfoComputador() {
        LinkedList<ComputadorPortatil> ComputadorList = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        

        ComputadorPortatil objInfo = new ComputadorPortatil();

        

        System.out.print("Ingrese el serial del computador ");
        objInfo.setSerial(sc.next());

        System.out.print("Ingrese la marca del computador portátil: ");
        objInfo.setMarca(sc.next());

        System.out.print("Ingrese el tamaño (pulgadas): ");
        objInfo.setTamano(sc.nextFloat());
       
        System.out.print("Ingrese el precio ");
        objInfo.setPrecio(sc.nextFloat());

        System.out.print("Ingrese el Sistema Operativo: ");
        objInfo.setSistemaOperativo(MenuSistemaOp());

        System.out.print("Ingrese el procesador: ");
        objInfo.setProcesador(MenuProcesador());


        ComputadorList.add(objInfo);

        

        return ComputadorList;
    }

    public String MenuSistemaOp() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.println("Seleccione el Sistema Operativo:");
        System.out.println("1. Windows 7");
        System.out.println("2. Windows 10");
        System.out.println("3. Windows 11");

        opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                return "Windows 7";
            case 2:
                return "Windows 10";
            case 3:
                return "Windows 11";
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
                return MenuSistemaOp();  
        }
    }

    public String MenuProcesador() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.println("Seleccione el Procesador:");
        System.out.println("1. AMD Ryzen");
        System.out.println("2. Intel® Core™ i5");

        opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                return "AMD Ryzen";
            case 2:
                return "Intel® Core™ i5";
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
                return MenuProcesador();  
        }
    }

//-------------------------------------------------------------------------------------------------------
    public ComputadorPortatil(String serial, String marca, float tamano, float precio, String sistemaOperativo, String procesador) {
        this.serial = serial;
        this.marca = marca;
        this.tamano = tamano;
        this.precio = precio;
        this.sistemaOperativo = sistemaOperativo;
        this.procesador = procesador;
    }

    public ComputadorPortatil(){}

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getTamano() {
        return tamano;
    }

    public void setTamano(float tamano) {
        this.tamano = tamano;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }
    
}
