/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ajedrez;

/**
 *
 * @author Yasir
 */
public class Casilla {
    private Posicion posicion;
    private int color;  // 0 para blanco, 1 para negro
    private boolean ocupado = false;
    private Ficha ficha;

    public Casilla(Posicion posicion, int color, boolean ocupado, Ficha ficha) {
        this.posicion = posicion;
        this.color = color;
        this.ocupado = ocupado;
        this.ficha = ficha;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }
}

