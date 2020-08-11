package com.supeream.ssl;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.net.Socket;
import java.security.SecureRandom;

public class SocketFactory {
    private SocketFactory() {
    }

    public static Socket newSocket(String host, int port, boolean isSSL) throws Exception {
        Socket socket = null;
        if (isSSL) {
            SSLContext context = SSLContext.getInstance("SSL");
            context.init(null,
                    new javax.net.ssl.TrustManager[]{new TrustManagerImpl()},
                    new SecureRandom());
            SSLSocketFactory factory = context.getSocketFactory();
            socket = factory.createSocket(host, port);
        } else {
            socket = new Socket(host, port);
        }

        return socket;
    }
}
