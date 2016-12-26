/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaming;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author erol
 */
class Game {

    static ArrayList<String> colors;
    /**
     * The current player.
     */
    Player currentPlayer;

    Game() {
        colors = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            colors.add(getRandomString(r.nextInt(4)));
        }
    }
    
    private String getRandomString(int i) {
        String x = "";
        switch (i) {
            case 0:
                x = "red";
                break;
            case 1:
                x = "yellow";
                break;
            case 2:
                x = "blue";
                break;
            case 3:
                x = "green";
                break;
        }
        return x;
    }

   
    public boolean hasWinner() {
        return false;
    }


    // ben string kullanıyorum
    public synchronized boolean legalMove(String color, Player player) {
        if (player == currentPlayer) {
            System.out.println(player.mark + "color" + color);
            currentPlayer = currentPlayer.opponent;
            currentPlayer.otherPlayerMoved(color);
            return true;
        }
        return false;
    }

    class Player extends Thread {

        char mark;
        Player opponent;
        Socket socket;
        BufferedReader input;
        PrintWriter output;

        /**
         * Constructs a handler thread for a given socket and mark initializes
         * the stream fields, displays the first two welcoming messages.
         */
        public Player(Socket socket, char mark) {
            this.socket = socket;
            this.mark = mark;
            try {
                input = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                output = new PrintWriter(socket.getOutputStream(), true);
                output.println("WELCOME " + mark);
                output.println("MESSAGE Diğer oyuncu bekleniyor!");
            } catch (IOException e) {
                System.out.println("Player died: " + e);
            }
        }

        /**
         * Accepts notification of who the opponent is.
         */
        public void setOpponent(Player opponent) {
            this.opponent = opponent;
        }

        /**
         * Handles the otherPlayerMoved message.
         */
        public void otherPlayerMoved(int location) {
            output.println("OPPONENT_MOVED " + location);
            //output.println(hasWinner() ? "DEFEAT" : boardFilledUp() ? "TIE" : "");
        }

        public void otherPlayerMoved(String location) {
            System.out.println("otherPlayerMoved" + location);
            output.println("OPPONENT_MOVED " + location);
            //output.println(hasWinner() ? "DEFEAT" : boardFilledUp() ? "TIE" : "");
        }

        /**
         * The run method of this thread.
         */
        @Override
        public void run() {
            try {
                // The thread is only started after everyone connects.
                output.println("MESSAGE Tüm oyuncular hazır.");
                
                // Tell the first player that it is her turn.
                if (mark == 'X') {
                    output.println("MESSAGE Senin sıran");
                }

                // Repeatedly get commands from the client and process them.
                while (true) {
                    String command = input.readLine();
                    if (command.startsWith("MOVE")) {
                        String[] location = command.split(" ");
                        if (legalMove(location[1], this)) {
                            output.println("VALID_MOVE");
                            System.out.println(location[1]);
                            colors.add(location[1]);
                            //output.println(hasWinner() ? "VICTORY": boardFilledUp() ? "TIE": "");
                        } else {
                            output.println("MESSAGE ?");
                        }
                    } else if (command.startsWith("QUIT")) {
                        return;
                    }
                }
            } catch (IOException e) {
                System.out.println("Player died: " + e);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
