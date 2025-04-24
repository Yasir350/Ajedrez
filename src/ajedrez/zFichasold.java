///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
// */
//package ajedrez;
//
///**
// *
// * @author Yasir
// */
//public class Fichasold {
//    private Posicion posicion;
//    private TipoFicha tipo;
//    private int color;
//    private int rango;
// 
//    
//    public Fichas(int x, int y, TipoFicha tipo, int color){
//        this.posicion = new Posicion(x, y);
//        this.tipo = tipo;
//        this.color = color;
//    }
//    
//    public int getColor() {
//        return color;
//    }
//
//    public void setColor(int color) {
//        this.color = color;
//    }
//
//    public Posicion getPosicion() {
//        return posicion;
//    }
//
//    public void setPosicion(int x, int y) {
//        this.posicion = new Posicion(x, y);
//    }
//
//    public TipoFicha getTipo() {
//        return tipo;
//    }
//
//    public void setTipo(TipoFicha tipo) {
//        this.tipo = tipo;
//    }
//    
//    @Override
//    public String toString(){
//        return this.tipo+", "+this.color+"("+this.posicion.getX()+", "+this.posicion.getY()+")";
//    }
//    
//}
