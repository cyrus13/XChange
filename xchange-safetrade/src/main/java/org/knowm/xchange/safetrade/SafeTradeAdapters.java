package org.knowm.xchange.safetrade;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.safetrade.v2.dto.marketdata.SafeTradeMarketInfo;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SafeTradeAdapters {

  public static List<CurrencyPair> adaptCurrencyPairs(
      List<SafeTradeMarketInfo> safeTradeMarketInfoList) {
    return safeTradeMarketInfoList.stream()
        .map(SafeTradeAdapters::adaptCurrencyPair)
        .collect(Collectors.toList());
  }

  public static CurrencyPair adaptCurrencyPair(
          SafeTradeMarketInfo safeTradeMarketInfo) {
    return new CurrencyPair(safeTradeMarketInfo.getBaseUnit(), safeTradeMarketInfo.getQuoteUnit());
  }
}
