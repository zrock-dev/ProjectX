public class Boleto {
    int precioTotal;
    int cantidadAsientos;
    int puntos;
    Cliente cliente;
    Sala salaAsignada;

    public Boleto(int precioTotal, int cantidadAsientos, int puntos, Cliente cliente, Sala salaAsignada) {
        this.precioTotal = precioTotal;
        this.cantidadAsientos = cantidadAsientos;
        this.puntos = puntos;
        this.cliente = cliente;
        this.salaAsignada = salaAsignada;
    }

    public void setPuntosCliente(Cliente cliente){
        cliente.sumarPuntos(puntos);
    }

}
