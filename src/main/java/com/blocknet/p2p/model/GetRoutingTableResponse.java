package com.blocknet.p2p.model;

import lombok.Getter;

public class GetRoutingTableResponse extends BlocknetResponse {
    @Getter
    private RoutingTable routingTable;
}
