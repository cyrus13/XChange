package org.knowm.xchange.safetrade.service;

import org.knowm.xchange.safetrade.SafeTradeExchange;
import org.knowm.xchange.safetrade.v2.dto.EmptyRequest;
import org.knowm.xchange.safetrade.v2.dto.account.SafeTradeWallet;
import org.knowm.xchange.service.account.AccountService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SafeTradeAccountServiceRaw extends SafeTradeBaseService implements AccountService {

  /**
   * Constructor
   *
   * @param exchange
   */
  public SafeTradeAccountServiceRaw(SafeTradeExchange exchange) {
    super(exchange);
  }

  public List<SafeTradeWallet> getWallets() throws IOException {
    return Arrays.asList(
        safeTradeAuthenticated.getWalletBalances(
                apiKey, exchange.getNonceFactory(), signatureCreator, EmptyRequest.INSTANCE));
  }
}
