package com.umer.checkout;

import com.umer.checkout.PriceStrategy.ItemPriceRule;
import com.umer.checkout.PriceStrategy.Price;
import com.umer.checkout.PriceStrategy.PriceStrategy;
import com.umer.checkout.PriceStrategy.SpecialPriceStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckoutTest {

    public static Object[] createItemScanEntries() {
        return  new Object[]{
                new Object[]{Arrays.asList(""), 0},
                new Object[]{Arrays.asList("A"), 50},
                new Object[]{Arrays.asList("B"), 30},
                new Object[]{Arrays.asList("C"), 20},
                new Object[]{Arrays.asList("D"), 15},
                new Object[]{Arrays.asList("A","B","C","D"), 50 + 30 + 20 + 15},
                new Object[]{Arrays.asList("A","A","A"), 130},
                new Object[]{Arrays.asList("A","A","A","A","A","A"), 130 + 130 },
                new Object[]{Arrays.asList("A","A","A","A","A","A","A","A"), 130 + 130 + 50 +50 },
                new Object[]{Arrays.asList("B","B"), 45},
                new Object[]{Arrays.asList("A","B","A","A"), 130 + 30},
                new Object[]{Arrays.asList("A","B","A","A"), 130 + 30},
                new Object[]{Arrays.asList("A","B","A","A","C","B","D"), 130 + 45 + 20 + 15 },
                new Object[]{Arrays.asList("A","B","A","A","C","B","D","A","A","A"), 130 + 130 + 45 + 20 + 15 },
                new Object[]{Arrays.asList("fadfads"), 0 },
                new Object[]{Arrays.asList("A","B","fadfads","C","D"), 50 + 30 + 0 + 20 + 15 },
                new Object[]{Arrays.asList("fadfads","fadfads","A","fadfads","A","fadfads","A"), 0 + 0 + 0 + 130 },
        };

    }
    private Checkout checkPoint;

    @BeforeEach
    void setUp() {

        ItemPriceRule itemPriceRule = new ItemPriceRule();
        itemPriceRule.addItemPriceRule("A", new Price(50, 3, 130));
        itemPriceRule.addItemPriceRule("B", new Price(30, 2, 45));
        itemPriceRule.addItemPriceRule("C", new Price(20, 0, 0));
        itemPriceRule.addItemPriceRule("D", new Price(15, 0, 0));

        PriceStrategy priceStrategy = new SpecialPriceStrategy(itemPriceRule);
        checkPoint = new Checkout(priceStrategy);
    }



    @ParameterizedTest(name = "For Scanned Items \"{0}\",  Price Total should be {1}")
    @MethodSource("createItemScanEntries")
    void shouldGetTotalPriceWhenItemScannedWithRules(List<String> itemsCode, float expected) {
       itemsCode.forEach(itemCode-> {checkPoint.scanItem(itemCode);});
        assertEquals(expected,checkPoint.getTotalPrice());
    }


}