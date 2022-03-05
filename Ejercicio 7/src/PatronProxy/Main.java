package PatronProxy;

import javax.print.Doc;

public class Main {
    public static void main(String[] args) {
        //creo documentos con su respectiva lista de usuarios autorizado
        UsuarioAutorizado usuario1 = new UsuarioAutorizado("pablo","pablo");
        UsuarioAutorizado usuario2 = new UsuarioAutorizado("leonel","leonel");
        Documento documento1 = new Documento("documento1.com","1","Soy el contenido del documento 1");
        Documento documento2 = new Documento("documento2.com","2","Soy el contenido del documento 2");
        documento1.addUsuario(usuario1);
        documento1.addUsuario(usuario2);
        documento2.addUsuario(usuario1);

        //creo el proxy y el gestor
        GestorDocumentos gestor = new GestorDocumentos();
        ProxyGestor proxy = new ProxyGestor(gestor);
        proxy.addDocumento(documento1);
        gestor.addDocumento(documento2);

        //accedo al contenido por medio del proxy
        System.out.println("Pedidos del usuario pablo");
        System.out.println(proxy.entregarDoc("1","documento1.com","pablo","pablo"));
        System.out.println(proxy.entregarDoc("2","documento2.com","pablo","pablo"));

        System.out.println("");
        System.out.println("Pedidos del usuario leonel");
        System.out.println(proxy.entregarDoc("1","documento1.com","leonel","leonel"));
        System.out.println(proxy.entregarDoc("2","documento2.com","leonel","leonel"));

    }
}
