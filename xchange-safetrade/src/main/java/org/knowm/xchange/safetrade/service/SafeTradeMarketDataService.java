package org.knowm.xchange.safetrade.service;

import org.knowm.xchange.safetrade.SafeTradeExchange;
import org.knowm.xchange.service.marketdata.MarketDataService;

public class SafeTradeMarketDataService extends SafeTradeMarketDataServiceRaw implements MarketDataService {

    public SafeTradeMarketDataService(SafeTradeExchange safeTradeExchange) {
        super(safeTradeExchange);
    }
}
