public class Boleto {
    int precioPelicula;
    int cantidadAsientos;
    int puntosCliente = 50;
    Cliente cliente;
    Sala salaAsignada;
    String generoPelicula;

    public Boleto(Cliente cliente, int precioPelicula, Sala sala){
        this.cliente = cliente;
        this.precioPelicula = precioPelicula;
        this.salaAsignada = sala;
    }

    public void setGeneroPelicula(String generoPelicula) {
        this.generoPelicula = generoPelicula;
    }

    public void aplicarDescuento(Boleteria.MetodoPago metodo){
        int edadCliente = cliente.getEdad();
        if (edadCliente >= 60){
            precioPelicula -= (precioPelicula * .5);
            puntosCliente -= (puntosCliente *.5);
        }else if (edadCliente <= 10 && generoPelicula.equals("Animacion")){
            precioPelicula -= (precioPelicula * .15);
            puntosCliente -= (puntosCliente *.5);
        }
        if (metodo == Boleteria.MetodoPago.TARJETA){
            precioPelicula -= precioPelicula * .12;
        }
        setPuntosCliente();
    }

    public void comprarAsientos(String columnaSala, int cantidadAsientos){
        this.cantidadAsientos = cantidadAsientos;
        salaAsignada.reservarButacas(columnaSala, cantidadAsientos);
    }

    public void setPuntosCliente(){
        cliente.sumarPuntos(puntosCliente);
    }

}
