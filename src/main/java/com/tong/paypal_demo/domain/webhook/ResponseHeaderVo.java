package com.tong.paypal_demo.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Create by tong on 2022/10/14
 */
@Data
@Accessors(chain = true)
public class ResponseHeaderVo {

    @JsonProperty(value = "Date")
    private String date;
    @JsonProperty(value = "Content-Length")
    private String contentLength;
    @JsonProperty(value = "HTTP/1.1 502 Bad Gateway")
    private String gateway;
    @JsonProperty(value = "SERVER_INFO")
    private String serverInfo;
    @JsonProperty(value = "Connection")
    private String connection;
    @JsonProperty(value = "Server")
    private String server;

}
