package Lesson_3_add;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен!");

            socket = server.accept();
            System.out.println("Клиент подключился!");

            final Scanner in = new Scanner(socket.getInputStream());
            final PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            final Scanner console = new Scanner(System.in);
            final ObjectInputStream pin = new ObjectInputStream(socket.getInputStream());


            Thread t1 = new Thread(new Runnable() {
             Player player;
                @Override
                public void run() {
                    while (true) {
                        String str = in.nextLine();
                        if (str.equals("/end")) {
                            out.println("/end");
                            break;
                        }
                        System.out.println("Client " + str);
                        try {
                            player = (Player) pin.readObject();
                            player.info();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            t1.start();

            Thread t2 = new Thread(() -> {
                while (true) {
                    System.out.println("Введите сообщение!");
                    String str = console.nextLine();
                    System.out.println("Сообщение отправлено");
                    out.println(str);
                }
            });
            t2.setDaemon(true);
            t2.start();


            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
