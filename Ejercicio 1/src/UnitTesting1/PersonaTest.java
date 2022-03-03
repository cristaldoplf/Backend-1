package UnitTesting1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {

    @Test
    public void nombresCorrectos(){

        Persona persona1 = new Persona("Pablo","Cristaldo",33);
        Persona persona2 = new Persona("Leonardo","Gimenez",15);

        assertEquals(persona1.mostrarNombre(),"Pablo, Cristaldo.");
        // assertEquals(persona1.mostrarNombre(),"Pablo, asfdsdfsdf.");

        assertTrue(persona1.esMayor());
        assertFalse(persona2.esMayor());
        // assertFalse(persona1.esMayor());

        // descomentar para probar prueba fallida.

    }

}