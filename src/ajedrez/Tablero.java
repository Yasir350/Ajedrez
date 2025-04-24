/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ajedrez;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Yasir
 */
public class Tablero {
    private Scanner sc = new Scanner(System.in);
    private Casilla[][] tablero = new Casilla[8][8];
    private Ficha[][] fichas = {
//    {
//        new Torre(0, 0, 1),
//        new Caballo(0, 1, 1),
//        new Alfil(0, 2, 1),
//        new Reina(0, 3, 1),
//        new Rey(0, 4, 1),
//        new Alfil(0, 5, 1),
//        new Caballo(0, 6, 1),
//        new Torre(0, 7, 1)
//    },
    {
        new Peon(1, 0, 1),
        new Peon(1, 1, 1),
        new Peon(1, 2, 1),
        new Peon(1, 3, 1),
        new Peon(1, 4, 1),
        new Peon(1, 5, 1),
        new Peon(1, 6, 1),
        new Peon(1, 7, 1)
   },
//    { null, null, null, null, null, null, null, null },
//    { null, null, null, null, null, null, null, null },
//    { null, null, null, null, null, null, null, null },
//    { null, null, null, null, null, null, null, null },
    {
        new Peon(6, 0, 0),
        new Peon(6, 1, 0),
        new Peon(6, 2, 0),
        new Peon(6, 3, 0),
        new Peon(6, 4, 0),
        new Peon(6, 5, 0),
        new Peon(6, 6, 0),
        new Peon(6, 7, 0)
    },
//    {
//        new Torre(7, 0, 0),
//        new Caballo(7, 1, 0),
//        new Alfil(7, 2, 0),
//        new Reina(7, 3, 0),
//        new Rey(7, 4, 0),
//        new Alfil(7, 5, 0),
//        new Caballo(7, 6, 0),
//        new Torre(7, 7, 0)
//    }
};

    
    public String traducirTablero(int x, int y){
        char fila = (char)(97 + x);
        for (int i = 1; i <= tablero.length; i++) {
            for (int j = 1; j <= tablero.length; j++) {
                if (x== i && 7-y==j) {
                    System.out.println(traducirFicha(""+fila+j));
                    return ""+fila+j;
                }
            }
        }
        return "Error, numeros no validos";
    }
    
    public Posicion traducirFicha(String posicion){
            int letra = (int)posicion.charAt(0)-97;
            int numero = Integer.parseInt(String.valueOf(posicion.charAt(1)));
            return new Posicion(letra, numero);
    }
    
    public void moverFicha(Ficha ficha, int x, int y){
//        int x = ficha.getPosicion().getX();
//        int y = ficha.getPosicion().getY();
//        List<Posicion> posiciones = ficha.getMovimientosPosibles(x, y);
//        if (posiciones.size() > 0) {
//            for (int i = 0; i < posiciones.size(); i++) {
//                System.out.println(i+". Mover a: "+traducirTablero(posiciones.get(i).getX(), posiciones.get(0).getY()));
//            }
//            x = posiciones.get(0).getX();
//            y = posiciones.get(0).getY();
//            System.out.println(x+" sas "+y);
//            ficha.setPosicion(y, x);
//            crearTablero();
//        }

            ficha.setPosicion(y, x);
            crearTablero();
    }
    
    public void crearTablero(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if ((j+i)%2 == 0) {
                    tablero[i][j] = new Casilla(new Posicion(i, j), 0, false, null);
                }else 
                    tablero[i][j] = new Casilla(new Posicion(i, j), 1,  false, null);
            }
        }
        
        for (int i = 0; i < fichas.length; i++) {
            for (int j = 0; j < fichas[0].length; j++) {
                if (fichas[i][j] != null) {
                    tablero[fichas[i][j].getPosicion().getX()][fichas[i][j].getPosicion().getY()] = 
                            new Casilla(new Posicion(fichas[i][j].getPosicion().getX(), fichas[i][j].getPosicion().getY()), 0, true, fichas[i][j]);
                } 
            }
        }
    }
    
    public void mostrarTablero(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (!tablero[i][j].isOcupado()) {
                    System.out.print(tablero[i][j].getColor() == 0 ? " . " : " . ");
                } else {
                    System.out.print(dibujoFicha(tablero[i][j]));
                }
                }
            System.out.println("");
        }
    }
    
    public List<Ficha> fichas_A_Mover(int colorJugador){
        List<Ficha> fichasDisponibles = new ArrayList<>();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                Casilla casilla = tablero[i][j];
                Ficha ficha = casilla.getFicha();
                if (casilla.isOcupado() && !ficha.getMovimientosPosibles(i, j).isEmpty() && ficha.getColor() == colorJugador) {
                    fichasDisponibles.add(ficha);
                }
            }
        }
        return fichasDisponibles;
    }
    
    public boolean casillaValida(int x, int y, int rango){
        if (y+rango < 8 && y + rango >= 0) {
            Casilla casillaVerificar = tablero[x][y+rango];
            if (!casillaVerificar.isOcupado()) {
                return true;
            }
        }
        return false;
    }
    
    
    public String dibujoFicha(Casilla casilla) {
        if (casilla.isOcupado()) {
            return casilla.getFicha().getNombre();
        }
        return "No hay ninguna ficha en esa casilla";
    }
}
