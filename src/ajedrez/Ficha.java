/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ajedrez;

import java.util.List;

/**
 *
 * @author Yasir
 */
public abstract class Ficha {
    private Posicion posicion;
    private int color;
    String nombre;
    int rango;
    private int direccion;
    private boolean haMovido = false;
    
    public Ficha(int x, int y, int color){
        this.posicion = new Posicion(x, y);
        this.color = color;
    }
    
    
    public abstract List<Posicion> getMovimientosPosibles(int x, int y);
    
    public abstract String getNombre();
    
    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(int x, int y) {
        this.posicion = new Posicion(x, y);
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }

    public boolean isHaMovido() {
        return haMovido;
    }

    public void setHaMovido(boolean haMovido) {
        this.haMovido = haMovido;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }
    
    @Override
    public String toString(){
        return this.getNombre()+" "+
                this.posicion.traducirPosicion();
    }
}

