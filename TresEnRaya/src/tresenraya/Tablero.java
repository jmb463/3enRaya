/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenraya;

public class Tablero {
    
    //Atributos
    
    private char cell[][] = new char[3][3];
    
    //Constructor
    
    public Tablero() {
        //Dar valores a las celdas
        for (int row = 0; row < 3; row ++) {   
            for (int col = 0; col < 3; col ++) {
                cell[row][col] = ' ';
            }
        }
    }
    
    public boolean comprobarEmpate() {
        //Comprueba si todas las casillas estan llenas
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (cell[row][col] == ' ') {
                    //Devuelve False si no hay empate
                    return false; // End
                }
            }
        }
        //Devuelve True si hay empate
        return true;
    }
    
    public boolean comprobarGanador() {
        //Comprueba si hay una victoria horizontal
        for (int row = 0; row < cell.length; row++) {
            if (cell[row][0] == cell[row][1] && cell[row][1] == cell[row][2] && cell[row][0] != ' ') {
                //Devuelve verdadero por que hay una victoria
                return true;
            }
        }
        //Comprueba si hay una victoria vertical
        for (int col = 0; col < cell.length; col++) {
            if (cell[0][col] == cell[1][col] && cell[1][col] == cell[2][col] && cell[0][col] != ' ') {
                //Devuelve verdadero por que hay una victoria
                return true;
            }
        }
        //Comprueba si hay una vistoria diagonal (de izquierda arriba a derecha abajo)
        if (cell[0][0] == cell[1][1] && cell[1][1] == cell[2][2] && cell[0][0] != ' ') {
            //Devuelve verdadero por que hay una victoria
            return true;
        }
        //Comprueba si hay una victoria diagonal (de derecha arriba a izquierda abajo)
        if (cell[0][2] == cell[1][1] && cell[1][1] == cell[2][0] && cell[0][2] != ' ') {
            //Devuelve verdadero por que hay una victoria
            return true;
        }
        //Devuelve Falso por que no hay ninguna victoria
        return false;
    }
    
    public int[] moverIA() {
        //Crear array con coordenadas
        int coordinates[] = new int[2];
        coordinates[0] = 0;
        coordinates[1] = 0;
        //Buscar primera celda vacia
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                //La primera vacia que encuentra 
                if (this.cell[row][col] == ' ') {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    //Devolvemos la array con las cordenadas
                    return coordinates;
                }
            }
        } 
        //Devolvemos la array con las cordenadas
        return coordinates;
    }
    
    
    
    public boolean setCell(int row, int col, char value) {
        //Comprobar si el movimiento es valido
        if (this.validarMovimiento(row, col, value) == true) {
            //Ejecutar el movimiento
            this.cell[row][col] = value;
            //Anunciar que el movimiento se ejecuto
            System.out.println("El movimiento " + value + " a " + row + " " + col + " se ejecuto correctamente.");
            System.out.println();
            //Devolvemos True por que se ejecuto el movimiento
            return true;
        }
        //Devolvemos False por que el movimiento no se ejecuto
        return false;
    }
    
    
    public void showTablero() {
        //Imprimir encabezado
        System.out.print("      [0]  [1]  [2] ");
        System.out.println("");
        //Imprimir contenido de las celdas y guia lateral
        for (int row = 0; row < 3; row ++) {
            System.out.print(" [" + row + "] ");
            for (int col = 0; col < 3; col ++) {
                System.out.print(" [" + this.cell[row][col] + "] ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    

    
    public boolean validarMovimiento(int row, int col, char value) {
        //Comprobar que la casilla existe
        if (row > 2 || row < 0 || col > 2 || col < 0) {
            //Anunciamos que el Movimiento es invalido
            System.out.println("El movimiento " + value + " a " + row + " " + col + " es invalido.");
            System.out.println();
            //Devolvemos False para denegar el movimiento
            return false; //End  
        }
        //Comprobar que la casilla deseada este vacia
        if (this.cell[row][col] != ' ') {
            //Anunciamos que el Movimiento es invalido
            System.out.println("El movimiento " + value + " a " + row + " " + col + " es invalido.");
            System.out.println();
            //Devolvemos False para denegar el movimiento
            return false; //End  
        }
        //Anunciar que el movimento es correcto
        System.out.println("El movimiento " + value + " a " + row + " " + col + " es valido.");
        System.out.println();
        //Devolver True para permitir el movimiento.
        return true;  
    }
  
    
}