package Example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public class ThreadServer {
    public static void main(String[] args) throws IOException {
        final int PORT = 4040;
        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Server started...");
        System.out.println("Wating for clients...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("client connect");
            LinkedList list = new LinkedList();
            Thread t = new Thread() {
                public void run() {
                    try (
                            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                            Scanner in = new Scanner(clientSocket.getInputStream());
                    ) {
                        Car car = new Car();
                        while (in.hasNextLine()) {
                            System.out.println("Client want to create a car");
                            String input = in.nextLine();
                            car.setBrand(in.nextLine());
                            car.setColor(in.nextLine());
                            list.add(car);
                            if (input.equalsIgnoreCase("exit")) {
                                break;
                            }
                            System.out.println("Car brand: " + car.getBrand());
                            System.out.println(list.size());

                            //client output
                            //  out.println("Register car: Brand: " + car.getBrand() + " " + "Color: " + car.getColor());
                            out.println(car.StringOf());
                        }
                    } catch (IOException e) {
                    }
                }
            };
            t.start();
        }
    }
}
