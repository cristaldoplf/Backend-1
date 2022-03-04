package TemplateMethod;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestGeneral {

    private static Efectivo efectivo;
    private static Contratado contratado;
    private static Efectivo efectivoError;

    @BeforeAll
    public static void crearEmpleados(){
    efectivo = new Efectivo("Martin","Martiti",111,400,40,60);
    contratado = new Contratado("Pompilia","Pompini",222,120,7);
    efectivoError = new Efectivo("Martin","Martiti",111,400,500,60);
    }

    @Test
    public void liquidarSueldos(){
        assertEquals(efectivo.liquidarSueldo(),"La liquidación generada es un documento digital. Saldo a liquidar: 420.0");
        assertEquals(contratado.liquidarSueldo(),"La liquidación generada es un documento impreso. Saldo a liquidar: 840.0");
    }
}