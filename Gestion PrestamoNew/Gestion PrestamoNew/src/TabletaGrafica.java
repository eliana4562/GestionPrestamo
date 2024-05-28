import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class TabletaGrafica {
    private String serial;
    private String marca;
    private float tamano;
    private float precio;
    private String almacenamiento;
    private float peso;


    public List<TabletaGrafica> solicitarInfotTabletaGraficas() {
        LinkedList<TabletaGrafica> tabletaGraficasList = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        

        TabletaGrafica objInfo = new TabletaGrafica();

        

        System.out.print("Ingrese el serial de la tableta ");
        objInfo.setSerial(sc.next());

        System.out.print("Ingrese la marca de la tableta : ");
        objInfo.setMarca(sc.next());

        System.out.print("Ingrese el tamaño (pulgadas): ");
        objInfo.setTamano(sc.nextFloat());
       
        System.out.print("Ingrese el precio ");
        objInfo.setPrecio(sc.nextFloat());

        System.out.print("Ingrese el almacenamiento: ");
        objInfo.setAlmacenamiento(MenuAlmacenanmiento());

        System.out.print("Ingrese el peso: ");
        objInfo.setPeso(sc.nextFloat());

       tabletaGraficasList.add(objInfo);

        

        return tabletaGraficasList;
    }

    public String MenuAlmacenanmiento () {
        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.println("Seleccione el almacenamiento:");
        System.out.println("1. 256 GB");
        System.out.println("2. 512 GB");
        System.out.println("3. 1 TB");

        opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                return "256 GB";
            case 2:
                return "512 GB";
            case 3:
                return "1 TB";
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
                return MenuAlmacenanmiento();  
        }
    }




//--------------------------------------------------------------------------------------------------------------
    public TabletaGrafica(String serial, String marca, float tamano, float precio, String almacenamiento, float peso) {
        this.serial = serial;
        this.marca = marca;
        this.tamano = tamano;
        this.precio = precio;
        this.almacenamiento = almacenamiento;
        this.peso = peso;
    }

    public TabletaGrafica(){}

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

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
    
}
