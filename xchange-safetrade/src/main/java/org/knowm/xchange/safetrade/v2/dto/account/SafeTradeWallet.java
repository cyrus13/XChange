package org.knowm.xchange.safetrade.v2.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Data
@Builder
public class SafeTradeWallet {
    private final String currency;
    private final double balance;
    @JsonProperty("locked")
    private final double lockedBalance;

}
