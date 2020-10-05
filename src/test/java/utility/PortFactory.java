package utility;

import java.net.ServerSocket;

public class PortFactory {
    public static int create() throws Exception {
        ServerSocket socket = new ServerSocket(0);
        socket.setReuseAddress(true);
        int port = socket.getLocalPort();
        socket.close();
        return port;
    }

}
