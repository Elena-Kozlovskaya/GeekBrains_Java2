package lesson6;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {


    public static void main(String[] args) {
        Socket socket = null;
        try(ServerSocket serverSocket = new ServerSocket(MyConstants.PORT)){
            System.out.println("Server started. Wait for connection...");
            socket = serverSocket.accept();
            System.out.println("Client connected");
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            Thread thread1 = new Thread(() -> {
                while (true) {
                    String string = null;
                    try {
                        string = inputStream.readUTF();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (string.equals(MyConstants.STOP_WORD)) {
                        break;
                    }
                    System.out.println("Message from client: " + string); // вывод в консоль сообщения от клиента

                } System.out.println("Server shutting down");
            });
            Thread thread2 = new Thread(() -> {
                while (true) {
                    String strForClient = scanner.nextLine();

                    try {
                        outputStream.writeUTF(strForClient);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                });

            thread1.start();
            thread2.start();

        } catch (IOException ex){
            ex.printStackTrace();

        }


    }
}
