package com.blocknet.p2p.model;

import lombok.Data;
import sun.security.x509.IPAddressName;

import java.net.InetAddress;

@Data
public class NetNode {
    private Long giud;
    private String name;
    private InetAddress address;
}
