package com.blocknet.p2p.net;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetAddress;

@Component
public class MessagingClientImpl implements MessagingClient {
    @Autowired
    private NetworkClient<String, String> networkClient;
    @Autowired
    private ObjectMapper objectMapper;

    @Value("${default.node.port:55555}")
    private int port;

    @Override
    public<T> T send(Object message, String address, Class<T> clazz) {
        try {
            String msgString = objectMapper.writeValueAsString(message);
            String response = networkClient.send(msgString, address, port);
            return objectMapper.readValue(response, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace(); //TODO
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException(); //TODO
    }
}
