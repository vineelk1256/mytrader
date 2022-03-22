package com.acme.mytrader.strategy;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
public class TradingStrategy {

    private int LotSize = 100;
    private int SellThreshold = 100;
    private int BuyThreshold = 100;

    public TradingStrategy(int lotSize, int sellThreshold, int buyThreshold) {
        LotSize = lotSize;
        SellThreshold = sellThreshold;
        BuyThreshold = buyThreshold;
    }

    public int getLotSize() {
        return LotSize;
    }

    public int getSellThreshold() {
        return SellThreshold;
    }

    public int getBuyThreshold() {
        return BuyThreshold;
    }
}
