package com.umer.checkout.PriceStrategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceStrategyTest {
    private com.umer.checkout.PriceStrategy.ItemPriceRule itemPriceRule;
    private com.umer.checkout.PriceStrategy.PriceStrategy priceStrategy;
    private Map<String, Integer> itemCount;

    private static Object createItemCountEntries() {

        return Arrays.asList(new Object[][] {
                { "A", 1,50 }, { "B",1,30 }, { "C",1,20 }, { "D",1,15 }, { "E",1, 0 },
                { "A", 3,130 }, { "B",2,45 }, { "A",7, 130+130+50 }, { "B",5, 45+45+ 30}
        });
     }

    @BeforeEach
    void setUp() {
        itemPriceRule = new ItemPriceRule();
        itemPriceRule.addItemPriceRule("A", new Price(50, 3, 130));
        itemPriceRule.addItemPriceRule("B", new Price(30, 2, 45));
        itemPriceRule.addItemPriceRule("C", new Price(20, 0, 0));
        itemPriceRule.addItemPriceRule("D", new Price(15, 0, 0));

        priceStrategy = new SpecialPriceStrategy(itemPriceRule);

    }

    @ParameterizedTest(name = "For Item \"{0}\" with count {1} , Price Total should be {2}")
    @MethodSource("createItemCountEntries")
    void shouldProvideCorrectTotalWithGivenItemCount(String itemCode, int itemCount, int expected) {
        Map<String, Integer> itemCountMap = new HashMap<>();
        itemCountMap.put(itemCode,itemCount);

        assertEquals(expected, priceStrategy.calculatePrice(itemCountMap));
    }

}