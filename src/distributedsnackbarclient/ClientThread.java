/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedsnackbarclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author calvin
 */
public class ClientThread extends Thread {
    
    private final Socket socketCliente;
    private String choice = null;
    private Scanner scan = new Scanner(System.in);

    public ClientThread(Socket socketCliente) {
        this.socketCliente = socketCliente;    
    }    
    
    @Override
    public void run() {        
        System.out.println("Connected to Server!");

        try {
            DataInputStream input = new DataInputStream(socketCliente.getInputStream());
            DataOutputStream output = new DataOutputStream(socketCliente.getOutputStream());

            System.out.println("Registration: ");
            String registration = scan.next();
            
            output.writeUTF(registration);
            
            System.out.println("Password: ");
            String password = scan.next();
            
            output.writeUTF(password);
            
            String authentication = input.readUTF();
            authenticateUser(authentication);

            while(choice != "exit") {
                String mensagem = input.readUTF();
                System.out.println(mensagem);
                choice = scan.next();
                output.writeUTF(choice);
            }      
            String response = input.readUTF();
            System.out.println(response);
            System.exit(1);
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    public static void authenticateUser(String authentication) {                    
        if(! authentication.equalsIgnoreCase("User authenticated!")) {
             System.out.println(authentication);
             System.exit(1);
        }
    }
}
