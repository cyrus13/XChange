package org.knowm.xchange.safetrade.service;

import org.knowm.xchange.client.ExchangeRestProxyBuilder;
import org.knowm.xchange.safetrade.SafeTradeAuthenticated;
import org.knowm.xchange.safetrade.SafeTradeExchange;
import org.knowm.xchange.safetrade.SafeTradeHmacSignature;
import org.knowm.xchange.service.BaseExchangeService;
import org.knowm.xchange.service.BaseService;

public class SafeTradeBaseService extends BaseExchangeService implements BaseService {

    protected final String apiKey;
    protected final SafeTradeAuthenticated safeTradeAuthenticated;

    protected final SafeTradeHmacSignature signatureCreator;


    /**
     * Constructor
     *
     * @param exchange
     */
    public SafeTradeBaseService(SafeTradeExchange exchange) {
        super(exchange);

        this.safeTradeAuthenticated = ExchangeRestProxyBuilder.forInterface(
                SafeTradeAuthenticated.class, exchange.getExchangeSpecification())
                .build();
        this.apiKey = exchange.getExchangeSpecification().getApiKey();
        this.signatureCreator = SafeTradeHmacSignature.create(exchange.getExchangeSpecification().getSecretKey(), exchange.getExchangeSpecification().getApiKey());
    }
}
