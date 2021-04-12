package org.knowm.xchange.safetrade.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

/**
 *
 */
@Jacksonized
@Builder
@Data
public class Market {
    private final String id;
    private final String name;
    @JsonProperty("base_unit")
    private final String baseUnit;
    @JsonProperty("quote_unit")
    private final String quoteUnit;
    @JsonProperty("min_price")
    private final BigDecimal minPrice;
    @JsonProperty("max_price")
    private final String maxPrice;
    @JsonProperty("min_amount")
    private final String minAmount;
    @JsonProperty("amount_precision")
    private final Integer amountPrecision;
    @JsonProperty("price_precision")
    private final Integer pricePrecision;
    private final String state;
}