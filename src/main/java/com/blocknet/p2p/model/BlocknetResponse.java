package com.blocknet.p2p.model;

import lombok.Data;
import lombok.Getter;

public class BlocknetResponse {
    public enum ResponseStatus {
        OK, FAIL //TODO
    }
    @Getter
    private ResponseStatus status;
}
