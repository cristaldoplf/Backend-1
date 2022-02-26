import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DebitoTest {

    @Test
    public void checkearFechaCorrectamente(){
        Debito debitoTest = new Debito(1, "asd123", 5,2025,"debito",10000d);
        assertTrue(debitoTest.checkearAutorizacion(1000d));
        assertFalse(debitoTest.checkearAutorizacion(30000d));
    }
}