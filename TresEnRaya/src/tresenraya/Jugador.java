/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenraya;

import java.util.Scanner;

public class Jugador {
    
    //Atributos
    
    private Partida Partida;  
    private Sesion sesion;
    private char token;  
    private String nombre;    



    
    //Constructor
    
    public Jugador(Sesion sesion, String nombre) {
    
        this.sesion = sesion;
        this.nombre = nombre;
        
    }
    
    
    public String getNombre() {
    
        return this.nombre;
    
    }

    public Partida getPartida() {
    
        return this.Partida;
    
    }
    
    public char getToken() {
    
        return this.token;
    
    }
    
    
    
    public int[] mover(Tablero tablero) {
        //Crea una array con las cordenadas y les da un valor por defecto
        int coordinates[] = new int[2];
        coordinates[0] = 0;
        coordinates[1] = 0;
        //Scaner para leer los datos entregados por teclado
        Scanner scanner = new Scanner(System.in);
        //Preguntar fila
        System.out.print("Selecciona una fila: ");
        coordinates[0] = scanner.nextInt();
        System.out.println("");
        //Preguntar columna
        System.out.print("Selecciona una columna: ");
        coordinates[1] = scanner.nextInt();
        System.out.println("");
        //Devolver coordenadas
        return coordinates;
    }
    
 
    
    public void setPartida(Partida partida) {
    
        this.Partida = partida;
    
    }
    

    
    public void setToken(char token) {
    
        this.token = token;
    
    }
    
    

    
}