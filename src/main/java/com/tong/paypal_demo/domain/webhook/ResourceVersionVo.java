package com.tong.paypal_demo.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Create by tong on 2022/10/14
 */
@Data
@Accessors(chain = true)
public class ResourceVersionVo {

    @JsonProperty(value = "resource_version")
    private String resourceVersion;

}
