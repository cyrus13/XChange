package org.knowm.xchange.safetrade.v2;

import org.knowm.xchange.safetrade.v2.dto.marketdata.SafeTradeMarketDepth;
import org.knowm.xchange.safetrade.v2.dto.marketdata.SafeTradeMarketInfo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/api/v2/peatio/")
@Produces(MediaType.APPLICATION_JSON)
public interface SafeTrade {

    @GET
    @Path("public/markets")
    List<SafeTradeMarketInfo> getMarketInfo() throws IOException;

    @GET
    @Path("public/markets/{symbol}/depth")
    SafeTradeMarketDepth getMarketDepth(@PathParam("symbol") String symbol) throws IOException;
}
