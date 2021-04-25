package org.knowm.xchange.safetrade.v2.dto.marketdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SafeTradeMarketInfoJSONTest {

    @Test
    public void testUnmarshal() throws IOException {
        InputStream is =
                SafeTradeMarketInfoJSONTest.class.getResourceAsStream(
                        "/org/knowm/xchange/safetrade/v2/dto/marketdata/example-markets-data.json");

        final ObjectMapper mapper = new ObjectMapper();
        final List<SafeTradeMarketInfo> safeTradeMarketInfoList = Arrays.asList(mapper.readValue(is, SafeTradeMarketInfo[].class));

        // Verify that the example data was unmarshalled correctly
        assertThat(safeTradeMarketInfoList.size()).isEqualTo(70);
        final SafeTradeMarketInfo safeTradeMarketInfo = safeTradeMarketInfoList.get(0);

        assertThat(safeTradeMarketInfo.getId()).isEqualTo("safebtc");
        assertThat(safeTradeMarketInfo.getName()).isEqualTo("SAFE/BTC");
        assertThat(safeTradeMarketInfo.getBaseUnit()).isEqualTo("safe");
        assertThat(safeTradeMarketInfo.getQuoteUnit()).isEqualTo("btc");
        assertThat(safeTradeMarketInfo.getMinPrice()).isEqualTo(new BigDecimal("0.00000001"));
        assertThat(safeTradeMarketInfo.getMaxPrice()).isEqualTo(new BigDecimal("1000000.0"));
        assertThat(safeTradeMarketInfo.getMinAmount()).isEqualTo(new BigDecimal("1.0"));
        assertThat(safeTradeMarketInfo.getAmountPrecision()).isEqualTo(2);
        assertThat(safeTradeMarketInfo.getPricePrecision()).isEqualTo(8);
    }
}
