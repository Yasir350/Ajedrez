/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ajedrez;

import java.util.ArrayList;
import java.util.List;

class Peon extends Ficha{
    private int rango = 1;
    private int direccion;
    private boolean haMovido = false;
    String nombre = " p ";
    
    public Peon(int x, int y, int color){
        super(x, y, color);
        direccion = color == 0? -1 : 1;
    }
    
    @Override
    public List<Posicion> getMovimientosPosibles(int x, int y){
        List<Posicion> posiciones = new ArrayList<>();
        for (int i = 0; i < rango; i++) {
            if (!this.haMovido && esValido(y, x+(rango*2 * this.direccion))) {
                posiciones.add(new Posicion(y,x+(rango*2 * this.direccion)));
            }else if (this.haMovido && esValido(y,x+(rango * this.direccion)) ){
                posiciones.add(new Posicion(y, x+(rango * this.direccion)));
            }
            
        }
        return posiciones;
    }
    
    @Override
    public List<Posicion> getMuertesPosibles(int x, int y){
        List<Posicion> posiciones = new ArrayList<>();
        for (int i = 0; i < rango; i++) {
            if (!this.haMovido && esValido(y+1, x+(rango * this.direccion))) {
                posiciones.add(new Posicion(y+1, x+(rango * this.direccion)));
            }else if(!this.haMovido && esValido(y-1, x+(rango * this.direccion))){
                posiciones.add(new Posicion(y-1, x+(rango * this.direccion)));
            }
        }
        return posiciones;
    }
    
    @Override
    public String getNombre(){
        return this.getColor() == 0? nombre.toLowerCase() : nombre.toUpperCase();
    }
    
    public boolean esValido(int y, int x){
        for (int i = 0; i < rango; i++) {
            if (x >= 0 && x<8) {
                return true;
            }
        }
        return false;
    }
}