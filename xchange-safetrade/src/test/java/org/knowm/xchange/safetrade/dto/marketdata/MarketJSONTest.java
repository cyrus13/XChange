package org.knowm.xchange.safetrade.dto.marketdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MarketJSONTest {

    @Test
    public void testUnmarshal() throws IOException {
        InputStream is =
                MarketJSONTest.class.getResourceAsStream(
                        "/org/knowm/xchange/safetrade/dto/marketdata/example-markets-data.json");

        final ObjectMapper mapper = new ObjectMapper();
        final List<Market> marketList = Arrays.asList(mapper.readValue(is, Market[].class));

        // Verify that the example data was unmarshalled correctly
        assertThat(marketList.size()).isEqualTo(70);
        final Market market = marketList.get(0);


        assertThat(market.getId()).isEqualTo("safebtc");
        assertThat(market.getName()).isEqualTo("SAFE/BTC");
        assertThat(market.getBaseUnit()).isEqualTo("safe");
        assertThat(market.getQuoteUnit()).isEqualTo("btc");
        assertThat(market.getMinPrice()).isEqualTo(new BigDecimal("0.00000001"));
    }
}
