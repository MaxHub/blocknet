package com.blocknet.p2p.service;

import org.springframework.stereotype.Service;

@Service
public class FullUpdateOfRoutingTableAction {
    public void findAndUpdateRT() {
        // TODO We will try to update routing table after copying it from boot node
        // We should find all nodes that are in 2^n distance from us
    }
}
