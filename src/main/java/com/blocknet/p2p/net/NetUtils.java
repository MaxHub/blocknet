package com.blocknet.p2p.net;

import java.net.Inet4Address;
import java.net.UnknownHostException;

public class NetUtils {

    // TODO https://stackoverflow.com/a/20418809
    public static String getThisMachineIP() {
        try {
            return Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace(); // TODO
        }
        throw new RuntimeException(); // TODO
    }
}
