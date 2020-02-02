package dao;

public class Producto {
    
    private int idProd;
    private String nombre;
    private float precio;
    private String urlImg;
    private String descripcion;

    public Producto(int idProd, String nombre, float precio, String urlImg, String descripcion) {
        this.idProd = idProd;
        this.nombre = nombre;
        this.precio = precio;
        this.urlImg = urlImg;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
    
    
    
    
}//fin de la clase producto
