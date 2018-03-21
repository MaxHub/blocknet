package com.blocknet.p2p.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.Period;

@Data
public class RoutingRow {
    private NetNode netNode;
    private Long distance;
    private Boolean isOnline;
    private LocalDateTime lastTimeOnline;
}
