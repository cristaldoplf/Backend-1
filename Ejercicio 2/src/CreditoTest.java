import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditoTest {
    @Test
    public void checkearFechaCorrectamente() {
        Credito creditoTest = new Credito(2, "qweqwe", 7, 2025, "credito", 10000d, 0d);
        assertTrue(creditoTest.checkearAutorizacion(1000));
        assertFalse(creditoTest.checkearAutorizacion(30000));
    }
}