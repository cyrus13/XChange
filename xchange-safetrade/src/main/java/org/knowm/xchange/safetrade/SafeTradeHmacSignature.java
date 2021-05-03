package org.knowm.xchange.safetrade;

import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.service.BaseParamsDigest;
import org.knowm.xchange.utils.DigestUtils;
import si.mazi.rescu.RestInvocation;

import javax.crypto.Mac;
import javax.ws.rs.HeaderParam;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class SafeTradeHmacSignature extends BaseParamsDigest {
  private static final String UTF_8 = "UTF-8";

  private final String apiKey;

  private SafeTradeHmacSignature(String secretKeyBase64, String apiKey) {

    super(secretKeyBase64, HMAC_SHA_256);
    this.apiKey = apiKey;
  }

  public static SafeTradeHmacSignature create(String secretKeyBase64, String apiKey){
    return secretKeyBase64 == null ? null : new SafeTradeHmacSignature(secretKeyBase64,apiKey);
  }

  @Override
  public String digestParams(RestInvocation restInvocation) {

    //    OpenSSL::HMAC.hexdigest("SHA256", secret, nonce + api_key)

    final Object nonce =
        restInvocation.getParamValue(HeaderParam.class, SafeTradeAuthenticated.SAFE_NONCE);

    final String toEncode = nonce + apiKey;

    try {
      byte[] sig = getMac().doFinal(toEncode.getBytes(UTF_8));
      String signature = DigestUtils.bytesToHex(sig);
      return signature;

    } catch (IllegalStateException | UnsupportedEncodingException e) {
      throw new ExchangeException("Could not sign the request", e);
    }
  }
}
