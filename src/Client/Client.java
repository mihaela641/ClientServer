package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Locale;
import java.util.Scanner;

public class Client {
    private DataInputStream din;
    private DataOutputStream dout;
    private Socket socket;
    public static void main(String[] args) {
        new Client();
    }

    public Client() {
        try {
            socket = new Socket("localhost", 3333);
            din = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());

            listenForInput();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void listenForInput() {
        Scanner console = new Scanner(System.in);
        while (true) {
            while (!console.hasNextLine()) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            String input = console.nextLine();

            if (input.toLowerCase(Locale.ROOT).equals("quit")){
                break;
            }

            try {
                dout.writeUTF(input);

                while (din.available() == 0){  //nothing available to read
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String reply = din.readUTF();
                System.out.println(reply);
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }

        try {
            din.close();
            dout.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
