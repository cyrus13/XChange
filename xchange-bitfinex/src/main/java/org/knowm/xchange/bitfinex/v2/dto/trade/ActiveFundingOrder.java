package org.knowm.xchange.bitfinex.v2.dto.trade;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

/** @author cyrus13 **/

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@Jacksonized
@Data
@Builder
public class ActiveFundingOrder {
    private final long fundingId;
    private final String symbol;
    private final long createdTimestampMillis;
    private final long updatedTimestampMillis;
    private final double amount;
    private final double amountOriginal;
    private final String type;
    private final Object placeholder1;
    private final Object placeholder2;
    private final Object flags;
    private final String status;
    private final Object placeholder3;
    private final Object placeholder4;
    private final Object placeholder5;
    private final double rate;
    private final int period;
    private final boolean notify;
    private final boolean hidden;
    private final Object placeholder6;
    private final boolean renew;
}
