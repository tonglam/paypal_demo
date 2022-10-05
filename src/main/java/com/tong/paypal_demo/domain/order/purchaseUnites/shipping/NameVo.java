package com.tong.paypal_demo.domain.order.purchaseUnites.shipping;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by tong on 2022/10/05
 */
@Data
@Accessors(chain = true)
public class NameVo {

    @JsonProperty(value = "full_name")
    private String fullName;

}
