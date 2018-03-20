/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenraya;


import java.util.Scanner;

public class Sesion {

    //Atributos
    private Jugador Humano; 
    private Jugador IA; 
    private Partida partida;
    private Ranking ranking;

    //Constructor
    public Sesion() {

    }
    
    private void newIA(String name) {
        this.IA = new IA0(this, name);
    }
    
    private void newJugador(String nombre) {
        this.Humano = new Jugador(this, nombre);
    }

    
    private void newPartida(Jugador Humano, Jugador IA, Ranking ranking) {
        this.partida = new Partida(Humano, IA, ranking);
    }

    private void newRanking(Jugador player) {
        this.ranking = new Ranking(player);
    }

    private void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        //Mostrar Menu
        System.out.println("--MENU--");
        System.out.println("1- Comenzar partida.");
        System.out.println("2- Mostrar ranking.");
        System.out.println("3- Salir.");
        System.out.println();
        System.out.print("Escoje una opción por favor: ");
        //Funcionalidad del menu
        while (exit == false) {
            int option = scanner.nextInt();
            System.out.println();
            switch (option) {
                case 1:
                    this.newPartida(this.Humano, this.IA, this.ranking);
                    this.menu();
                case 2:
                    this.ranking.showRanking(Humano);
                    this.menu();
                case 3:
                    exit = true;
            }
        }
    }

   
    public static void main(String[] args) {
        //Crear Sesion
        Sesion sesion = new Sesion();
        //Scaner para leer datos por teclado
        Scanner scanner = new Scanner(System.in);
        //Crear Jugador humano
        System.out.print("Escriba su nombre: ");
        String name = scanner.nextLine();
        sesion.newJugador(name);

        //Crear Ranking
        sesion.newRanking(sesion.Humano);
        //Crear IA
        sesion.newIA("IA");
        //Iniciar menu
        sesion.menu();
    }

}