package com.example.primerparcial;

public class Producto {

    String nombreProducto ;
    String precioUnitario;
    String cantidad;

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }


    public String getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(String precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Producto(String nombreProducto ,String precioUnitario, String cantidad) {
        this.nombreProducto = nombreProducto ;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

   public Producto (){}

}
