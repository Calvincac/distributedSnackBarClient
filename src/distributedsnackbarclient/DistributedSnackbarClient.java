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
    
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socketCliente = null;
        socketCliente = new Socket("localhost", 6800);
        
        new ClientThread(socketCliente).start();
        
        
    }
    
}
