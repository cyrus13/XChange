package org.knowm.xchange.safetrade;

import org.knowm.xchange.BaseExchange;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.meta.CurrencyPairMetaData;
import org.knowm.xchange.dto.meta.ExchangeMetaData;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.safetrade.service.SafeTradeAccountService;
import org.knowm.xchange.safetrade.service.SafeTradeMarketDataService;
import org.knowm.xchange.safetrade.service.SafeTradeMarketDataServiceRaw;
import org.knowm.xchange.safetrade.service.SafeTradeTradeService;
import org.knowm.xchange.safetrade.v2.dto.marketdata.SafeTradeMarketInfo;
import org.knowm.xchange.utils.nonce.CurrentTimeIncrementalNonceFactory;
import org.knowm.xchange.utils.nonce.TimestampIncrementingNonceFactory;
import si.mazi.rescu.SynchronizedValueFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SafeTradeExchange extends BaseExchange implements Exchange {

  private final SynchronizedValueFactory<Long> safeTradeNonceFactory = new CurrentTimeIncrementalNonceFactory(TimeUnit.MILLISECONDS);

  @Override
  protected void initServices() {

    this.marketDataService = new SafeTradeMarketDataService(this);
    this.accountService = new SafeTradeAccountService(this);
    this.tradeService = new SafeTradeTradeService(this);
  }

  @Override
  public ExchangeSpecification getDefaultExchangeSpecification() {
    ExchangeSpecification exchangeSpecification = new ExchangeSpecification(this.getClass());
    exchangeSpecification.setSslUri("https://safe.trade/");
    exchangeSpecification.setHost("https://safe.trade/");
    exchangeSpecification.setPort(443);
    //        exchangeSpecification.setExchangeName("SafeTrade");
    exchangeSpecification.setExchangeDescription("SafeTrade is a bitcoin exchange.");
    exchangeSpecification.getResilience().setRateLimiterEnabled(false);
    exchangeSpecification.getResilience().setRetryEnabled(false);
    exchangeSpecification.setShouldLoadRemoteMetaData(true);

    return exchangeSpecification;
  }

  @Override
  public void remoteInit() throws IOException, ExchangeException {
    Map<CurrencyPair, CurrencyPairMetaData> currencyPairs = new HashMap<>();
    final SafeTradeMarketDataServiceRaw dataService =
        (SafeTradeMarketDataServiceRaw) this.marketDataService;
    final List<SafeTradeMarketInfo> marketInfoList = dataService.getMarketInfo();

    for (SafeTradeMarketInfo marketInfo : marketInfoList) {
      final CurrencyPair currencyPair = SafeTradeAdapters.adaptCurrencyPair(marketInfo);
      final CurrencyPairMetaData currencyPairMetaData =
          new CurrencyPairMetaData.Builder()
              .marketOrderEnabled(marketInfo.getState().equals("enabled"))
              .minimumAmount(marketInfo.getMinAmount())
              .baseScale(marketInfo.getAmountPrecision())
              .priceScale(marketInfo.getPricePrecision())
              .build();
      currencyPairs.put(currencyPair, currencyPairMetaData);
    }

    exchangeMetaData = new ExchangeMetaData(currencyPairs, null, null, null, null);
  }

  @Override
  public SynchronizedValueFactory<Long> getNonceFactory() {
    return safeTradeNonceFactory;
  }
}
