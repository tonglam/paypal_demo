package com.tong.paypal_demo.domain.token;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created by tong on 2022/10/05
 */
@Data
@Accessors(chain = true)
public class TokenClientMetadataVo {

    private String name;
    @JsonProperty(value = "display_name")
    private String displayName;
    @JsonProperty(value = "logo_uri")
    private String logoUri;
    private List<String> scopes;
    @JsonProperty(value = "ui_type")
    private String uiType;

}
