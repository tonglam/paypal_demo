package com.tong.paypal_demo.domain.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by tong on 2022/10/04
 */
@Data
@Accessors(chain = true)
public class ApplicationContextVo {

    @JsonProperty(value = "cancel_url")
    private String cancelUrl; // 取消支付的跳转地址
    @JsonProperty(value = "return_url")
    private String returnUrl; // 完成支付的跳转地址

}
