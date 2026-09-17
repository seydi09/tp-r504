import java.io.*;
import java.net.*;

public class ClientUDP {
    public static void main(String[] args) throws Exception {
        // Obtenir l'adresse locale et afficher son nom d'hôte
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println("adresse=" + addr.getHostName());

        // Déclaration et conversion du message en bytes
        String s = "Hello World";
        byte[] data = s.getBytes();

        // Création du paquet UDP à destination du port 1234
        DatagramPacket packet = new DatagramPacket(data, data.length, addr, 1234);

        // Création du socket et envoi
        DatagramSocket sock = new DatagramSocket();
        sock.send(packet);
        sock.close();
    }
}
