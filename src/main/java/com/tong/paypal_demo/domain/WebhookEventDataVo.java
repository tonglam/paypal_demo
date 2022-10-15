package com.tong.paypal_demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tong.paypal_demo.domain.order.LinkDescriptionVo;
import com.tong.paypal_demo.domain.webhook.ResourceVo;
import com.tong.paypal_demo.domain.webhook.TransmissionVo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Create by tong on 2022/10/14
 */
@Data
@Accessors(chain = true)
public class WebhookEventDataVo {

    private String id;
    @JsonProperty(value = "create_time")
    private String createTime;
    @JsonProperty(value = "resource_type")
    private String resourceType;
    @JsonProperty(value = "event_type")
    private String eventType;
    private String summary;
    private ResourceVo resource;
    private String status;
    private List<TransmissionVo> transmissions;
    private List<LinkDescriptionVo> links;
    @JsonProperty(value = "event_version")
    private String eventVersion;
    @JsonProperty(value = "resource_version")
    private String resourceVersion;

}
