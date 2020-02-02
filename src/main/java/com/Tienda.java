package com;

import dao.Producto;
import dao.ProductoRepo;
import java.io.Serializable;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "tienda")
@ViewScoped
public class Tienda implements Serializable {

    private List<Producto> listaProds = new ArrayList<>();
    private List<String> listaSlide = new ArrayList<>();
    private Producto seleccionProd;

    public Tienda() {
    }

    public List<Producto> getListaProds() {
        return listaProds;
    }

    @PostConstruct
    public void init() {
        /*Carga las listas de los productos para la tienda
        y la lista de las url de las imagenes del slide en index
        */
        listaProds = ProductoRepo.getListaProductos();
        listaSlide = ProductoRepo.getListaSlide();
    }

    public Producto getSeleccionProd() {
        return seleccionProd;
    }

    public void setSeleccionProd(Producto seleccionProd) {
        this.seleccionProd = seleccionProd;
    }

    public List<String> getListaSlide() {
        return listaSlide;
    }


}
