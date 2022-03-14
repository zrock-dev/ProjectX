import java.util.*;

public class Sala {
    int capacidad;
    String codigoSala;
    Map<Cliente, ArrayList<String>> butacasPorCliente;
    Map<String, ArrayList<String>> butacas;
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
            ArrayList<String> filaAsientos  = new ArrayList<>();
            String columnaLetra = String.valueOf(columnasCodigos[indexColumn]);
            for (int indexFila = 0; indexFila < cantidadFilas; indexFila++) {
                filaAsientos.add(columnaLetra + (indexFila +1));
            }
            butacas.put(columnaLetra, filaAsientos);
        }
    }

    public void showStatusAsientos(Cliente cliente){
        System.out.println(butacasPorCliente.get(cliente));
    }

    public void reservarButacas(int cantidad, String codigoColumna, Cliente cliente){
        ArrayList<String> asientosCliente = butacasPorCliente.get(cliente);
        if (cantidad <= 10){
            ArrayList<String> columna = butacas.get(codigoColumna);
            for (int i = 0; i < cantidad; i++) {
                asientosCliente.add(columna.remove(0));
            }
            butacasPorCliente.put(cliente, asientosCliente);
        }
    }

    public static void main(String[] args) {
        Sala sala = new Sala("A");
        Cliente cliente = new Cliente(1312, "santi Ago", "col",
                                "20/04/2003");
        sala.setCapacidad(100);
        sala.poblarButacas();
        sala.reservarButacas(4, "B", cliente);
        sala.reservarButacas(4, "A", cliente);
        sala.showStatusAsientos(cliente);
    }
}
