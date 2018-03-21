package com.blocknet.p2p.net;

import java.net.InetAddress;

public interface MessagingClient {

    <T> T send(Object message, String address, Class<T> clazz);
}
