public class Utils {
    static String[] generosPelicula = {"Accion", "Animacion", "Ciencia Ficcion", "Comedia", "Drama", "Fantasia",
                                "Musical", "Romance", "Suspenso", "Terror", "Documental"};

    public static char[] generarAbc(int cantidadLetras){
        char[] abecedario = new char[cantidadLetras];
        for (int index = 0; index < cantidadLetras; index++) {
            abecedario[index] = (char) (65 + index);
        }
        return abecedario;
    }
}
