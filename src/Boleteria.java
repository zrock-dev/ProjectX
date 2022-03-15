import java.util.*;

public class Boleteria {
    String name;
    Map<String, Sala> salaMap;
    Map<Integer, Cliente> registroClientes;
    Map<Sala,String[]> peliculasDia;
    int precioPelicula;

    public Boleteria(String name) {
        salaMap = new HashMap<>();
        registroClientes = new HashMap<>();
        peliculasDia = new Hashtable<>();
        this.name = name;
    }

    enum MetodoPago{
        TARJETA, QR, EFECTIVO
    }

    enum ModoPresentacion{
        BIDIMENSIONAL, TRIDIMENSIONAL
    }

    public double getPrecioPelicula() {
        return precioPelicula;
    }

    public void elegirModoPresentacion(ModoPresentacion modo){
        switch (modo){
            case BIDIMENSIONAL:
                precioPelicula = 40;
                break;
            case TRIDIMENSIONAL:
                precioPelicula = 50;
                break;
        }
    }


    public void comprarBoleto(int ci, MetodoPago metodo, String columnaAsiento, int cantidadAsientos,
                              String codigoSala){
        Boleto boleto = new Boleto(registroClientes.get(ci), precioPelicula, salaMap.get(codigoSala));
        boleto.aplicarDescuento(metodo);
        boleto.comprarAsientos(columnaAsiento, cantidadAsientos);
    }

    public void registrarCliente(int ci, String fullName, String nacionalidad, String fechaNacimiento){
        Cliente cliente = new Cliente(ci, fullName, nacionalidad, fechaNacimiento);
        registroClientes.put(ci, cliente);
    }

    public void tomarCartelerasSalas(){
        for (Sala sala:
             salaMap.values()) {
            peliculasDia.put(sala, sala.getCarteleraSala());
        }
    }

    public void showCartelera(){
        tomarCartelerasSalas();
        for (String[] carteleraSala:
             peliculasDia.values()) {
            System.out.println(Arrays.toString(carteleraSala));
        }
    }

    public void crearSalas(int cantidad){
        char[] letras = Utils.generarAbc(cantidad);
        for (int i = 0; i < cantidad; i++){
            String letra = String.valueOf(letras[i]);
            Sala sala = new Sala(letra);
            sala.llenarCarteleraSala();
            salaMap.put(letra, sala);
        }
    }

    public void setCapacidadSalas(){
        salaMap.get("A").setCapacidad(100);
        salaMap.get("B").setCapacidad(100);
        salaMap.get("C").setCapacidad(100);
        salaMap.get("D").setCapacidad(80);
        salaMap.get("E").setCapacidad(80);
        salaMap.get("F").setCapacidad(50);
        salaMap.get("G").setCapacidad(50);
    }
}
