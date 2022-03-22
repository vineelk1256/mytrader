package com.acme.mytrader.strategy;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.PriceListenerImpl;
import com.acme.mytrader.price.PriceSource;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class TradingStrategyTest {
    PriceSource priceSource;
    TradingStrategy tradingStrategy;
    ExecutionService executionService;
    PriceListener priceListener;

    @Test
    public void testBuyOrder() {
        priceSource = mock(PriceSource.class);
        executionService = mock(ExecutionService.class);
        tradingStrategy = new TradingStrategy(100, 50, 150);// 100 => lot size, 50$ => sell threshold, 150$ => buy threshold
        priceListener = CreatePriceListener(tradingStrategy, executionService);
        priceSource.addPriceListener(priceListener);
    }

    // Below method creates the implementation of PriceListener. It takes TradingStrategy and ExecutionService as input
    // so that the sell/buy orders can be made based on the strategy.
    private static PriceListener CreatePriceListener(TradingStrategy tradingStrategy, ExecutionService executionService) {
        PriceListenerImpl priceListener = new PriceListenerImpl();
        priceListener.setTradingStrategy(tradingStrategy);
        priceListener.setExecuteOrder(executionService);
        return priceListener;
    }
}
