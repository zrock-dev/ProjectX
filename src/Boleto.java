public class Boleto {
    int precioTotal;
    int cantidadAsientos;
    int puntos;
    Sala salaAsignada;

    public void setPuntosCliente(Cliente cliente){
        cliente.sumarPuntos(puntos);
    }

}
