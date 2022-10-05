package com.tong.paypal_demo.domain.order.purchaseUnites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by tong on 2022/10/04
 */
@Data
@Accessors(chain = true)
public class ItemVo {

    private String name; //
    private String description;
    private String quantity;
    @JsonProperty(value = "unit_amount")
    private AmountVo unitAmount;

}
