package Example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ThreadClient2 {
    public static void main(String[] args) throws IOException {
        final String HOST = "127.0.0.1";
        final int PORT = 4040;

        System.out.println("Client started.");

        LinkedList list = new LinkedList();
        try (
                Socket socket = new Socket(HOST, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                Scanner in = new Scanner(socket.getInputStream());
                Scanner s = new Scanner(System.in);
        ) {
            while (true) {
                Car car = new Car();
                System.out.println("Yes to create a car or type exit");
                System.out.print("Input: ");

                String input = s.nextLine();
                out.println(input);

                if (input.equalsIgnoreCase("exit")){
                    break;
                }

                System.out.print("Brand: ");
                car.setBrand(s.nextLine());
                out.println(car.getBrand());

                System.out.print("Color: ");
                car.setColor(s.nextLine());
                out.println(car.getColor());

                list.add(car);

                System.out.println(in.nextLine());
            }
        }
    }
}
