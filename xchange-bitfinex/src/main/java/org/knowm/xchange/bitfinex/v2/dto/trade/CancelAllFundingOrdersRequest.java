package org.knowm.xchange.bitfinex.v2.dto.trade;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.annotation.Nullable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CancelAllFundingOrdersRequest {
    @Nullable
    private final String currency;
}
