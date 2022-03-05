package PatronProxy;

import java.util.ArrayList;
import java.util.List;

public class Documento {
    private String url;
    private String id;
    private String contenido;
    private List<UsuarioAutorizado> usuariosAutorizados = new ArrayList();

    public Documento(String url, String id, String contenido) {
        this.url = url;
        this.id = id;
        this.contenido = contenido;
    }

    public void addUsuario(UsuarioAutorizado usuario){
        usuariosAutorizados.add(usuario);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public List<UsuarioAutorizado> getUsuariosAutorizados() {
        return usuariosAutorizados;
    }

    public void setUsuariosAutorizados(List<UsuarioAutorizado> usuariosAutorizados) {
        this.usuariosAutorizados = usuariosAutorizados;
    }
}
