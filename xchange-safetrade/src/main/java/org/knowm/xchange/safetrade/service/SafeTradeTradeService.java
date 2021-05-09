package org.knowm.xchange.safetrade.service;

import org.knowm.xchange.safetrade.SafeTradeExchange;
import org.knowm.xchange.service.account.AccountService;
import org.knowm.xchange.service.trade.TradeService;

public class SafeTradeTradeService extends SafeTradeTradeServiceRaw implements TradeService {
    /**
     * Constructor
     *
     * @param exchange
     */
    public SafeTradeTradeService(SafeTradeExchange exchange) {
        super(exchange);
    }
}
