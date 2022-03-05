package PatronProxy;

import java.util.ArrayList;
import java.util.List;

public class ProxyGestor extends GoogleDrive {


    private GestorDocumentos gestor;
    private List<Documento> documentos;

    public ProxyGestor(GestorDocumentos gestor) {
        this.gestor = gestor;
        documentos = gestor.getDocumentos();
    }

    @Override
    public String entregarDoc(String id, String url, String nombre, String email) {

        String respuesta = "El documento se esta procesando para ser enviado";

        for (Documento doc : documentos) {

            if (doc.getId() == id && doc.getUrl() == url) {
                for (UsuarioAutorizado usuario : doc.getUsuariosAutorizados()) {

                    if (usuario.getNombre() == nombre && usuario.getEmail() == email) {

                        return gestor.entregarDoc(id, url, nombre, email);
                    } else {

                        respuesta = "El usuario no esta autorizado para acceder al contenido solicitado";
                    }
                }
            } else {
                respuesta = "El contenido solicitado no existe";
            }
        }

        return respuesta;
    }

    public void addDocumento(Documento documento) {
        documentos.add(documento);
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }
}
