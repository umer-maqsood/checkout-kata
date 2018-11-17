package com.umer.checkout.PriceStrategy;

import java.util.Map;

public class SpecialPriceStrategy implements PriceStrategy {
    private ItemPriceRule itemPriceRule;

    public SpecialPriceStrategy(ItemPriceRule itemPriceRule) {
        this.itemPriceRule = itemPriceRule;
    }

    public float calculatePrice(Map<String, Integer> itemCount) {
        float totalPrice = 0;

       for(Map.Entry<String,Integer> entry : itemCount.entrySet()){
           totalPrice += itemPriceRule.calculateSpecialPrice(entry.getKey(), entry.getValue()) ;
        }
      return totalPrice;

    }


}
