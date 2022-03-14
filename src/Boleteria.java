import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Boleteria {
    Map<String, Sala> salaMap;
    Map<Integer, Cliente> registroClientes;
    String name;
    Map<Sala,String[]> peliculasDia;

    public Boleteria(String name) {
        salaMap = new HashMap<>();
        registroClientes = new HashMap<>();
        peliculasDia = new Hashtable<>();
        this.name = name;
    }

    enum MetodoPago{
        TARJETA, QR, EFECTIVO
    }

    public void comprarBoleto(Cliente  cliente, String generoPelicula, double precioPelicula,
                              MetodoPago metodo){
        int edadCliente = cliente.getEdad();
        if (edadCliente >= 60){
            precioPelicula -= (precioPelicula * .5);
        }else if (edadCliente <= 10 && generoPelicula.equals("animacion")){
            precioPelicula -= (precioPelicula * .15);
        }

        if (metodo == MetodoPago.TARJETA){
            precioPelicula -= precioPelicula * .12;
        }
    }

    public void registrarCliente(int ci, String fullName, String nacionalidad, String fechaNacimiento){
        Cliente cliente = new Cliente(ci, fullName, nacionalidad, fechaNacimiento);
        registroClientes.put(ci, cliente);
    }

    public void tomarCarteleraSala(){
        for (Sala sala:
             salaMap.values()) {
            peliculasDia.put(sala, sala.getCarteleraSala());
        }
    }

    public void crearSalas(int cantidad){
        char[] letras = Utils.generarAbc(cantidad);
        for (int i = 0; i < cantidad; i++){
            String letra = String.valueOf(letras[i]);
            Sala sala = new Sala(letra);
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
