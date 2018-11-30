package Lesson_3_add;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) {
        Socket socket = null;

        try {
            socket = new Socket("localhost", 8189);

            final ObjectOutput pout = new ObjectOutputStream(socket.getOutputStream());

            try {
                pout.writeObject(new Player("bob"));
                System.out.println("объект отправлен");
                pout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
