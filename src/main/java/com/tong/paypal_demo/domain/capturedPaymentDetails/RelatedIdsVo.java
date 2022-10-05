package com.tong.paypal_demo.domain.capturedPaymentDetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by tong on 2022/10/05
 */
@Data
@Accessors(chain = true)
public class RelatedIdsVo {

    @JsonProperty(value = "order_id")
    private String orderId;

}
