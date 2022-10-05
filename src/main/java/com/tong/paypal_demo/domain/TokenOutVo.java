package com.tong.paypal_demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tong.paypal_demo.domain.token.TokenClientMetadataVo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created by tong on 2022/10/05
 */
@Data
@Accessors(chain = true)
public class TokenOutVo {

    private String scope;
    @JsonProperty(value = "access_token")
    private String accessToken;
    @JsonProperty(value = "token_type")
    private String tokenType;
    @JsonProperty(value = "app_id")
    private String appId;
    @JsonProperty(value = "expires_in")
    private Long expiresIn;
    @JsonProperty(value = "supported_authn_schemes")
    private List<String> supportedAuthnSchemes;
    private String nonce;
    @JsonProperty(value = "client_metadata")
    private TokenClientMetadataVo clientMetadata;

}
