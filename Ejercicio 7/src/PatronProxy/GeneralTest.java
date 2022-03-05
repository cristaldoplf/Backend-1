package PatronProxy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneralTest {

    private static UsuarioAutorizado usuario1;
    private static UsuarioAutorizado usuario2;
    private static Documento documento1;
    private static Documento documento2;
    private static GestorDocumentos gestor;
    private static ProxyGestor proxy;

    @BeforeAll
    public static void crearObjetosParaTest() {
        usuario1 = new UsuarioAutorizado("pablo", "pablo");
        usuario2 = new UsuarioAutorizado("leonel", "leonel");
        documento1 = new Documento("documento1.com", "1", "Soy el contenido del documento 1");
        documento2 = new Documento("documento2.com", "2", "Soy el contenido del documento 2");
        gestor = new GestorDocumentos();
        proxy = new ProxyGestor(gestor);
        documento1.addUsuario(usuario1);
        documento1.addUsuario(usuario2);
        documento2.addUsuario(usuario1);
        proxy.addDocumento(documento1);
        gestor.addDocumento(documento2);
    }

    @Test
    public void testGenerales() {
        //test proxy correcto
        assertEquals("Soy el contenido del documento 1", proxy.entregarDoc("1", "documento1.com", "pablo", "pablo"));
        assertEquals("Soy el contenido del documento 2", proxy.entregarDoc("2", "documento2.com", "pablo", "pablo"));
        assertEquals("Soy el contenido del documento 1", proxy.entregarDoc("1", "documento1.com", "leonel", "leonel"));

        //test proxy error
        assertEquals("El usuario no esta autorizado para acceder al contenido solicitado", proxy.entregarDoc("2", "documento2.com", "leonel", "leonel"));
        assertEquals("El contenido solicitado no existe", proxy.entregarDoc("25", "doadsm", "pablo", "pablo"));

        //test gestor
        assertEquals("Soy el contenido del documento 1",gestor.entregarDoc("1", "documento1.com", "pablo", "pablo"));
        assertEquals("Soy el contenido del documento 2",gestor.entregarDoc("2", "documento2.com", "pablo", "pablo"));
    }

}