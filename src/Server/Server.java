package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket serverSocket;
    Socket socket;
    DataInputStream din;
    DataOutputStream dout;
    public static void main(String[] args) {
        new Server();
    }

    public Server(){
        try {
            serverSocket = new ServerSocket(3333);
            socket = serverSocket.accept();
            din = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());

            listenForData();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void listenForData() {
        while (true) {
            try {
                while (din.available() == 0) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                String dataIn = din.readUTF();

                dout.writeUTF(dataIn);
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }

        }

        try {
            din.close();
            dout.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
