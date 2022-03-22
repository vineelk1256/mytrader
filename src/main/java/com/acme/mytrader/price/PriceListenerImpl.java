package com.acme.mytrader.price;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.strategy.TradingStrategy;

public class PriceListenerImpl implements PriceListener {

    private TradingStrategy strategy;
    private ExecutionService executeOrder;

    public void setExecuteOrder(ExecutionService executeOrder) {
        this.executeOrder = executeOrder;
    }

    public void setTradingStrategy(TradingStrategy strategy) {
        this.strategy = strategy;
    }

    public void priceUpdate(String security, double price)
    {
        if (price > strategy.getBuyThreshold()) {  // Time to buy more stock as the price has reached the buy threshold
            executeOrder.buy(security, price, strategy.getLotSize());
        } else if (price < strategy.getSellThreshold()){ // Time to sell more stock as the price has reached the sell threshold
            executeOrder.sell(security, price, strategy.getLotSize());
        }
    }
}
