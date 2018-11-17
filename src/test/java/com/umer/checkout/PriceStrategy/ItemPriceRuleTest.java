package com.umer.checkout.PriceStrategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemPriceRuleTest {
    @Test
    void shouldReturnZeroForItemWithNoPriceRule(){
        ItemPriceRule itemPriceRule = new ItemPriceRule();
        assertEquals(0,itemPriceRule.calculateSpecialPrice("A",1));
      }
   }