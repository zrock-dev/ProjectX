import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

public class Sala {
    int capacidad;
    String codigoSala;
    Map<Cliente, String[]> butacasPorCliente;
    Map<String, String[]> butacas;
    String[] carteleraSala = new String[5];

    public Sala(String codigoSala){
        butacas = new Hashtable<>();
        butacasPorCliente = new Hashtable<>();
        this.codigoSala = codigoSala;
    }

    public String[] getCarteleraSala() {
        return carteleraSala;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void llenarCarteleraSala(){
        for (int index = 0; index < carteleraSala.length; index++) {
            int rndIndex = new Random().nextInt(Utils.generosPelicula.length);
            carteleraSala[index] = Utils.generosPelicula[rndIndex];
        }
    }

    public void poblarButacas(){
        int cantidadFilas = 10;
        int columnas = capacidad/cantidadFilas;
        char[] columnasCodigos = Utils.generarAbc(columnas);
        for (int indexColumn = 0; indexColumn < columnas; indexColumn++) {
            String[] codigosAsientoColumna = new String[cantidadFilas];
            String columnaLetra = String.valueOf(columnasCodigos[indexColumn]);
            for (int indexFila = 0; indexFila < codigosAsientoColumna.length; indexFila++) {
                codigosAsientoColumna[indexFila] = columnaLetra + (indexFila + 1);
            }
            butacas.put(columnaLetra, codigosAsientoColumna);
        }
    }

    public void showStatusAsientos(){
        for (String[] columnaAsientos:
             butacas.values()) {
            System.out.println(Arrays.toString(columnaAsientos));
        }
    }

    public void reservarButacas(int cantidad, String codigoColumna){
        if (cantidad <= 10){
            String[] columna = butacas.get(codigoColumna);
            for (int i = 0; i < cantidad; i++) {

                if (!columna[i].split(":")[0].equals("X")){
                    columna[i] = "X:" + columna[i];
                }
            }
        }
    }

    public static void main(String[] args) {
        Sala sala = new Sala("A");
        sala.setCapacidad(100);
        sala.poblarButacas();
        sala.reservarButacas(3, "A");
        sala.reservarButacas(4, "A");
        sala.reservarButacas(4, "A");
        sala.showStatusAsientos();
    }
}
