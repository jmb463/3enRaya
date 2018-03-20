/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenraya;

public class IA0 extends Jugador {
    
   
    
    //Constructor
    
    public IA0(Sesion sesion, String name) {
        
        super(sesion, name);
        
    }
    
 
    
    public int[] mover(Tablero tablero) {
        //Llama a un metodo del tablero que busca el primer sitio vacio.
        return tablero.moverIA(); 
    }
    
 
    
}