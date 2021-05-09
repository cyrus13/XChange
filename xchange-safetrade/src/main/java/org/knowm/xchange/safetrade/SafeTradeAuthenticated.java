package org.knowm.xchange.safetrade;

import org.knowm.xchange.safetrade.v2.SafeTrade;
import org.knowm.xchange.safetrade.v2.dto.EmptyRequest;
import org.knowm.xchange.safetrade.v2.dto.account.SafeTradeWallet;
import org.knowm.xchange.safetrade.v2.dto.trade.CreateOrderRequest;
import org.knowm.xchange.safetrade.v2.dto.trade.SafeTradeOrder;
import org.knowm.xchange.safetrade.v2.dto.trade.SafeTradeTrade;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.SynchronizedValueFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/api/v2/peatio/")
public interface SafeTradeAuthenticated extends SafeTrade {

  public static final String SAFE_APIKEY = "X-Auth-Apikey";
  public static final String SAFE_NONCE = "X-Auth-Nonce";
  public static final String SAFE_SIGNATURE = "X-Auth-Signature";

  @POST
  @Path("market/orders/{orderId}")
  SafeTradeOrder getOrderInformation(
      @HeaderParam(SAFE_APIKEY) String apiKey,
      @HeaderParam(SAFE_NONCE) SynchronizedValueFactory<Long> nonce,
      @HeaderParam(SAFE_SIGNATURE) ParamsDigest signer,
      @PathParam("orderId") String orderId)
      throws IOException;

  @GET
  @Path("account/balances")
  SafeTradeWallet[] getWalletBalances(
      @HeaderParam(SAFE_APIKEY) String apiKey,
      @HeaderParam(SAFE_NONCE) SynchronizedValueFactory<Long> nonce,
      @HeaderParam(SAFE_SIGNATURE) ParamsDigest signer,
      EmptyRequest empty)
      throws IOException;

  @GET
  @Path("market/trades")
  SafeTradeTrade[] getAccountTrades(
      @HeaderParam(SAFE_APIKEY) String apiKey,
      @HeaderParam(SAFE_NONCE) SynchronizedValueFactory<Long> nonce,
      @HeaderParam(SAFE_SIGNATURE) ParamsDigest signer,
      EmptyRequest empty)
      throws IOException;

  @GET
  @Path("market/orders")
  SafeTradeOrder[] getAccountOrders(
      @HeaderParam(SAFE_APIKEY) String apiKey,
      @HeaderParam(SAFE_NONCE) SynchronizedValueFactory<Long> nonce,
      @HeaderParam(SAFE_SIGNATURE) ParamsDigest signer,
      EmptyRequest empty)
      throws IOException;

  @POST
  @Path("market/orders")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  SafeTradeOrder createAccountOrder(
      @HeaderParam(SAFE_APIKEY) String apiKey,
      @HeaderParam(SAFE_NONCE) SynchronizedValueFactory<Long> nonce,
      @HeaderParam(SAFE_SIGNATURE) ParamsDigest signer,
      @FormParam("market") String market,
      @FormParam("side") String side,
      @FormParam("volume") double volume,
      @FormParam("price") double price)
      throws IOException;

  @POST
  @Path("market/orders/cancel")
  SafeTradeOrder[] cancelAllOrders(
      @HeaderParam(SAFE_APIKEY) String apiKey,
      @HeaderParam(SAFE_NONCE) SynchronizedValueFactory<Long> nonce,
      @HeaderParam(SAFE_SIGNATURE) ParamsDigest signer,
      EmptyRequest emptyRequest)
      throws IOException;
}
