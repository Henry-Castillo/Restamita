package crearPDF;

public class PostrePDF {
    private String indice;
    private String nombre;
    private String precio;
    private String cantidad;

    public PostrePDF(String indice, String nombre, String precio, String cantidad) {
        this.indice = indice;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    
    public PostrePDF() {
    }

    public String getIndice() {
        return indice;
    }

    public void setIndice(String indice) {
        this.indice = indice;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
}
