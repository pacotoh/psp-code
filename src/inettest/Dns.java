package inettest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Dns {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress add = InetAddress.getByName("www.google.es");
        System.out.println(add.getHostName() + ", " + add.getHostAddress());

        InetAddress add2 = InetAddress.getByAddress(new byte[] {8, 8, 8, 8});
        System.out.println(add2.getHostName() + ", " + add2.getCanonicalHostName());

    }
}
