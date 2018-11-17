package com.umer.checkout.PriceStrategy;

public class Price {

    private float unitPrice;
    private int unitsForSpecialPrice;
    private float specialPrice;

    public Price(float unitPrice, int numberOfUnitsForSpecialPrice, float specialPrice) {
        this.unitPrice = unitPrice;
        this.unitsForSpecialPrice = numberOfUnitsForSpecialPrice;
        this.specialPrice = specialPrice;
    }

    public float calculateSpecialPrice(int itemCount) {
        int specialPriceMultiple = 0;
        int singleUnitMultiple = 1;

        if (unitsForSpecialPrice != 0) {
            specialPriceMultiple = Math.floorDiv(itemCount, unitsForSpecialPrice);
            singleUnitMultiple = itemCount % unitsForSpecialPrice;
        }
        return singleUnitMultiple * unitPrice + specialPriceMultiple * specialPrice;
    }

}
