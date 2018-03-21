package com.blocknet.p2p.net;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

@Component
public class UDPClient implements NetworkClient<String, String> {

    @Value("${udp.response.buffer.size:1000}")
    private int responseBufferSize;
    @Value("${udp.response.timeout:2000}")
    private int responseTimeout;

    @Override
    public String send(String message, String address, int port) {
        DatagramSocket socket = null;
        String response = null;
        try {
            socket = new DatagramSocket();
            DatagramPacket request = createRequest(message, InetAddress.getByName(address), port);
            socket.send(request);

            response = getResponse(socket);
        } catch (SocketTimeoutException e) {
            //TODO throw some service Exception
            e.printStackTrace(); //TODO add logger
        } catch (Exception e) {
            //TODO throw some service Exception different from the upper one
            e.printStackTrace();
        } finally {
            socket.close();
        }
        return response;
    }

    private String getResponse(DatagramSocket socket) throws IOException {
        byte[] buffer = new byte[responseBufferSize];
        DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
        socket.setSoTimeout(responseTimeout);
        socket.receive(reply);
        String response = new String(reply.getData());
        response = response.trim();
        return response;
    }

    private DatagramPacket createRequest(String message, InetAddress address, int port) {
        byte[] byteData = message.getBytes();
        return new DatagramPacket(byteData, message.length(), address, port);
    }
}
