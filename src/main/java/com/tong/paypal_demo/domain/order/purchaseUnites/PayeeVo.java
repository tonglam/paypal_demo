package com.tong.paypal_demo.domain.order.purchaseUnites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by tong on 2022/10/04
 */
@Data
@Accessors(chain = true)
public class PayeeVo {

    @JsonProperty(value = "email_address")
    private String emailAddress; // 邮箱
    @JsonProperty(value = "merchant_id")
    private String merchantId; // 商户ID

}
