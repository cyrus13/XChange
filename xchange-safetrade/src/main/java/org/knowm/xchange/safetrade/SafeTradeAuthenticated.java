package org.knowm.xchange.safetrade;

import org.knowm.xchange.safetrade.v2.SafeTrade;
import org.knowm.xchange.safetrade.v2.dto.EmptyRequest;
import org.knowm.xchange.safetrade.v2.dto.account.SafeTradeWallet;
import org.knowm.xchange.safetrade.v2.dto.trade.SafeTradeOrder;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.SynchronizedValueFactory;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
            @PathParam("orderId") String orderId) throws IOException;

    @GET
    @Path("account/balances")
    SafeTradeWallet[] getWalletBalances(
            @HeaderParam(SAFE_APIKEY) String apiKey,
            @HeaderParam(SAFE_NONCE) SynchronizedValueFactory<Long> nonce,
            @HeaderParam(SAFE_SIGNATURE) ParamsDigest signer,
            EmptyRequest empty)
                throws IOException;

}
