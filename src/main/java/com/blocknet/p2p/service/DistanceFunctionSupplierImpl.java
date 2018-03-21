package com.blocknet.p2p.service;

import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class DistanceFunctionSupplierImpl implements DistanceFunctionSupplier {
    @Override
    public BiFunction<Long, Long, Long> getDistanceFunction() {
        return (a, b) -> a ^ b;
    }
}
