package org.knowm.xchange.safetrade.v2.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.time.ZonedDateTime;

@Jacksonized
@Data
@Builder
public class SafeTradeOrder {
  private final int id;
  private final String side;
  @JsonProperty("ord_type")
  private final String orderType;
  private final double price;
  @JsonProperty("avg_price")
  private final double averagePrice;
  /**
   * One of 'wait', 'done', or 'cancel'.An order in 'wait' is an active order, waiting fulfillment;a
   * 'done' order is an order fulfilled;'cancel' means the order has been canceled.
   */
  private final String state;
  private final String market;
  @JsonProperty("created_at")
  private final String createdAt;
  @JsonProperty("updated_at")
  private final String updateAt;
  @JsonProperty("origin_volume")
  private final double originalVolume;
    @JsonProperty("remaining_volume")
  private final double remainingVolume;
    @JsonProperty("executed_volume")
    private final double executedVolume;
    @JsonProperty("trades_count")
    private final int tradesCount;
    private final SafeTradeTrade[] trades;

  public ZonedDateTime getCreatedAt() {
    return ZonedDateTime.parse(createdAt);
  }

  public ZonedDateTime getUpdatedAt() {
    return ZonedDateTime.parse(updateAt);
  }
}
