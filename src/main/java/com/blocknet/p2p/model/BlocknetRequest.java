package com.blocknet.p2p.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
public class BlocknetRequest<T> {
    public enum RequestType {
        GET_ROUTING_TABLE, CHECK_IS_ONLINE, FIND_NODE //TODO
    }
    private RequestType type;
    private T payload;
    private OffsetDateTime timestamp;

    public BlocknetRequest(RequestType type, T payload) {
        this.type = type;
        this.payload = payload;
        this.timestamp = OffsetDateTime.now();
    }
}
