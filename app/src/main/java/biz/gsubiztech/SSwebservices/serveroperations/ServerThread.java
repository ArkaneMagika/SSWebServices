/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.gsubiztech.SSwebservices.serveroperations;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Akane D. Simpson
 */
public class ServerThread extends Thread{
    Socket client;
    PrintWriter writer;
    BufferedReader reader;
    

    public ServerThread(Socket OpenSocket) {
        this.client = OpenSocket;
    }
    
    @Override
    public void run(){
        try{
            
        }
        catch(Exception E){
            
        }
    }
    
}
