package org.knowm.xchange.bitfinex.v2.dto.trade;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Nullable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
public class FundingOfferRequest {
    public enum FundingType{
        LIMIT,
        FFRDELTAVAR,
        FFRDELTAFIX
    }
    @JsonProperty("type")
    private final FundingType fundingType;
    private final String symbol;
    private final String amount;
    @JsonProperty("rate")
    private final String dailyRate;
    private final int period;
    private final int flags;
}
