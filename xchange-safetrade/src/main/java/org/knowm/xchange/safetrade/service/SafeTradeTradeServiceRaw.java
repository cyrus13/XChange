package org.knowm.xchange.safetrade.service;

import org.knowm.xchange.dto.trade.OpenOrders;
import org.knowm.xchange.safetrade.SafeTradeExchange;
import org.knowm.xchange.safetrade.v2.dto.EmptyRequest;
import org.knowm.xchange.safetrade.v2.dto.account.SafeTradeWallet;
import org.knowm.xchange.safetrade.v2.dto.trade.CreateOrderRequest;
import org.knowm.xchange.safetrade.v2.dto.trade.SafeTradeOrder;
import org.knowm.xchange.safetrade.v2.dto.trade.SafeTradeTrade;
import org.knowm.xchange.service.account.AccountService;
import org.knowm.xchange.service.trade.TradeService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SafeTradeTradeServiceRaw extends SafeTradeBaseService implements TradeService {

  /**
   * Constructor
   *
   * @param exchange
   */
  public SafeTradeTradeServiceRaw(SafeTradeExchange exchange) {
    super(exchange);
  }

  public List<SafeTradeTrade> getAccountTrades() throws IOException {
    return Arrays.asList(
        safeTradeAuthenticated.getAccountTrades(
            apiKey, exchange.getNonceFactory(), signatureCreator, EmptyRequest.INSTANCE));
  }

  public List<SafeTradeOrder> getAccountOpenOrders() throws IOException {
    return Arrays.asList(
        safeTradeAuthenticated.getAccountOrders(
            apiKey, exchange.getNonceFactory(), signatureCreator, EmptyRequest.INSTANCE));
  }

  public SafeTradeOrder createOrder(CreateOrderRequest createOrderRequest) throws IOException {
    return safeTradeAuthenticated.createAccountOrder(
        apiKey,
        exchange.getNonceFactory(),
        signatureCreator,
        createOrderRequest.getMarket(),
        createOrderRequest.getSide(),
        createOrderRequest.getVolume(),
        createOrderRequest.getPrice());
  }

  public List<SafeTradeOrder> cancelAllOrders() throws IOException {
    return Arrays.asList(
        safeTradeAuthenticated.cancelAllOrders(
            apiKey, exchange.getNonceFactory(), signatureCreator, EmptyRequest.INSTANCE));
  }
}
