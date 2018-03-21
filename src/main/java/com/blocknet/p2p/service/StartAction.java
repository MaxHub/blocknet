package com.blocknet.p2p.service;

import com.blocknet.p2p.model.BlocknetRequest;
import com.blocknet.p2p.model.GetRoutingTableResponse;
import com.blocknet.p2p.net.MessagingClient;
import com.blocknet.p2p.net.NetUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StartAction {

    @Autowired
    private MessagingClient messagingClient;

    @Value("${bootnode.ip}")
    private String bootnodeIP;

    @Autowired
    private RoutingTableContainer container;

    public void start() {
        String thisMachineIP = NetUtils.getThisMachineIP();
        if(!StringUtils.equals(thisMachineIP, bootnodeIP)) {
            BlocknetRequest<Object> request =
                    new BlocknetRequest<>(BlocknetRequest.RequestType.GET_ROUTING_TABLE, null);
            GetRoutingTableResponse response = messagingClient.send(request, bootnodeIP, GetRoutingTableResponse.class);
            container.setRoutingTable(response.getRoutingTable());
        } else {
            // some logging shenanigans
        }
        // TODO obtain GUID
    }
}
