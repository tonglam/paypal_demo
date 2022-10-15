package com.tong.paypal_demo.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Create by tong on 2022/10/14
 */
@Data
@Accessors(chain = true)
public class EventTypeVo {

    private String name;
    private String description;
    @JsonProperty(value = "resource_versions")
    private List<ResourceVersionVo> resourceVersions;
    private String status;

}
