/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ajedrez;

/**
 *
 * @author Yasir
 */
public class Posicion {
    private int x;
    private int y;
    
    public Posicion(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    @Override
    public String toString(){
        return "("+this.getX()+", "+this.getY()+")";
    }
    
    public String traducirPosicion(){
        int posX = this.getX();
        int posY = this.getY();
        char fila = (char)(97 + posX);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (posX == i && 7-posY==j) {
                    return ""+fila+(j+1);
                }
            }
        }
        return "Error, numeros no validos";
    }
    
}
