package md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GeneracionHash {

    private static String valorHexadecimal(byte[] bytes){
        String resultado = "";
        for (Byte b: bytes) {
            resultado += String.format(String.format("%x", b));
        }
        return resultado;
    }
    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Introduce la cadena de caracteres para calcular su hash");
            return;
        }

        String cadena = args[0];

        for(int i = 0; i < args.length; i++){
            cadena += " " +args[i];
        }

        MessageDigest md;

        try {
            byte[] bytes = cadena.getBytes();
            // Se puede usar con los algoritmos md5sum, sha1sum, sha224sum, sha256sum, etc.
            md = MessageDigest.getInstance("SHA-256");
            md.update(bytes);
            byte[] hash = md.digest();
            System.out.printf("Cadena: %s\nHash: %s\n", cadena, valorHexadecimal(hash));
        } catch(NoSuchAlgorithmException e) {
            System.out.println("Algoritmo de hash no disponible");
        }
    }
}
