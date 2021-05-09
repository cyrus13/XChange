package org.knowm.xchange.safetrade.v2.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import org.knowm.xchange.dto.Order;

import java.time.ZonedDateTime;

@Jacksonized
@Data
@Builder
public class SafeTradeTrade {
  private final String id;
  private final double price;
  private final double amount;
  /** Trade total (Amount * Price) * */
  @JsonProperty("total")
  private final double totalAmount;

  @JsonProperty("fee_currency")
  private final String feeCurrency;
  /** Percentage of fee user was charged for performed trade. * */
  @JsonProperty("fee")
  private final double feePercentage;

  @JsonProperty("fee_amount")
  private final double feeAmount;

  @JsonProperty("market")
  private final String marketId;

  @JsonProperty("created_at")
  private final String createdAt;

  @JsonProperty("taker_type")
  private final String oppositeSide;

  private final String side;

  @JsonProperty("order_id")
  private final int orderId;

  public ZonedDateTime getCreatedAt() {
    return ZonedDateTime.parse(createdAt);
  }

  public Order.OrderType getOppositeOrderType() {
    if ("buy".equalsIgnoreCase(oppositeSide)) {
        return Order.OrderType.ASK;
    }else if ("sell".equalsIgnoreCase(oppositeSide)){
        return Order.OrderType.BID;
    }else {
        throw new RuntimeException("Cannot map opposite side");
    }
  }

    public Order.OrderType getOrderType() {
        if ("buy".equalsIgnoreCase(side)) {
            return Order.OrderType.ASK;
        }else if ("seØll".equalsIgnoreCase(side)){
            return Order.OrderType.BID;
        }else {
            throw new RuntimeException("Cannot map opposite side");
        }
    }
}
