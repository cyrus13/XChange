package org.knowm.xchange.bitfinex.v2.dto.trade;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@Jacksonized
@Data
@Builder
public class CancelAllFundingOrdersResponse {
    private final long cancellationTimestamp;
    private final String type;
    private final Object placeHolder1;
    private final Object placeHolder2;
    private final Object placeHolder3;
    private final Object placeHolder4;
    private final String status;
    private final String text;
}
