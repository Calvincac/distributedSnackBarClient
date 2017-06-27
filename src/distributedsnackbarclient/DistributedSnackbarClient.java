/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedsnackbarclient;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


/**
 *
 * @author calvin
 */
public class DistributedSnackbarClient {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */    
    
    public static void main(String[] args) throws IOException {
        Socket socketCliente = null;
        int numberOfClients;
        Scanner scan = new Scanner(System.in);
        socketCliente = new Socket("localhost", 6800);
        
        System.out.println("How many client would you like to have started ?");
        numberOfClients = scan.nextInt();

        for (int i=0; i<numberOfClients; i++) {
            new ClientThread(socketCliente).start();
        }
        
    }
    
}
