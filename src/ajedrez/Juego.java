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
public class Juego {
    private Tablero tablero = new Tablero();
    private Jugador[] jugadores;
    private int rondas = 0;
    private int numJugadores;
    private boolean partidaAcabada;
    private Scanner sc = new Scanner(System.in);
    
    public Juego(int numJugadores){
        this.numJugadores = numJugadores;
        init();
    }
    
    private void init(){
        tablero.crearTablero();
        tablero.mostrarTablero();
        jugar();
    }
    
    public void jugar(){
        System.out.println("Numero de jugadores?: ");
        numJugadores = sc.nextInt();
        jugadores = new Jugador[2];
        for (int i = 0; i <= 1; i++) {
            jugadores[i] = new Jugador(i, tablero);
        }
        iniciarJugadores();
    }
    
    public void iniciarJugadores(){
        if (numJugadores == 2) {
            rondas = jugadores[0].getMovimientos() + jugadores[1].getMovimientos();
            for (int i = 2; !partidaAcabada; i++) {
                if (i%2 == 0) {
                    jugadores[0].turno();
                }else{
                    jugadores[1].turno();
                }
                rondas++;
            }
        }
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
}
