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
import javax.swing.JOptionPane;

/**
 *
 * @author calvin
 */
public class DistributedSnackbarClient {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    private static String mensagem = null;
    
    public static void main(String[] args) throws IOException {
        Socket socketCliente = null;

        socketCliente = new Socket("localhost", 6800);
        System.out.println("Connected to Server!");
        DataInputStream input = new DataInputStream(socketCliente.getInputStream());
        DataOutputStream output = new DataOutputStream(socketCliente.getOutputStream());
        
    
        String registration = JOptionPane.showInputDialog("Registration: ");
        output.writeUTF(registration);
        log(registration);
        
        String password = JOptionPane.showInputDialog("Password: ");
        output.writeUTF(password);
        log(password);
        
        while(mensagem != "exit") {
            mensagem = input.readUTF();
            receivedLog(mensagem);        
            String choice = JOptionPane.showInputDialog(mensagem);        
            output.writeUTF(choice);
        }      
        String response = input.readUTF();
        String f = JOptionPane.showInputDialog(response);      
        
    }
    
    public static void log(String message) {
        System.out.println("Message: " + message);
    }
    
    public static void receivedLog(String message){
        System.out.println("Received message: " +  message);
    }
    
}
