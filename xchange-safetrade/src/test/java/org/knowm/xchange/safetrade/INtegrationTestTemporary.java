package org.knowm.xchange.safetrade;

import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.safetrade.service.SafeTradeMarketDataServiceRaw;
import org.knowm.xchange.service.marketdata.MarketDataService;

import java.io.IOException;

public class INtegrationTestTemporary {

  @Test
  public void testGetPairs() throws IOException {
    Exchange safeTradeExchange = ExchangeFactory.INSTANCE.createExchange(SafeTradeExchange.class);
    SafeTradeMarketDataServiceRaw marketDataService =
        (SafeTradeMarketDataServiceRaw) safeTradeExchange.getMarketDataService();
    System.out.println(marketDataService.getExchangeSymbols());
  }

  @Test
  public void testGetDepth() throws IOException {
    Exchange safeTradeExchange = ExchangeFactory.INSTANCE.createExchange(SafeTradeExchange.class);
    SafeTradeMarketDataServiceRaw marketDataService =
            (SafeTradeMarketDataServiceRaw) safeTradeExchange.getMarketDataService();
    System.out.println(marketDataService.getMarketDepth("ethbtc"));
  }
}
