package com.umer.checkout.PriceStrategy;

import java.util.Map;

public interface PriceStrategy {

    float calculatePrice(Map<String, Integer> itemCount);
}
