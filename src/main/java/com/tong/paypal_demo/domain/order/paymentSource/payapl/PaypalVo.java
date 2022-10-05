package com.tong.paypal_demo.domain.order.paymentSource.payapl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by tong on 2022/10/05
 */
@Data
@Accessors(chain = true)
public class PaypalVo {

    @JsonProperty(value = "email_address")
    private String emailAddress;
    @JsonProperty(value = "account_id")
    private String accountId;
    private NameVo name;
    private AddressVo address;

}
