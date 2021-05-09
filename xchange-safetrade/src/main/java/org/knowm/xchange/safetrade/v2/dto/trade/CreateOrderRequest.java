package org.knowm.xchange.safetrade.v2.dto.trade;


import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Data
@Builder
public class CreateOrderRequest {
    private final String market;
    private final String side;
    private final double volume;
    private final double price;
}
