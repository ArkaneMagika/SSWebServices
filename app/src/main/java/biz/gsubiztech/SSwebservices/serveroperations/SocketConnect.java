/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.gsubiztech.SSwebservices.serveroperations;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author arkane
 */
public class SocketConnect extends Thread {

    public void ConnectSocket(String Port) throws InterruptedException, IOException {
        AtomicInteger numThreads = new AtomicInteger(0);
        ArrayList<Thread> threadList = new ArrayList<>();

        ServerSocket ConnSocket = new ServerSocket(Integer.parseInt(Port));

        Socket OpenSocket = null;

        DataInputStream in = new DataInputStream(OpenSocket.getInputStream());
        DataOutputStream out = new DataOutputStream(OpenSocket.getOutputStream());

        if (ConnSocket.isBound()) {
            try {
                out.flush();
                out.writeUTF("Attempting to bound socket...");
                OpenSocket = ConnSocket.accept();
                out.writeUTF("Connection Established on port: " + ConnSocket.getLocalPort());
                if (OpenSocket.isConnected()) {

                    try {
                        out.writeUTF("Attempting to thread instance on port: " + ConnSocket.getLocalPort());
                        Thread thrd = new Thread(new ServerThread(OpenSocket));
                        threadList.add(thrd);
                        numThreads.incrementAndGet();

                    } catch (IOException E) {
                        out.writeUTF("Unable to create thread for port " + ConnSocket.getLocalPort() + "\n");
                        out.writeUTF("Error occured " + E);
                        out.writeUTF("Unable to proceed. Closing socket");
                        OpenSocket.close();
                    }

                }
            } catch (Exception E) {

            }

        } else if (ConnSocket.isClosed()) {
            try {
                out.flush();
                out.writeUTF("Socket is clossed. Attempting to reassign...");
                ConnSocket = new ServerSocket(0);
                out.writeUTF("Port reassigned. Reattempting application");
                OpenSocket = ConnSocket.accept();

                if (OpenSocket.isConnected()) {
                    out.writeUTF(Port);
                } else {
                    out.writeUTF("Unable to properly reassign port. Closing application");
                    OpenSocket.close();
                }
            } catch (Exception E) {

            }
        }
    }

}
