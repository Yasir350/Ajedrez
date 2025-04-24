/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ajedrez;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Yasir
 */
public class Jugador {
    private Tablero tablero;
    private int numJugadores;
    private int movimientos;
    private int color;
    private Scanner sc = new Scanner(System.in);
    
    public Jugador(int color, Tablero tablero){
        this.color = color;
        this.tablero = tablero;
    }
    
    public void turno() {
        //elegir fichas disponibles
        Ficha ficha = elegirFicha();
        
        //Mostrar movimientos posibles de la ficha elegidsa
        int x = ficha.getPosicion().getX();
        int y = ficha.getPosicion().getY();
        List<Posicion> movimientosPosibles = ficha.getMovimientosPosibles(x, y);
        List<Posicion> muertesPosibles = ficha.getMuertesPosibles(x, y);

        mostrarMovimientos(movimientosPosibles);
        //Mover la ficha en base al input
        moverFicha(ficha, movimientosPosibles, muertesPosibles);
    }

    
    public Ficha elegirFicha(){
        List<Ficha> fichas = tablero.fichas_A_Mover(this.color);
        mostrarFichas(fichas);
        System.out.print("Ficha a elegir?: ");
        Ficha ficha = fichas.get(sc.nextInt()-1);
        return ficha;
    }
    
    public void moverFicha(Ficha ficha, List<Posicion> movimientosPosibles, 
            List<Posicion> muertesPosibles){
        System.out.println("A donde la quieres mover? ");
        Posicion movimiento = movimientosPosibles.get(sc.nextInt()-1);
        tablero.moverFicha(ficha, movimiento.getX(), movimiento.getY());
        ficha.setHaMovido(true);
        tablero.mostrarTablero();
        this.movimientos++;
    }
    
    public void mostrarFichas(List<Ficha> fichas){
        for (int i = 0; i < fichas.size(); i++) {
            System.out.println(1+i+". "+fichas.get(i));
        }
    }
    public void mostrarMovimientos(List<Posicion> posiciones){
        for (int i = 0; i < posiciones.size(); i++) {
            System.out.println(1+i+". "+posiciones.get(i).traducirPosicion());
        }
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    public int getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(int movimientos) {
        this.movimientos = movimientos;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
    

}
