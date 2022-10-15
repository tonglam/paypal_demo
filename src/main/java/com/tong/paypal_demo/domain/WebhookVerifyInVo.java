package com.tong.paypal_demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Create by tong on 2022/10/15
 */
@Data
@Accessors(chain = true)
public class WebhookVerifyInVo {

    @JsonProperty(value = "webhook_id")
    private String webhookId;
    @JsonProperty(value = "transmission_id")
    private String transmissionId;
    @JsonProperty(value = "transmission_time")
    private String transmissionTime;
    @JsonProperty(value = "transmission_sig")
    private String transmissionSig;
    @JsonProperty(value = "cert_url")
    private String certUrl;
    @JsonProperty(value = "auth_algo")
    private String authAlgo;
    @JsonProperty(value = "webhook_event")
    private WebhookEventDataVo webhookEvent;

}
