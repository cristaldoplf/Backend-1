import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
// @TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestGeneral {

    private static Infantil infantil;
    private static Vegetariano vegetariano;
    private static Clasico clasico;

    @BeforeAll
    public static void creacionObjetos(){
    infantil = new Infantil(5, 2);
    vegetariano = new Vegetariano(5, true, 2);
    clasico = new Clasico(5);
    }

    @org.junit.jupiter.api.Test
    public void informarPedido() {
        assertEquals("Armar menu Infantil",infantil.informarArmadoPedido());
        assertEquals("Armar menu Vegetariano",vegetariano.informarArmadoPedido());
        assertEquals("Armar menu Clasico",clasico.informarArmadoPedido());
    }

    @Test
    public void calcularPrecio(){
        assertEquals(11,infantil.calcularPrecio());
        assertEquals(9.05,vegetariano.calcularPrecio());
        assertEquals(11,infantil.calcularPrecio());
    }
}