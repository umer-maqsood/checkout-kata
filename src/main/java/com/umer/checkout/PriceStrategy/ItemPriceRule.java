package com.umer.checkout.PriceStrategy;

import java.util.HashMap;
import java.util.Map;

public class ItemPriceRule {
    private Map<String, Price> itemPriceRules = new HashMap<>();

    public void addItemPriceRule(String itemCode, Price priceRule) {
        itemPriceRules.put(itemCode, priceRule);
    }

    public float calculateSpecialPrice(String itemCode, int ItemCount) {
        Price price = itemPriceRules.get(itemCode);
        if(price == null){
            return 0;
        }
        return price.calculateSpecialPrice(ItemCount);
    }
}
