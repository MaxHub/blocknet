package com.blocknet.p2p.service;

import java.util.function.BiFunction;

public interface DistanceFunctionSupplier {
    BiFunction<Long, Long, Long> getDistanceFunction();
}
