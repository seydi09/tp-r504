import java.io.*;
import java.net.*;

public class ServeurUDP {
    public static void main(String[] args) throws Exception {
        // Ouverture de la socket d'écoute sur le port 1234
        DatagramSocket sock = new DatagramSocket(1234);

        while (true) {
            System.out.println("-Waiting data");

            // Buffers pour stocker les données reçues
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Attente bloquante d'un paquet
            sock.receive(packet);

            // Conversion des données reçues en String et affichage
            String str = new String(packet.getData(), 0, packet.getLength());
            System.out.println("str=" + str);
        }
    }
}
