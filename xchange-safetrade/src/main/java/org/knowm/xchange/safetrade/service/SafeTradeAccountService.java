package org.knowm.xchange.safetrade.service;

import org.knowm.xchange.safetrade.SafeTradeExchange;
import org.knowm.xchange.service.account.AccountService;

public class SafeTradeAccountService extends SafeTradeAccountServiceRaw implements AccountService {
    /**
     * Constructor
     *
     * @param exchange
     */
    public SafeTradeAccountService(SafeTradeExchange exchange) {
        super(exchange);
    }
}
