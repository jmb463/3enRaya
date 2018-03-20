/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenraya;


public class Partida {

    //Atributos
    private Jugador jugadores[] = new Jugador[2];
    private Jugador aJugador;
    private Tablero tablero;

    //Constructor
    public Partida(Jugador Humano, Jugador IA, Ranking ranking) {
        //Anunciar que se inicio una partida
        System.out.println("Se ha iniciado una nueva partida.");
        System.out.println("");
        //Se añade el Humano
        this.addJugador(Humano);
        Humano.setPartida(this);
        //Se añade la IA
        this.addJugador(IA);
        IA.setPartida(this);
        //Sumar Partida a Jugadores
        ranking.addPartida();
        //Se sortea quien empieza la partida
        this.setaJugador(this.sorteo(this.jugadores[0], this.jugadores[1]));
        //Se crea el Tablero
        this.newTablero();
        //Se inicia la partida
        this.gameManagement(ranking);
    }

        
    public Tablero getTablero() {
        return this.tablero;
    }
    
    private void actualizarRanking(Ranking ranking, Boolean empate) {
        //Sumar Victoria
        if (!(aJugador instanceof IA0) && empate == false) {
            ranking.addVictoria();
        }
        //Sumar Derrota
        if (aJugador instanceof IA0 && empate == false) {
            ranking.addDerrota();
        }
        //Sumar Empate 
        if (empate == true) {
            ranking.addEmpate();
        }
    }


    private boolean addJugador(Jugador player) {
        for (int pos = 0; pos < 2; pos++) {
            if (this.jugadores[pos] == null) {
                //Lo añade a la array
                this.jugadores[pos] = player;
                //Se anuncia que se añadio el Jugador
                System.out.println(this.jugadores[pos].getNombre() + " se ha unido a la partida.");
                System.out.println("");
                //Se devuelve correcto
                return true;
            }
        }
        return false;
    }
    

    private void cambiarJugador() {
        if (this.aJugador == jugadores[0]) {
            this.aJugador = jugadores[1];
        } else {
            this.aJugador = jugadores[0];
        }
    }


    private void gameManagement(Ranking ranking) {
        //Manejar Turno
        boolean endGame = false;
        int coordinates[] = new int[2];
        for (int turno = 0; endGame == false; turno++) {
            //Anunciar Turno
            System.out.println("Se iniciara el turno " + (turno + 1) + ".");
            System.out.println("");
            //Mostrar Tablero        
            this.tablero.showTablero();
            //Pedir Movimiento a Jugador
            coordinates = this.aJugador.mover(this.tablero);
            //Anunciar Movimiento del jugador
            System.out.println(this.aJugador.getNombre() + " mueve a: " + coordinates[0] + " " + coordinates[1]);
            System.out.println("");
            //Hacer movimiento: Devolvera una booleana True se puedo mover, False no
            if (this.tablero.setCell(coordinates[0], coordinates[1], this.aJugador.getToken()) == false) {
                //Anunciar Victoria
                System.out.println(aJugador.getNombre() + " ha perdido la partida por que el movimiento no es valido.");
                System.out.println("");
                //Sumar derrota
                this.actualizarRanking(ranking, false);
                //Acabar Partida
                endGame = true;
            }
            //Comprobar Victoria
            if (this.tablero.comprobarGanador() == true) {
                //Anunciar Victoria
                System.out.println(aJugador.getNombre() + " ha ganado la partida.");
                System.out.println("");
                //Sumar Victoria
                this.actualizarRanking(ranking, false);
                //Acabar Partida
                endGame = true;
            } 
            //Comprobar Empate
            else {
                if (this.tablero.comprobarEmpate() == true) {
                    //Anunciar Empate
                    System.out.println("Se ha producido un empate, la partida ha terminado.");
                    System.out.println("");
                    //Sumar Empate a Jugadores
                    this.actualizarRanking(ranking, true);
                    //Acabar Partida
                    endGame = true;
                }
            }
            //Cambiar jugador
            cambiarJugador();
            //Mostrar Tablero        
            this.tablero.showTablero();
        }
    }

    private void newTablero() {
        this.tablero = new Tablero();
    }

    private void setaJugador(Jugador jugador) {
        this.aJugador = jugador;
    }
    
    
    private Jugador sorteo(Jugador Humano, Jugador IA) {
        int sorteo = (int) (Math.random() * 2);
        if (sorteo == 0) {
            //El Jugador 1 recibe la ficha X.
            Humano.setToken('O');
            //El Jugador 2 recibe la ficha O.
            IA.setToken('X');
            //Devolvemos el Jugador que empieza.
            System.out.println("El Jugador inicial sera: " + Humano.getNombre() + ".");
            System.out.println("");
            return Humano;
        }
        if (sorteo == 1) {
            //El Jugador 1 recibe la ficha O.
            Humano.setToken('X');
            //El Jugador 2 recibe la ficha X.
            IA.setToken('O');
            //Devolvemos el Jugador que empieza.
            System.out.println("El Jugador inicial sera: " + IA.getNombre() + ".");
            System.out.println("");
            return IA;
        }
        return null;
    }

}
