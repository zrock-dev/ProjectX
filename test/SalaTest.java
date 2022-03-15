import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaTest {
    Sala sala = new Sala("A");

    @Test
    void llenarCarteleraSalaTest() {
        sala.llenarCarteleraSala();
        int carteleraSize = sala.getCarteleraSala().length;
        assertEquals(5, carteleraSize);
    }

    @Test
    void generarButacasTest() {
        sala.setCapacidad(100);
        sala.generarButacas();
        int mapSize = sala.butacas.size();
        assertEquals(100/10, mapSize);
    }

    @Test
    void reservarButacasTest() {
        sala.setCapacidad(100);
        sala.generarButacas();
        sala.reservarButacas("D", 8);
        assertEquals(8, sala.butacas.get("D"));
    }
}