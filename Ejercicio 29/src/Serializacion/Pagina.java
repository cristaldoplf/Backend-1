package Serializacion;

import java.io.Serializable;

public class Pagina implements Serializable {
    private String url;
    private String nombre;

    public Pagina(String url, String nombre) {
        this.url = url;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Pagina{" +
                "url='" + url + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
