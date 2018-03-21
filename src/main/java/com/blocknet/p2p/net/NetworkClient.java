package com.blocknet.p2p.net;

import java.net.InetAddress;

public interface NetworkClient <T, U> {
    T send(U message, String address, int port);
}
