package com.umer.checkout;

import com.umer.checkout.PriceStrategy.PriceStrategy;

import java.util.HashMap;
import java.util.Map;

public class Checkout {
    private Map<String, Integer> itemCountMap = new HashMap<>();
    private PriceStrategy priceStrategy;

    public Checkout(PriceStrategy priceStrategy){
        this.priceStrategy = priceStrategy;
    }

    public void scanItem(String itemCode){

        if(itemCountMap.get(itemCode)!=null){
            int count =itemCountMap.get(itemCode);
            itemCountMap.put(itemCode, ++count);
        }else{
            itemCountMap.put(itemCode,1);
        }
   }

    public float getTotalPrice(){
        return priceStrategy.calculatePrice(itemCountMap);
    }
}
