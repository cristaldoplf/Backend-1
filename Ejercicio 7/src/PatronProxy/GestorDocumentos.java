package PatronProxy;

import java.util.ArrayList;
import java.util.List;

public class GestorDocumentos extends GoogleDrive {

    private List<Documento> documentos = new ArrayList<>();

    public GestorDocumentos() {
    }


    @Override
    public String entregarDoc(String id, String url, String nombre, String email) {
        String respuesta = "";
        for (Documento doc : documentos) {
            if (doc.getId() == id && doc.getUrl() == url){
            respuesta = doc.getContenido();
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
