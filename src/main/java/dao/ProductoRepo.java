package dao;

import java.util.*;

public class ProductoRepo {

    static boolean cargado = false;
    static boolean cargadoSlide = false;

    private static List<Producto> listaProductos = new ArrayList<>();
    private static List<String> listaSlide = new ArrayList<>();

    public static List<Producto> getListaProductos() {
        //El booleano evita cargar si ya ha sido cargada la lista
        if (!cargado) {
            cargaProductos();
        }
        return listaProductos;
    }

    public static void setListaProductos(List<Producto> listaProductos) {
        ProductoRepo.listaProductos = listaProductos;
    }

    public static List<String> getListaSlide() {
        //El booleano evita cargar si ya ha sido cargada la lista
        if (!cargadoSlide) {
             cargaImgSlide();
        }
        return listaSlide;
    }

    public static void setListaSlide(List<String> listaSlide) {
        ProductoRepo.listaSlide = listaSlide;
    }

    public static void cargaProductos() {
        listaProductos.add(new Producto(1, "Ropa A", 10.50f, "1", "Una ropa 1"));
        listaProductos.add(new Producto(2, "Ropa B", 20.50f, "2", "Una ropa 2"));
        listaProductos.add(new Producto(3, "Ropa C", 30.50f, "1", "Una ropa 3"));
        listaProductos.add(new Producto(4, "Ropa D", 40.50f, "2", "Una ropa 4"));
        listaProductos.add(new Producto(5, "Ropa E", 50.50f, "1", "Una ropa 5"));
        listaProductos.add(new Producto(6, "Ropa F", 60.50f, "2", "Una ropa 6"));
        listaProductos.add(new Producto(7, "Ropa G", 70.50f, "1", "Una ropa 7"));
        listaProductos.add(new Producto(8, "Ropa H", 80.50f, "2", "Una ropa 8"));
        listaProductos.add(new Producto(9, "Ropa I", 90.50f, "1", "Una ropa 9"));
        listaProductos.add(new Producto(10, "Ropa J", 100.50f, "2", "Una ropa 10"));
        ProductoRepo.cargado = true;
    }//fin de la carga de los productos

    public static void cargaImgSlide() {
        //Crea las url de las imagenes del slideIndex (resourses/images/slide_index)
        for (int i = 0; i < 5; i++) {
            listaSlide.add("slideIndex" + (i + 1));
        }
        ProductoRepo.cargadoSlide = true;
    }//fin de la carga de las imagenes del slide index

}//fin de la clase del repositorio de los productos
