package com.tong.paypal_demo.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Create by tong on 2022/10/14
 */
@Data
@Accessors(chain = true)
public class TransmissionVo {

    @JsonProperty(value = "webhook_url")
    private String webhookUrl;
    @JsonProperty(value = "response_headers")
    private ResponseHeaderVo responseHeaders;
    @JsonProperty(value = "transmission_id")
    private String transmissionId;
    private String status;
    private String timestamp;

}
