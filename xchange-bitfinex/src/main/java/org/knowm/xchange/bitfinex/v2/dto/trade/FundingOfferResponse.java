package org.knowm.xchange.bitfinex.v2.dto.trade;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@Jacksonized
@Data
@Builder
public class FundingOfferResponse {
    private final long messageTimestamp;
    private final String type;
    private final String messageId;
    private final Object placeHolder1;
    private final FundingOfferResponseDetail fundingOfferResponseDetailList;
    private final Integer code;
    private final String status;
    private final String text;


    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    @Jacksonized
    @Data
    @Builder
    public static class FundingOfferResponseDetail{
        private final long fundingOrderDetailId;
        private final String symbol;
        private final long timeOfferCreatedMillis;
        private final long timeOfferUpdatedMillis;
        private final double amount;
        private final double amountOriginal;
        private final String offerType;
        private final Object placeHolder1;
        private final Object placeHolder2;
        private final int flags;
        private final String offerStatus;
        private final Object placeHolder3;
        private final Object placeHolder4;
        private final Object placeHolder5;
        private final double rate;
        private final int period;
        private final boolean notify;
        private final int hidden;
        private final Object placeHolder6;
        private final boolean renew;
        private final Object placeHolder7;
    }
}
