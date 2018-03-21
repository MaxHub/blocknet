package com.blocknet.p2p.model;

import lombok.Data;

import java.util.List;

@Data
public class RoutingTable {
    private List<RoutingRow> rows;
}
