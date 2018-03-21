package com.blocknet.p2p.service;

import com.blocknet.p2p.model.RoutingTable;
import org.springframework.stereotype.Component;

@Component
public class RoutingTableContainer {
    private RoutingTable routingTable;

    public RoutingTable getRoutingTable() {
        return routingTable;
    }

    public void setRoutingTable(RoutingTable routingTable) {
        this.routingTable = routingTable;
    }
}
