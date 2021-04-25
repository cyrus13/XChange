package org.knowm.xchange.safetrade.v2.dto.marketdata;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Jacksonized
@Data
@Builder
public class SafeTradeMarketDepth {
    private final long timestamp;
    private final DepthElement[] asks;
    private final DepthElement[] bids;

    public ZonedDateTime getTimeStampAsZoned() {
        final Instant instant = Instant.ofEpochSecond(timestamp);
        return ZonedDateTime.ofInstant(instant, ZoneOffset.UTC);
    }


    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    @Jacksonized
    @Builder
    @Data
    public static class DepthElement{
        private BigDecimal price;
        private BigDecimal quantity;
    }
}
