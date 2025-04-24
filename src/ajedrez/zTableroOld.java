///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
// */
//package ajedrez;
//
//import java.util.Scanner;
//
///**
// *
// * @author Yasir
// */
//public class TableroOld {
//    private Scanner sc = new Scanner(System.in);
//    private Casilla[][] tablero = new Casilla[8][8];
//    private Fichas[][] fichas = {
//    {
//        new Fichas(0, 0, TipoFicha.TORRE, 1),
//        new Fichas(0, 1, TipoFicha.CABALLO, 1),
//        new Fichas(0, 2, TipoFicha.ALFIL, 1),
//        new Fichas(0, 3, TipoFicha.REINA, 1),
//        new Fichas(0, 4, TipoFicha.REY, 1),
//        new Fichas(0, 5, TipoFicha.ALFIL, 1),
//        new Fichas(0, 6, TipoFicha.CABALLO, 1),
//        new Fichas(0, 7, TipoFicha.TORRE, 1)
//    },
//    {
//        new Fichas(1, 0, TipoFicha.PEON, 1),
//        new Fichas(1, 1, TipoFicha.PEON, 1),
//        new Fichas(1, 2, TipoFicha.PEON, 1),
//        new Fichas(1, 3, TipoFicha.PEON, 1),
//        new Fichas(1, 4, TipoFicha.PEON, 1),
//        new Fichas(1, 5, TipoFicha.PEON, 1),
//        new Fichas(1, 6, TipoFicha.PEON, 1),
//        new Fichas(1, 7, TipoFicha.PEON, 1)
//    },
//    { null, null, null, null, null, null, null, null },
//    { null, null, null, null, null, null, null, null },
//    { null, null, null, null, null, null, null, null },
//    { null, null, null, null, null, null, null, null },
//    {
//        new Fichas(6, 0, TipoFicha.PEON, 0),
//        new Fichas(6, 1, TipoFicha.PEON, 0),
//        new Fichas(6, 2, TipoFicha.PEON, 0),
//        new Fichas(6, 3, TipoFicha.PEON, 0),
//        new Fichas(6, 4, TipoFicha.PEON, 0),
//        new Fichas(6, 5, TipoFicha.PEON, 0),
//        new Fichas(6, 6, TipoFicha.PEON, 0),
//        new Fichas(6, 7, TipoFicha.PEON, 0)
//    },
//    {
//        new Fichas(7, 0, TipoFicha.TORRE, 0),
//        new Fichas(7, 1, TipoFicha.CABALLO, 0),
//        new Fichas(7, 2, TipoFicha.ALFIL, 0),
//        new Fichas(7, 3, TipoFicha.REINA, 0),
//        new Fichas(7, 4, TipoFicha.REY, 0),
//        new Fichas(7, 5, TipoFicha.ALFIL, 0),
//        new Fichas(7, 6, TipoFicha.CABALLO, 0),
//        new Fichas(7, 7, TipoFicha.TORRE, 0)
//    }
//    };
//    
//    public String traducirTablero(int x, int y){
//        char fila = 97;
//        for (int i = 0; i < tablero.length; i++) {
//            for (int j = 0; j < tablero.length; j++) {
//                if (y == i && x==j) {
//                    return ""+fila+j;
//                }
//            }
//        }
//        return "Error, numeros no validos";
//    }
//    
//    public void moverFicha(Fichas ficha){
//        int x = ficha.getPosicion().getX();
//        int y = ficha.getPosicion().getY();
//        
//        int direccion = ficha.getColor() == 0 ? -1 : 1; // blancas hacia +y, negras hacia -y
//
//        switch (ficha.getTipo()) {
//            case PEON:
//                System.out.println("Donde la quieres mover?");
//                int i;
//                for (i = 1; i <= 1; i++) {
//                    if (!tablero[y+i][x].isOcupado()) {
//                        System.out.println(1+i+". Mover a: "+traducirTablero(x, y));
//                    }
//                    
//                }
//                if (sc.nextInt() == 1) {
//                    tablero[y][x].setOcupado(false);
//                    tablero[y+1][x].setOcupado(false);
//                    ficha.setPosicion(y+1 * direccion, x);
//                }
//                break;
//        }
//        crearTablero();
//    }
//    
//    public void crearTablero(){
//        for (int i = 0; i < tablero.length; i++) {
//            for (int j = 0; j < tablero[0].length; j++) {
//                if ((j+i)%2 == 0) {
//                    tablero[i][j] = new Casilla(new Posicion(i, j), 0, false, null);
//                }else 
//                    tablero[i][j] = new Casilla(new Posicion(i, j), 1,  false, null);
//            }
//        }
//        
//        for (int i = 0; i < fichas.length; i++) {
//            for (int j = 0; j < fichas[0].length; j++) {
//            if (fichas[i][j] != null) {
//                tablero[fichas[i][j].getPosicion().getX()][fichas[i][j].getPosicion().getY()] = 
//                        new Casilla(new Posicion(fichas[i][j].getPosicion().getX(), fichas[i][j].getPosicion().getY()), 0, true, fichas[i][j]);
//            } 
//            }
//        }
//    }
//    
//    public void mostrarTablero(){
//        for (int i = 0; i < tablero.length; i++) {
//            for (int j = 0; j < tablero[0].length; j++) {
//                if (!tablero[i][j].isOcupado()) {
//                    System.out.print(tablero[i][j].getColor() == 0 ? " . " : " . ");
//                } else {
//                    System.out.print(dibujoFicha(tablero[i][j]));
//                }
//                }
//            System.out.println("");
//        }
//    }
//    
//    public String dibujoFicha(Casilla casilla) {
//        boolean esBlanca = casilla.getFicha().getColor() == 0;
//
//        switch (casilla.getFicha().getTipo()) {
//            case PEON:
//                return esBlanca ? " P " : " p ";
//            case CABALLO:
//                return esBlanca ? " C " : " c ";
//            case ALFIL:
//                return esBlanca ? " A " : " a ";
//            case TORRE:
//                return esBlanca ? " T " : " t ";
//            case REINA:
//                return esBlanca ? " Q " : " q ";
//            case REY:
//                return esBlanca ? " K " : " k ";
//            default:
//                return " ? ";
//        }
//    }
//}
