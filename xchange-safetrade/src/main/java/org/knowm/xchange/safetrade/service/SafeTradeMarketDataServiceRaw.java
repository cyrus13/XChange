package org.knowm.xchange.safetrade.service;

import org.knowm.xchange.client.ExchangeRestProxyBuilder;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.safetrade.SafeTradeAdapters;
import org.knowm.xchange.safetrade.SafeTradeExchange;
import org.knowm.xchange.safetrade.v2.SafeTrade;
import org.knowm.xchange.safetrade.v2.dto.marketdata.SafeTradeMarketDepth;
import org.knowm.xchange.safetrade.v2.dto.marketdata.SafeTradeMarketInfo;
import org.knowm.xchange.service.BaseService;

import java.io.IOException;
import java.util.List;

public class SafeTradeMarketDataServiceRaw implements BaseService {

    protected final SafeTrade safeTrade;

    public SafeTradeMarketDataServiceRaw(SafeTradeExchange safeTradeExchange){
        this.safeTrade = ExchangeRestProxyBuilder.forInterface(
                SafeTrade.class,  safeTradeExchange.getExchangeSpecification()
        ).build();
    }

    public List<SafeTradeMarketInfo> getMarketInfo() throws IOException {
        return  safeTrade.getMarketInfo();
    }

    public List<CurrencyPair> getExchangeSymbols() throws IOException {
        final List<SafeTradeMarketInfo> safeTradeMarketInfoList = getMarketInfo();
        return SafeTradeAdapters.adaptCurrencyPairs(safeTradeMarketInfoList);
    }

    public SafeTradeMarketDepth getMarketDepth(String symbol) throws IOException {
        return safeTrade.getMarketDepth(symbol);
    }
}
