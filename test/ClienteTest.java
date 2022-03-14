import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    @Test
    public void testClient(){
        Cliente cliente = new Cliente(13120697, "Juan perez", "Peruano",
                "04/02/2001");
        System.out.println(cliente.getEdad());
        System.out.println(cliente.getCi());
    }

}