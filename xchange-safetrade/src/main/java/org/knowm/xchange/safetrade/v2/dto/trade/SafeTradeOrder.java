package org.knowm.xchange.safetrade.v2.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Data
@Builder
public class SafeTradeOrder {
    private final int id;
    private final String side;
    @JsonProperty("ord_type")
    private final String orderType;
    private final double price;
}
