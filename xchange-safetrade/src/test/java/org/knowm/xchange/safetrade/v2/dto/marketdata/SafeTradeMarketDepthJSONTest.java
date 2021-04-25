package org.knowm.xchange.safetrade.v2.dto.marketdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SafeTradeMarketDepthJSONTest {

  @Test
  public void testUnmarshal() throws IOException {
    InputStream is =
        SafeTradeMarketDepthJSONTest.class.getResourceAsStream(
            "/org/knowm/xchange/safetrade/v2/dto/marketdata/example-market-depth-data.json");

    final ObjectMapper mapper = new ObjectMapper();
    final SafeTradeMarketDepth safeTradeMarketDepth =
        mapper.readValue(is, SafeTradeMarketDepth.class);

    // Verify that the example data was unmarshalled correctly
    assertThat(safeTradeMarketDepth.getTimeStampAsZoned())
        .isEqualTo(ZonedDateTime.of(2021, 4, 25, 21, 45, 18, 0, ZoneOffset.UTC));
    assertThat(safeTradeMarketDepth.getBids().length).isEqualTo(55);
    assertThat(safeTradeMarketDepth.getAsks().length).isEqualTo(72);

    assertThat(safeTradeMarketDepth.getBids()[0])
        .isEqualTo(
            SafeTradeMarketDepth.DepthElement.builder()
                .quantity(new BigDecimal("0.2749"))
                .price(new BigDecimal("0.031"))
                .build());
    assertThat(safeTradeMarketDepth.getAsks()[0])
        .isEqualTo(
            SafeTradeMarketDepth.DepthElement.builder()
                .quantity(new BigDecimal("0.0001"))
                .price(new BigDecimal("0.0325"))
                .build());
  }
}
