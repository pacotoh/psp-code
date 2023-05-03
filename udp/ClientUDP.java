package udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ClientUDP {

    private final static int MAX_BYTES = 1400;
    private final static String COD_TEXTO = "UTF-8";

    public static void main(String[] args) {
        if (args.length < 2){
            System.err.println("ERROR: Indicar [HOST_SERVIDOR] [PUERTO]");
            System.exit(1);
        }

        String nomHost = args[0];
        int numPuerto = Integer.parseInt(args[1]);

        try(DatagramSocket clientSocket = new DatagramSocket();
            InputStreamReader sr = new InputStreamReader(System.in, COD_TEXTO);
            BufferedReader br = new BufferedReader(sr)){

            String lineaLeida;
            System.out.println("Introduce líneas. Línea vacía para terminar.");
            System.out.println(">");

            while ((lineaLeida = br.readLine()) != null && lineaLeida.length() > 0){
                InetAddress IPServidor = InetAddress.getByName(nomHost);
                byte[] b = lineaLeida.getBytes(COD_TEXTO);
                DatagramPacket paqueteEnviado = new DatagramPacket(b, b.length, IPServidor, numPuerto);
                clientSocket.connect(IPServidor, numPuerto);
                clientSocket.send(paqueteEnviado);

                byte[] datosRecibidos = new byte[MAX_BYTES];
                DatagramPacket paqueteRecibido = new DatagramPacket(datosRecibidos, datosRecibidos.length);
                clientSocket.receive(paqueteRecibido);
                String respuesta = new String(paqueteRecibido.getData(), 0,
                        paqueteRecibido.getLength(), COD_TEXTO);
                System.out.printf("Datagrama recibido de %s:%d %s\n",
                        paqueteRecibido.getAddress().getHostAddress(), paqueteRecibido.getPort(), respuesta);

                System.out.print(">");
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
