package com.tuxy.bansapi.core.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkUtil {
    public String getIP() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        return inetAddress.getHostAddress();
    }
}
