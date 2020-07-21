package com.supeream.ssl;

import javax.net.ssl.TrustManager;
import java.security.cert.X509Certificate;

public class WeblogicTrustManager implements TrustManager {
    public boolean certificateCallback(X509Certificate[] x509Certificates, int i) {
        return true;
    }
}
